(ns four_clojure_org.p011_20.p16-test
  (:require [clojure.test :refer [deftest is]]))

; Problem 16, Hello World
; Difficulty: elementary
; Write a function which returns a personalized greeting.

(def __ #(str "Hello, " % "!"))

(deftest problem-test
  (is (= (__ "Dave") "Hello, Dave!"))
  (is (= (__ "Jenn") "Hello, Jenn!"))
  (is (= (__ "Rhea") "Hello, Rhea!")))
