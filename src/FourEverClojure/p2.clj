(ns FourEverClojure.p2
  (:require [clojure.test :refer [deftest is]]))

; Problem 2, Simple Math
; Difficulty: elementary
; Innermost forms are evaluated first.

(def __ 4)

(deftest problem-test
  (is (= (- 10 (* 2 3)) __)))
