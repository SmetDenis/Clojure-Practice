(ns CodeBasics.l01_Basic)

; 1. Classic
(println "Hello, World!")

; 2. 1 + 10 - 2 * 7
(println (- (+ 1 10) (* 2 7)))

; 3. - 23 * (- 3) + 15
(println (+ 15 (* -23 -3)))

; 4. 100 - 34 - 22 - (5 + 3 - 10)
(println (- 100 34 22 (- (+ 5 3) 10)))

; 5. 256
(print (Integer/parseInt "256"))
