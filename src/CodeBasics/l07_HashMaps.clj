(ns CodeBasics.l07-HashMaps)

; 34. Hashes - intro
(defn resolve
  [domains domain]
  (get domains domain "DNS_PROBE_FINISHED_NXDOMAIN"))

(resolve {"rubyonrails.org"      "211.116.107.5"
          "clojure.org"          "103.95.84.1"
          "phoenixframework.org" "234.214.199.63"
          "reactjs.org"          "20.199.101.214"}
         "clojure.org")                                     ; => "103.95.84.1"
(resolve {"rhythm.ru"   "201.116.147.4"
          "building.ru" "103.176.11.27"
          "hexlet.io"   "234.214.199.63"
          "brass.ru"    "201.116.147.4"}
         "hexlet.io")                                       ; => "234.214.199.63"
(resolve {"some.com" "127.0.0.1"} "test.net")               ; => "DNS_PROBE_FINISHED_NXDOMAIN"

; 35. Hashes - extra
(defn freq
  [col]
  (frequencies col))

(defn freq-2
  [v]
  (reduce (fn [acc x] (assoc acc x (inc (get acc x 0)))) {} v))

(freq ["a" "b" "c" "a" "a" "c" "a" "d" "b"])                ; => {"a" 4, "b" 2, "c" 2, "d" 1}
(freq [])                                                   ; => {}
(freq ["Clojure" "Ruby"
       "Clojure" "Elixir" "Ruby" "HTML" "JS"])              ; => {"Clojure" 2, "Ruby" 2, "Elixir" 1, "HTML" 1, "JS" 1}
(freq [10 10 10 20 300 41 53])                              ; => {10 3, 20 1, 300 1, 41 1, 53 1}
(freq [:a :b :c :d :a :a])                                  ; => {:a 3, :b 1, :c 1, :d 1}

; 36. Sorted maps
(defn to-sorted-map
  [hash-coll]
  (into (sorted-map) hash-coll))

(to-sorted-map {3 :c
                2 :b
                1 :a})                                      ; => {1 :a, 2 :b, 3 :c}
(to-sorted-map {})                                          ; => {}
(to-sorted-map {"c" 3
                "b" 2
                "a" 1})                                     ; => {"a" 1, "b" 2, "c" 3}
(to-sorted-map {:c 3,
                :b 2,
                :a 1})                                      ; => {:a 1, :b 2, :c 3}
