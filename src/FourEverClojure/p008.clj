(ns FourEverClojure.p008
  (:require [clojure.test :refer [deftest is]]))

; Problem 8, Sets
; Difficulty: elementary
; Sets are collections of unique values.

(def __ #{:c :b :d :a})

(deftest problem-test
  (is (= __ (set '(:a :a :b :c :c :c :c :d :d))))
  (is (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))))