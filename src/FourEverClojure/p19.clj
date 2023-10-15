(ns FourEverClojure.p19
  (:require [clojure.test :refer [deftest is]]))

; Problem 19, Last Element
; Difficulty: easy
; Write a function which returns the last element in a sequence.

; Special Restrictions : last

(def __ #(first (reverse %)))

(deftest problem-test
  (is (= (__ [1 2 3 4 5]) 5))
  (is (= (__ '(5 4 3)) 3))
  (is (= (__ ["b" "c" "d"]) "d")))
