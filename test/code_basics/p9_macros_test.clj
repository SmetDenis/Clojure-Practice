(ns code_basics.p9-macros-test
  (:require [clojure.string]
            [clojure.test :refer [deftest is]]))

; 43.https://code-basics.com/ru/languages/clojure/lessons/intro-macros
(defn my-some-fn [x] (str "Hello from fn! - " x))
(defmacro some-macro [x] (str "Hello from macro! - " x))

(deftest logic-test-43
  (is (= "Hello from fn! - 3" (my-some-fn (+ 1 2))))
  (is (= "Hello from macro! - (+ 1 2)" (some-macro (+ 1 2)))))

; 44. https://code-basics.com/ru/languages/clojure/lessons/macro-rules
(defn triplet-fn [a b c] (list a b c))
(defmacro triplet-macro [a b c] (list list a b c))

(deftest logic-test-44
  (is (= '(1 2 3) (triplet-fn 1 2 3)))
  (is (= '(1 2 3) (triplet-macro 1 2 3)))
  (is (= '(triplet-macro 1 2 3) (macroexpand '(triplet-macro 1 2 3)))))

; 45. https://code-basics.com/ru/languages/clojure/lessons/data-and-code
(defmacro postfix-notation
  [[a b op]]
  (list op a b))

; (deftest logic-test-45
;   (is (= true (postfix-notation (2 2 =))))
;   (is (= 4 (postfix-notation (2 2 +))))
;   (is (= false (postfix-notation (2 2 >))))
;   (is (= 1 (postfix-notation (2 2 /)))))

; 46. https://code-basics.com/ru/languages/clojure/lessons/quote
(def forbidden-list #{(symbol "clojure") (symbol "is") (symbol "bad")})

(defmacro special-defn
  [name args body]
  (if-not (contains? forbidden-list name)
    (list 'defn name args body)
    "you can't define this function"))

; (special-defn my-sum [a b] (+ a b))
; (special-defn my-diff [a b] (- a b))
; 
; (deftest logic-test-46
;   (is (= '(special-defn my-fn [a] a)
;          (macroexpand-1 '(special-defn my-fn [a] a))))
; 
;   (is (= 6 (my-sum 4 2)))
;   (is (= 2 (my-sum 0 2)))
;   (is (= 4 (my-sum 2 2)))
; 
;   (is (= 2 (my-diff 4 2)))
;   (is (= -2 (my-diff 0 2)))
;   (is (= 0 (my-diff 2 2))))

; 47. https://code-basics.com/ru/languages/clojure/lessons/unquote
(defn strange-fn
  [coll]
  (apply - (apply + coll) coll))

(defmacro strange-macro
  [coll]
  `(apply - (apply + ~coll) ~coll))

(deftest logic-test-47
  (is (= 0 (strange-fn [0 1 2 3])))
  (is (= 0 (strange-fn [1 2 3 4])))
  (is (= 0 (strange-fn [2])))

  (is (= 0 (strange-macro [0 1 2 3])))
  (is (= 0 (strange-macro [1 2 3 4])))
  (is (= 0 (strange-macro [2]))))

; 48. https://code-basics.com/ru/languages/clojure/lessons/splicing
(defmacro strange-print
  [str]
  `(do
     ~@(println (clojure.string/reverse str))
     ~@(println (clojure.string/upper-case str))
     ~@(println (clojure.string/lower-case str))
     ~str))

(deftest logic-test-48
  (is (= '(strange-print "foo") (macroexpand '(strange-print "foo"))))
  (is (= '(strange-print "foo") (macroexpand-1 '(strange-print "foo"))))
  ; (is (= "foo" (strange-print "foo")))
  ; (is (= "!baz!" (strange-print "!baz!")))
  ; (is (= "cloJURE" (strange-print "cloJURE")))
)

; 49. https://code-basics.com/ru/languages/clojure/lessons/gensym
(defmacro auto-sum
  [x]
  `(let [my-var# 10]
     (+ my-var# ~x)))

(deftest logic-test-49
  (is (= 12 (auto-sum 2)))
  (is (= 22 (auto-sum 12)))
  (is (= 122 (auto-sum 112))))

; 50. https://code-basics.com/ru/languages/clojure/lessons/closing-thoughts
(defmacro macro-inc
  [x]
  (list inc x))

(deftest logic-test-50
  (is (= 2 (macro-inc 1)))
  (is (= 3 (macro-inc 2)))
  (is (= 4 (macro-inc 3))))
