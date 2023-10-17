(ns four_clojure_org.p011_20.p17-test
  (:require [clojure.test :refer [deftest is]]))

; Problem 17, map
; Difficulty: elementary
; The map function takes two arguments: a function (f) and a sequence (s).
; Map returns a new sequence consisting of the result of applying f to each item of s.
; Do not confuse the map function with the map data structure.

(def __ '(6 7 8))

(deftest problem-test
  (is (= __ (map #(+ % 5) '(1 2 3)))))
