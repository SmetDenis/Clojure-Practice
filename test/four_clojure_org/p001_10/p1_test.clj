(ns four_clojure_org.p001_10.p1-test
  (:require [clojure.test :refer [deftest is]]))

; Problem 1, Nothing but the Truth
; Difficulty: elementary
; Complete the expression, so it will evaluate to true.

(def __ true)

(deftest problem-test
  (is (= __ true)))
