(ns four_clojure_org.p001_10.p7-test
  (:require [clojure.test :refer [deftest is]]))

; Problem 7, conj on vectors
; Difficulty: elementary
; When operating on a Vector, the conj function will return a new vector with
; one or more items "added" to the end.

(def __ [1 2 3 4])

(deftest problem-test
  (is (= __ (conj [1 2 3] 4)))
  (is (= __ (conj [1 2] 3 4))))