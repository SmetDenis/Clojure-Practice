(ns FourEverClojure.p9
  (:require [clojure.test :refer [deftest is]]))

; Problem 9, conj on sets
; Difficulty: elementary
; When operating on a set, the conj function returns a new set with one or
; more keys "added".

(def __ 2)

(deftest problem-test
  (is (= #{1 2 3 4} (conj #{1 4 3} __))))
