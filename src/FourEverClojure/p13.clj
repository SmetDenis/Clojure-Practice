(ns FourEverClojure.p13
  (:require [clojure.test :refer [deftest is]]))

; Problem 13, rest
; Difficulty: elementary
; The rest function will return all the items of a sequence except the first.

(def __ [20 30 40])

(deftest problem-test
  (is (= __ (rest [10 20 30 40]))))
