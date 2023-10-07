(ns CodeBasics.l03-Logic
  (:require [clojure.string :refer [upper-case]]))

; 13. Or/And
(defn leap-year? [x]
  (if (= (rem x 100) 0) (= (rem x 400) 0) (= (rem x 4) 0)))

(defn leap-year? [year]
  (letfn [(divisible? [a b] (zero? (mod a b)))]
    (and (divisible? year 4) (or (not (divisible? year 100)) (divisible? year 400)))))

(leap-year? 2012)                                           ; true
(leap-year? 1913)                                           ; false
(leap-year? 1804)                                           ; true
(leap-year? 2100)                                           ; false

; 14. If/else
(defn sentence-type [text]
  (if (= (upper-case text) text) "cry" "common"))
(sentence-type "HOW ARE YOU?")                              ; "cry"
(sentence-type "Hello, world!")                             ; "common"

; 15. When
(defn say-boom [x]
  (when (= x "go") "Boom!"))
(say-boom "hey")
(say-boom "go")                                             ; "Boom!"

; 16. Case/Switch
(defn humanize-permission [x]
  (case x
    "x" "execute"
    "r" "read"
    "w" "write"))
(humanize-permission "x")                                   ; execute
(humanize-permission "r")                                   ; read
(humanize-permission "w")                                   ; write

; 17. Cond
(defn programmer-level [x]
  (cond
    (< x 10) "junior"
    (< x 20) "middle"
    :else "senior"))

(defn programmer-level [points-count]
  (cond
    (< points-count 10) "junior"
    (and (>= points-count 10) (< points-count 20)) "middle"
    :else "senior"))

(programmer-level 10)                                       ; middle
(programmer-level 0)                                        ; junior
(programmer-level 40)                                       ; senior

; 18. Complex conditions
(defn do-today [x]
  (case x
    (1 2 3 4 5) "work"
    (6 7) "rest"
    "???"))

(defn do-today [day-of-week]
  (cond
    (and (int? day-of-week)
         (<= 1 day-of-week 7))
    (case day-of-week
      (6 7) "rest"
      "work")
    :else "???"))
