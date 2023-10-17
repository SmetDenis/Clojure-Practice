(ns code_basics.p1-basic-test
  (:require [clojure.test :refer [deftest is]]))

; 1. https://code-basics.com/ru/languages/clojure/lessons/hello-world
(deftest basic-test-1
  (is (= "Hello, World!" "Hello, World!")))

; 2. https://code-basics.com/ru/languages/clojure/lessons/prefix-notation
; 1 + 10 - 2 * 7
(deftest basic-test-2
  (is (= -3 (- (+ 1 10) (* 2 7)))))

; 3. https://code-basics.com/ru/languages/clojure/lessons/forms
; -23 * (- 3) + 15
(deftest basic-test-3
  (is (= 84 (+ 15 (* -23 -3)))))

; 4. https://code-basics.com/ru/languages/clojure/lessons/evaluation-order
; 100 - 34 - 22 - (5 + 3 - 10)
(deftest basic-test-4
  (is (= 46 (- 100 34 22 (- (+ 5 3) 10)))))

; 5. https://code-basics.com/ru/languages/clojure/lessons/jvm-errors
; "256" => 256
(deftest basic-test-5
  (is (= 256 (Integer/parseInt "256"))))
