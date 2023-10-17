(ns four_clojure_org.p001_10.p4-test
  (:require [clojure.test :refer [deftest is]]))

; Problem 4, Lists
; Difficulty: elementary
; Lists can be constructed with either a function or a quoted form.

(def __ (list :a :b :c))

(deftest problem-test
  (is (= __ '(:a :b :c))))
