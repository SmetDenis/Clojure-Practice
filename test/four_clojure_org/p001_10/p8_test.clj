(ns four_clojure_org.p001_10.p8-test
  (:require [clojure.set :refer [union]]
            [clojure.test :refer [deftest is]]))

; Problem 8, Sets
; Difficulty: elementary
; Sets are collections of unique values.

(def __ #{:c :b :d :a})

(deftest problem-test
  (is (= __ (set '(:a :a :b :c :c :c :c :d :d))))
  (is (= __ (union #{:a :b :c} #{:b :c :d}))))