(ns code_basics.p5-vectors-test
  (:require [clojure.string]
            [clojure.test :refer [deftest is]]))

; 28. https://code-basics.com/ru/languages/clojure/lessons/intro-vectors
(defn zip
  [v1 v2]
  (mapv vector v1 v2))

(defn zip-2
  [v1 v2]
  (mapv (fn [x y] (vector x y)) v1 v2))

(deftest logic-test-26
  (is (= []
         (zip [] [])))
  (is (= [[1 5] [2 6] [3 7] [4 8]]
         (zip [1 2 3 4] [5 6 7 8])))
  (is (= [[1 3] [2 4]]
         (zip [1 2] [3 4])))

  (is (= []
         (zip-2 [] [])))
  (is (= [[1 5] [2 6] [3 7] [4 8]]
         (zip-2 [1 2 3 4] [5 6 7 8])))
  (is (= [[1 3] [2 4]]
         (zip-2 [1 2] [3 4]))))

; 29. https://code-basics.com/ru/languages/clojure/lessons/vectors-choose
(defn sum
  [v]
  (reduce + v))

(defn sum-2
  [v]
  (reduce #(+ %1 %2) 0 v))

(deftest logic-test-29
  (is (= 0 (sum [])))
  (is (= -10 (sum [10 -20])))
  (is (= 0 (sum [0 10 -10])))
  (is (= 10 (sum [1 2 3 4]))))

; 30. https://code-basics.com/ru/languages/clojure/lessons/contains
(defn my-contains?
  [coll elem]
  (boolean (some #(= elem %) coll)))

(deftest logic-test-30
  (is (= true (my-contains? [1 2 4 9] 2)))
  (is (= false (my-contains? [1 2 4 9] 0)))
  (is (= true (my-contains? [1 2 4 9] 9))))

; 31. https://code-basics.com/ru/languages/clojure/lessons/immutable-structures
(defn partiphify
  [numbers parts]
  (let [part        (int (Math/ceil (/ (count numbers) parts)))
        divided-vec (vec (map vec (partition-all part numbers)))
        final-vec   (if (not= (count divided-vec) parts) (conj divided-vec []) divided-vec)]
    final-vec))

(deftest logic-test-31
  (is (= [[1] []] (partiphify [1] 2)))
  (is (= [[1] [2] [3]] (partiphify [1 2 3] 3)))
  (is (= [[1 2 3] [4 5]] (partiphify [1 2 3 4 5] 2))))

; 32. https://code-basics.com/ru/languages/clojure/lessons/transducers
(def my-xf
  (comp
    (map #(* % 10))
    (map #(/ % 5))
    (filter even?)))

(deftest logic-test-32
  (is (= '(0 2 4 6 8)
         (->> (range 5)
              (map #(* % 10))
              (map #(/ % 5))
              (filter even?))))

  (is (= 90 (transduce my-xf + (range 10))))
  (is (= 2450 (transduce my-xf + (range 50))))
  (is (= 8010 (transduce my-xf + (range 90))))

  (is (= [0 2 4 6 8] (into [] my-xf (range 5))))
  (is (= [0 2 4 6 8 10 12 14 16 18] (into [] my-xf (range 10))))
  (is (= 2450 (sum (into [] my-xf (range 50)))))
  (is (= 8010 (sum (into [] my-xf (range 90))))))

; 33. https://code-basics.com/ru/languages/clojure/lessons/transducers-creation
(defn student-names
  ([] (map first))
  ([students] (sequence (student-names) students)))
(defn lowercase-names
  ([] (map clojure.string/lower-case))
  ([students] (sequence (lowercase-names) students)))
(defn slugify-names
  ([] (map #(clojure.string/replace % #" " "-")))
  ([students] (sequence (slugify-names) students)))

(def do-name-magic
  (comp
    (student-names)
    (lowercase-names)
    (slugify-names)))

(deftest logic-test-33
  (is (= []
         (into [] do-name-magic [])))

  (is (= ["harry-potter"]
         (into [] do-name-magic [["Harry Potter" "Magic"]])))

  (is (= ["luke-skywalker" "hermione-granger" "walter-white"]
         (into [] do-name-magic [["Luke Skywalker" "Jedi"]
                                 ["Hermione Granger" "Magic"]
                                 ["Walter White" "Chemistry"]]))))
