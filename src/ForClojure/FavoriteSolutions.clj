(ns ForClojure.FavoriteSolutions)

(def sss (range 100))

; 19. No 'last
(time (#(first (reverse %)) sss))

; 20. Penultimate Element
; Write a function which returns the second to last element from a sequence.
;(time (#(last (take (- (count %) 1) %)) sss))
;(time (#(second (reverse %)) sss))
;(time ((comp first take-last) 2 sss))
;(time (#(first (rest (reverse %))) sss))

; 21, Nth Element
(last '(4 5 6 7))
(comment
 (+ 1 2))
