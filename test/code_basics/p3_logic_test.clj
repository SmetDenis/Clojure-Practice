(ns code_basics.p3-logic-test
  (:require [clojure.string :refer [upper-case]]
            [clojure.test :refer [deftest is]]))

; 13. https://code-basics.com/ru/languages/clojure/lessons/bool-type
(defn leap-year?
  [x]
  (if (= (rem x 100) 0) (= (rem x 400) 0) (= (rem x 4) 0)))

(defn leap-year-2?
  [year]
  (letfn [(divisible? [a b] (zero? (mod a b)))]
    (and (divisible? year 4) (or (not (divisible? year 100)) (divisible? year 400)))))

(deftest logic-test-13
  (is (= true (leap-year? 2012)))
  (is (= false (leap-year? 1913)))
  (is (= true (leap-year? 1804)))
  (is (= false (leap-year? 2100)))

  (is (= true (leap-year-2? 2012)))
  (is (= false (leap-year-2? 1913)))
  (is (= true (leap-year-2? 1804)))
  (is (= false (leap-year-2? 2100))))

; 14. https://code-basics.com/ru/languages/clojure/lessons/if
(defn sentence-type
  [text]
  (if (= (upper-case text) text) "cry" "common"))

(deftest logic-test-14
  (is (= "cry" (sentence-type "HOW ARE YOU?")))
  (is (= "common" (sentence-type "Hello, world!")))
  (is (= "cry" (sentence-type "HOW?")))
  (is (= "common" (sentence-type "HoW?")))
  (is (= "common" (sentence-type "clojure")))
  (is (= "cry" (sentence-type "CLOJURE"))))

; 15. https://code-basics.com/ru/languages/clojure/lessons/guards
(defn say-boom
  [x]
  (when (= x "go") "Boom!"))

(deftest logic-test-15
  (is (= nil (say-boom "hey")))
  (is (= "Boom!" (say-boom "go"))))

; 16. https://code-basics.com/ru/languages/clojure/lessons/case
(defn humanize-permission
  [x]
  (case x
    "x" "execute"
    "r" "read"
    "w" "write"
    nil))

(deftest logic-test-16
  (is (= "execute" (humanize-permission "x")))
  (is (= "read" (humanize-permission "r")))
  (is (= "write" (humanize-permission "w")))
  (is (= nil (humanize-permission "qwerty"))))

; 17. https://code-basics.com/ru/languages/clojure/lessons/cond
(defn programmer-level
  [x]
  (cond
    (< x 10) "junior"
    (< x 20) "middle"
    :else "senior"))

(defn programmer-level-2
  [points-count]
  (cond
    (< points-count 10) "junior"
    (and (>= points-count 10) (< points-count 20)) "middle"
    :else "senior"))

(deftest logic-test-17
  (is (= "middle" (programmer-level 10)))
  (is (= "junior" (programmer-level 0)))
  (is (= "senior" (programmer-level 40)))

  (is (= "middle" (programmer-level-2 10)))
  (is (= "junior" (programmer-level-2 0)))
  (is (= "senior" (programmer-level-2 40))))

; 18. https://code-basics.com/ru/languages/clojure/lessons/expressions
(defn do-today
  [x]
  (case x
    (1 2 3 4 5) "work"
    (6 7) "rest"
    "???"))

(defn do-today-2
  [day-of-week]
  (cond
    (and (int? day-of-week)
         (<= 1 day-of-week 7))
    (case day-of-week
      (6 7) "rest"
      "work")
    :else "???"))

(deftest logic-test-18
  (is (= "work" (do-today 1)))
  (is (= "work" (do-today 2)))
  (is (= "work" (do-today 3)))
  (is (= "work" (do-today 4)))
  (is (= "work" (do-today 5)))
  (is (= "rest" (do-today 6)))
  (is (= "rest" (do-today 7)))
  (is (= "???" (do-today 0)))
  (is (= "???" (do-today -1)))
  (is (= "???" (do-today 10)))
  (is (= "???" (do-today false)))
  (is (= "???" (do-today "oops")))

  (is (= "work" (do-today-2 1)))
  (is (= "work" (do-today-2 2)))
  (is (= "work" (do-today-2 3)))
  (is (= "work" (do-today-2 4)))
  (is (= "work" (do-today-2 5)))
  (is (= "rest" (do-today-2 6)))
  (is (= "rest" (do-today-2 7)))
  (is (= "???" (do-today-2 0)))
  (is (= "???" (do-today-2 -1)))
  (is (= "???" (do-today-2 10)))
  (is (= "???" (do-today-2 false)))
  (is (= "???" (do-today-2 "oops"))))
