(ns FourEverClojure.p14
  (:require [clojure.test :refer [deftest is]]))

; Problem 14, Functions
; Difficulty: elementary
; Clojure has many different ways to create functions.

(def __ 8)

(deftest problem-test
  (is (= __ ((fn add-five [x] (+ x 5)) 3)))
  (is (= __ ((fn [x] (+ x 5)) 3)))
  (is (= __ (#(+ % 5) 3)))
  (is (= __ ((partial + 5) 3))))
