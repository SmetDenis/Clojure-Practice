(ns CodeBasics.l06-Vectors)

; 28. Vectors
(defn zip [v1 v2]
  (mapv vector v1 v2))

(defn zip-2 [v1 v2]
  (mapv (fn [x y] (vector x y)) v1 v2))

(zip [] [])                                                 ; => []
(zip [1 2 3 4] [5 6 7 8])                                   ; => [[1 5] [2 6] [3 7] [4 8]]
(zip [1 2] [3 4])                                           ; => [[1 3] [2 4]]

; 29. Vectors choose
(defn sum [v]
  (reduce + v))

(defn sum-2 [v]
  (reduce #(+ %1 %2) 0 v))

(sum [])                                                    ; => 0
(sum [10 -20])                                              ; => -10
(sum [1 2 3 4])                                             ; => 10

; 30. Contains
(defn my-contains? [coll elem]
  (boolean (some #(= elem %) coll)))

(my-contains? [1 2 4 9] 2)                                  ; => true
(my-contains? [1 2 4 9] 0)                                  ; => false
(my-contains? [1 2 4 9] 9)                                  ; => true

; 31. Immutable structures
(defn partiphify [numbers parts]
  (let [part (int (Math/ceil (/ (count numbers) parts)))
        divided-vec (vec (map vec (partition-all part numbers)))
        final-vec (if (not= (count divided-vec) parts) (conj divided-vec []) divided-vec)]
    final-vec))

(partiphify [1] 2)                                          ; => [[1] []]
(partiphify [1 2 3] 3)                                      ; => [[1] [2] [3]]
(partiphify [1 2 3 4 5] 2)                                  ; => [[1 2 3] [4 5]]

; 32. Transducers
(def my-xf
  (comp
    (map #(* % 10))
    (map #(/ % 5))
    (filter even?)))

(->> (range 5)
     (map #(* % 10))
     (map #(/ % 5))
     (filter even?))                                        ; (0 2 4 6 8)
(into [] my-xf (range 10))                                  ; [0 2 4 6 8 10 12 14 16 18]
(transduce my-xf + (range 10))                              ; 90
