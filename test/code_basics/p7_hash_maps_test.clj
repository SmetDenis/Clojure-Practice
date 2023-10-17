(ns code_basics.p7-hash-maps-test
  (:require [clojure.test :refer [deftest is]]))

; 34. https://code-basics.com/ru/languages/clojure/lessons/intro-hashes
(defn my-resolve
  [domains domain]
  (get domains domain "DNS_PROBE_FINISHED_NXDOMAIN"))

(deftest logic-test-34
  (is (= "103.95.84.1"
         (my-resolve {"rubyonrails.org"   "211.116.107.5"
                   "clojure.org"          "103.95.84.1"
                   "phoenixframework.org" "234.214.199.63"
                   "reactjs.org"          "20.199.101.214"}
                     "clojure.org")))

  (is (= "234.214.199.63"
         (my-resolve {"rhythm.ru" "201.116.147.4"
                   "building.ru"  "103.176.11.27"
                   "hexlet.io"    "234.214.199.63"
                   "brass.ru"     "201.116.147.4"}
                     "hexlet.io")))

  (is (= "DNS_PROBE_FINISHED_NXDOMAIN"
         (my-resolve {"some.com" "127.0.0.1"} "test.net"))))

; 35. https://code-basics.com/ru/languages/clojure/lessons/more-hashes
(defn freq
  [col]
  (frequencies col))

(defn freq-2
  [v]
  (reduce (fn [acc x] (assoc acc x (inc (get acc x 0)))) {} v))

(deftest logic-test-35
  (is (= {} (freq [])))
  (is (= {"a" 4,
          "b" 2,
          "c" 2,
          "d" 1}
         (freq ["a" "b" "c" "a" "a" "c" "a" "d" "b"])))
  (is (= {"Clojure" 2,
          "Ruby"    2,
          "Elixir"  1,
          "HTML"    1,
          "JS"      1}
         (freq ["Clojure" "Ruby" "Clojure" "Elixir" "Ruby" "HTML" "JS"])))
  (is (= {10  3,
          20  1,
          300 1,
          41  1,
          53  1}
         (freq [10 10 10 20 300 41 53])))
  (is (= {:a 3,
          :b 1,
          :c 1,
          :d 1}
         (freq [:a :b :c :d :a :a])))

  (is (= {} (freq-2 [])))
  (is (= {"a" 4,
          "b" 2,
          "c" 2,
          "d" 1}
         (freq-2 ["a" "b" "c" "a" "a" "c" "a" "d" "b"])))
  (is (= {"Clojure" 2,
          "Ruby"    2,
          "Elixir"  1,
          "HTML"    1,
          "JS"      1}
         (freq-2 ["Clojure" "Ruby" "Clojure" "Elixir" "Ruby" "HTML" "JS"])))
  (is (= {10  3,
          20  1,
          300 1,
          41  1,
          53  1}
         (freq-2 [10 10 10 20 300 41 53])))
  (is (= {:a 3,
          :b 1,
          :c 1,
          :d 1}
         (freq-2 [:a :b :c :d :a :a]))))

; 36. https://code-basics.com/ru/languages/clojure/lessons/sorted-maps
(defn to-sorted-map
  [hash-coll]
  (into (sorted-map) hash-coll))

(deftest logic-test-36
  (is (= {} (to-sorted-map {})))
  (is (= {1 :a,
          2 :b,
          3 :c}
         (to-sorted-map {3 :c
                         2 :b
                         1 :a})))
  (is (= {"a" 1,
          "b" 2,
          "c" 3}
         (to-sorted-map {"c" 3
                         "b" 2
                         "a" 1})))
  (is (= {:a 1,
          :b 2,
          :c 3}
         (to-sorted-map {:c 3
                         :b 2
                         :a 1}))))