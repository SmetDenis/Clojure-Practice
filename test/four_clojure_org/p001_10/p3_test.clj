(ns four_clojure_org.p001_10.p3-test
  (:require [clojure.test :refer [deftest is]]))

; Problem 3, Strings
; Difficulty: elementary
; Clojure strings are Java strings, so you can use Java string methods on them.

(def __ "HELLO WORLD")

(deftest problem-test
  (is (= __ (.toUpperCase "hello world"))))
