(ns four_clojure_org.p011_20.p11-test
  (:require [clojure.test :refer [deftest is]]))

; Problem 11, conj on maps
; Difficulty: elementary
; When operating on a map, the conj function returns a new map with one or
; more key-value pairs "added".

(def __ [:b 2])

(deftest problem-test
  (is (= {:a 1,
:b 2,
:c 3} (conj {:a 1} __ [:c 3]))))