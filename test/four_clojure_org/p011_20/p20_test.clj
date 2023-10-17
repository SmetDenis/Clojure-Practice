(ns four_clojure_org.p011_20.p20-test
  (:require [clojure.test :refer [deftest is]]))

; Problem 20, Penultimate Element
; Difficulty: easy
; Write a function which returns the second to last element from a sequence.

(def __ #(first (rest (reverse %))))

(deftest problem-test
  (is (= (__ (list 1 2 3 4 5)) 4))
  (is (= (__ ["a" "b" "c"]) "b"))
  (is (= (__ [[1 2] [3 4]]) [1 2])))
