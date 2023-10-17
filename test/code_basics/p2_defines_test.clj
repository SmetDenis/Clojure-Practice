(ns code_basics.p2-defines-test
  (:require [clojure.test :refer [deftest is]]))

; 6. https://code-basics.com/ru/languages/clojure/lessons/definitions-define
(def members (atom 0))
(reset! members 10)
(deftest defines-test-6
  (is (= 10 @members)))

; 7. https://code-basics.com/ru/languages/clojure/lessons/definitions-defonce
(def my-var "5")
(defonce something 123)
(deftest defines-test-7
  (is (= "5" my-var))
  (is (= 123 something)))

; 8. https://code-basics.com/ru/languages/clojure/lessons/definitions-define-functions
(defn square
  [x]
  (* x x))

(deftest defines-test-8
  (is (= 9 (square 3)))
  (is (= 15129 (square 123))))

; 9. https://code-basics.com/ru/languages/clojure/lessons/definitions-lambda-call
(def my-lamda ((fn [x y] (/ (+ x y) 2)) 2 4))
(deftest defines-test-9
  (is (= 3 my-lamda)))

; 10. https://code-basics.com/ru/languages/clojure/lessons/function-shorthand
(defn sum-of-squares
  [x y]
  (+ (* x x) (* y y)))

(deftest defines-test-10
  (is (= 13 (sum-of-squares 2 3))))

; 11. https://code-basics.com/ru/languages/clojure/lessons/namespaces
(deftest defines-test-11)
; (ns my-ns                                               ; Определяем наше пространство имен, импортируем math
;   (:require [math :as m])                               ; Переименовываем для упрощения
;   (defn my-cube [x] (m/cube x)))                        ; Ссылаемся на форму cube в пространстве имен math

; 12. https://code-basics.com/ru/languages/clojure/lessons/let
(defn prod-sum
  [x]
  (let [prod (* x x)]
    (+ x prod)))

(deftest defines-test-12
  (is (= 2 (prod-sum 1)))
  (is (= 6 (prod-sum 2)))
  (is (= 12 (prod-sum 3)))
  (is (= 20 (prod-sum 4))))
