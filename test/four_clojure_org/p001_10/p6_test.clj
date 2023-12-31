(ns four_clojure_org.p001_10.p6-test
  (:require [clojure.test :refer [deftest is]]))

; Problem 6, Vectors
; Difficulty: elementary
; Vectors can be constructed several ways. You can compare them with lists.

(def __ [:a :b :c])

(deftest problem-test
  (is (= __ (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))))
