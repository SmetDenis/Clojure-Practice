(ns four_clojure_org.p011_20.p18-test
  (:require [clojure.test :refer [deftest is]]))

; Problem 18, filter
; Difficulty: elementary
; The filter function takes two arguments: a predicate function (f) and a
; sequence (s). Filter returns a new sequence consisting of all the items
; of s for which (f item) returns true.

(def __ '(6 7))

(deftest problem-test
  (is (= __ (filter #(> % 5) '(3 4 5 6 7)))))
