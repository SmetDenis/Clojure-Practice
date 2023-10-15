(ns FourEverClojure.p10
  (:require [clojure.test :refer [deftest is]]))

; Problem 10, Maps
; Difficulty: elementary
; Maps store key-value pairs. Both maps and keywords can be used as lookup
; functions. Commas are whitespace.

(def __ (:b {:a 10
:b 20
:c 30}))

(deftest problem-test
  (is (= __ ((hash-map :a 10, :b 20, :c 30) :b)))
  (is (= __ (:b {:a 10,
:b 20,
:c 30}))))
