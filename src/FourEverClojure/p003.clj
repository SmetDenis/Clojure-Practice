(ns FourEverClojure.p003
  (:require [clojure.test :refer [deftest is]]))

; Problem 3, Strings
; Difficulty: elementary
; Clojure strings are Java strings, so you can use Java string methods on them.

(def __ "HELLO WORLD")

(deftest problem-test
  (is (= __ (.toUpperCase "hello world"))))
