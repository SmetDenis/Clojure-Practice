(ns code_basics.p4_lists-test
  (:require [clojure.test :refer [deftest is]]))

; 19. https://code-basics.com/ru/languages/clojure/lessons/intro
(defn triple
  [x]
  (list x x x))

(deftest logic-test-19
  (is (= '("a" "a" "a") (triple "a")))
  (is (= '(0 0 0) (triple 0))))

; 20. https://code-basics.com/ru/languages/clojure/lessons/builtin-loops-map
(defn maps
  [func-list values]
  (map map func-list values))

(deftest logic-test-20
  (is (= '((11 21) (true false))
         (maps
           (list inc string?)
           (list (list 10 20) (list "a" 0)))))

  (is (= (list)
         (maps (list) (list))))

  (is (= (list (list 1))
         (maps (list inc) (list (list 0)))))

  (is (= (list (list 1 101) (list true false))
         (maps (list inc string?) (list (list 0 100) (list "foo" 42))))))

; 21. https://code-basics.com/ru/languages/clojure/lessons/builtin-filters
(defn increment-numbers
  [l]
  (map inc (filter number? l)))

(deftest logic-test-21
  (is (= '(11 8/5)
         (increment-numbers (list 10 "foo" false (list 2 3) 3/5))))

  (is (= '()
         (increment-numbers '())))

  (is (= '()
         (increment-numbers '("a" "b" false))))

  (is (= '(2 3/2)
         (increment-numbers '(1 1/2 "foo")))))

; 22. https://code-basics.com/ru/languages/clojure/lessons/reduce
(defn max-delta
  [l1 l2]
  (let [max-abs (fn [acc x] (max acc (Math/abs x)))]
    (reduce max-abs 0 (map - l1 l2))))

(defn max-delta-2
  [xs ys]
  (reduce (fn [acc [x y]] (max acc (Math/abs (- x y))))
          0 (map list xs ys)))

(deftest logic-test-22
  (is (= 0 (max-delta '() '())))
  (is (= 10 (max-delta '(-5) '(-15))))
  (is (= 42 (max-delta '(0) '(42))))
  (is (= 8 (max-delta '(10 -15 35) '(2 -12 42))))

  (is (= 0 (max-delta-2 '() '())))
  (is (= 10 (max-delta-2 '(-5) '(-15))))
  (is (= 42 (max-delta-2 '(0) '(42))))
  (is (= 8 (max-delta-2 '(10 -15 35) '(2 -12 42)))))

; 23. https://code-basics.com/ru/languages/clojure/lessons/list-internals
(def user-ages
  (list (list "Tom" 31)
        (list "Alice" 22)
        (list "Bob" 42)))

(defn lookup
  [key pairs]
  (letfn [(same-key? [kv] (= key (first kv)))]
    (let [found-pairs (filter same-key? pairs)]
      (if (empty? found-pairs) false (first found-pairs)))))

(defn lookup-2
  [find list]
  (let [result (first (filter (fn [item] (= find (first item))) list))]
    (if result result false)))

(deftest logic-test-23
  (is (= '("Bob" 42) (lookup "Bob" user-ages)))
  (is (= '("Tom" 31) (lookup "Tom" user-ages)))
  (is (= false (lookup "Moe" user-ages)))

  (is (= '("Bob" 42) (lookup-2 "Bob" user-ages)))
  (is (= '("Tom" 31) (lookup-2 "Tom" user-ages)))
  (is (= false (lookup-2 "Moe" user-ages))))

; 24. https://code-basics.com/ru/languages/clojure/lessons/list-recursion
(defn skip
  [n l]
  (if (or (<= n 0) (empty? l)) l (skip (dec n) (rest l))))

(defn skip-2
  [num list]
  (if (<= num 0)
    list
    (if (> num (count list))
      '()
      (reduce (fn [acc x] (rest acc)) list (range 0 num)))))

(deftest logic-test-24
  (is (= '(1 2 3) (skip -5 (list 1 2 3))))
  (is (= '(1 2 3) (skip 0 (list 1 2 3))))
  (is (= '(2 3) (skip 1 (list 1 2 3))))
  (is (= '() (skip 10 (list 1 2 3))))

  (is (= '(1 2 3) (skip-2 -5 (list 1 2 3))))
  (is (= '(1 2 3) (skip-2 0 (list 1 2 3))))
  (is (= '(2 3) (skip-2 1 (list 1 2 3))))
  (is (= '() (skip-2 10 (list 1 2 3)))))
