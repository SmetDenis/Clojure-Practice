(ns FourEverClojure.p5
  (:require [clojure.test :refer [deftest is]]))

; Problem 5, conj on lists
; Difficulty: elementary
; When operating on a list, the conj function will return
; a new list with one or more items "added" to the front.

(def __ '(1 2 3 4))

(deftest problem-test
  (is (= __ (conj '(2 3 4) 1)))
  (is (= __ (conj '(3 4) 2 1))))
