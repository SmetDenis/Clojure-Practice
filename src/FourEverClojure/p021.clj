(ns FourEverClojure.p021
  (:require [clojure.test :refer [deftest is]]))

; Problem 21, Nth Element
; Difficulty: easy
; Write a function which returns the Nth element from a sequence.

(def __ 1)

(deftest problem-test
  (is (= (__ '(4 5 6 7) 2) 6))
  (is (= (__ [:a :b :c] 0) :a))
  (is (= (__ [1 2 3 4] 1) 2))
  (is (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])))
