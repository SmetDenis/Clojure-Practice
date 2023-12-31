(ns four_clojure_org.p011_20.p12-test
  (:require [clojure.test :refer [deftest is]]))

; Problem 12, Sequences
; Difficulty: elementary
; All Clojure collections support sequencing. You can operate on sequences
; with functions like first, second, and last.

(def __ 3)

(deftest problem-test
  (is (= __ (first '(3 2 1))))
  (is (= __ (second [2 3 4])))
  (is (= __ (last (list 1 2 3)))))
