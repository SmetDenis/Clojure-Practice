(ns CodeBasics.l02_Defines)

; 6. Definitions
(def members (atom 0))
(reset! members 10)
(println @members)

; 7.  symbols
(def my-var "5")
;(defonce some 123)
(println my-var)

; 8. Functions
(defn square [x] (* x x))
(square 3)                                                  ; 9

; 9. Lambda
(def my-lamda ((fn [x y] (/ (+ x y) 2)) 2 4))
(println my-lamda)                                          ; 3

; 10.
(defn sum-of-squares [x y] (+ (* x x) (* y y)))
(sum-of-squares 2 3)                                        ; 13

; 11. Namespaces
;(ns my-ns                                                   ; определяем наше пространство имен, импортируем пространство math
;  (:require [math :as m])                                   ; переименовываем для упрощения
;  (defn my-cube [x] (m/cube x)))                            ; ссылаемся на форму cube в пространстве имен math

; 12. Let
(defn prod-sum [x]
      (let [prod (* x x)]
           (+ x prod)))
(prod-sum 2)                                                ; 6
(prod-sum 3)                                                ; 12
(prod-sum 4)                                                ; 20
