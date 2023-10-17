(ns four_clojure_org.p001_10.p10-test
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
