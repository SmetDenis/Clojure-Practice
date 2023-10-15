(ns CodeBasics.l04-Lists)

; 19. Define list
(defn triple [x]
      (list x x x))

(triple "a")                                                ; '("a" "a" "a")
(triple 0)                                                  ; '(0 0 0)

; 20. Map
(defn maps [funcs values]
      (map map funcs values))
(maps
  (list inc string?)
  (list (list 10 20) (list "a" 0)))                         ; '((11 21) (true false))

; 21. Builtin filters
(defn increment-numbers [l]
      (map inc (filter number? l)))
(increment-numbers (list 10 "foo" false (list 2 3) 3/5))    ; '(11 8/5)

; 22. Reduce
(defn max-delta [l1 l2]
      (let [max-abs (fn [acc x] (max acc (Math/abs x)))]
           (reduce max-abs 0 (map - l1 l2))))

(defn max-delta-1 [xs ys]
      (reduce (fn [acc [x y]] (max acc (Math/abs (- x y))))
              0 (map list xs ys)))
(max-delta
  (list 10 -15 35)
  (list 2 -12 42))                                          ; 8

; 23. List Internals
(def user-ages
  (list (list "Tom" 31)
        (list "Alice" 22)
        (list "Bob" 42)))

(defn lookup [key pairs]
      (letfn [(same-key? [kv] (= key (first kv)))]
             (let [found-pairs (filter same-key? pairs)]
                  (if (empty? found-pairs) false (first found-pairs)))))

(defn lookup-2 [find list]
      (let [result (first (filter (fn [item] (= find (first item))) list))]
           (if result result false)))

(lookup "Bob" user-ages)                                    ; '("Bob" . 42)
(lookup "Tom" user-ages)                                    ; '("Tom" . 31)
(lookup "Moe" user-ages)                                    ; false

; 24. List recursion
(defn skip [n l]
      (if (or (<= n 0) (empty? l)) l (skip (dec n) (rest l))))

;(defn skip-2 [num list]
;  (if (<= num 0) list
;    (if (> num (count list)) '()
;      (reduce (fn [acc x] (rest acc)) list (range 0 num)))))

(skip -5 (list 1 2 3))                                      ; '(1 2 3)
(skip 0 (list 1 2 3))                                       ; '(1 2 3)
(skip 1 (list 1 2 3))                                       ; '(2 3)
(skip 10 (list 1 2 3))                                      ; '()
