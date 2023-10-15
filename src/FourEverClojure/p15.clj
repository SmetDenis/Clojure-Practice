(ns FourEverClojure.p15
  (:require [clojure.test :refer [deftest is]]))

; Problem 15, Double Down
; Difficulty: elementary
; Write a function which doubles a number.

(def __ #(* % 2))

(deftest problem-test
  (is (= (__ 2) 4))
  (is (= (__ 3) 6))
  (is (= (__ 11) 22))
  (is (= (__ 7) 14)))
