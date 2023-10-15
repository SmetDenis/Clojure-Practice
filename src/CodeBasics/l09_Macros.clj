(ns CodeBasics.l09-Macros)

; 1. Аргументы не выполняются перед тем, как были отправлены в тело макроса
; 2. Тело макросов выполняется в соответствии с обычными правилами Clojure
; 3. Данные, возвращаемые макросом, немедленно вычисляются
;    и результат этого вычисления отдается наружу при вызове этого макроса.

; 43. Macros - Intro
(defn some-fn
  [x]
  (println "Hello from fn!") x)

(defmacro some-macro
  [x]
  (println "Hello from macro!") x)

(some-fn (println (+ 1 2)))
(some-macro (println (+ 1 2)))

; 44. Macros - Rules
(defn triplet-fn
  [a b c]
  (list a b c))

(defmacro triplet-macro
  [a b c]
  (list list a b c))

(macroexpand '(triplet-macro 1 2 3))
(triplet-macro 1 2 3)

; 45. Data as a code
(defmacro postfix-notation
  [[a b op]]
  (list op a b))

(postfix-notation (1 2 +))

; 46. Quote
(def forbidden-list #{(symbol "clojure") (symbol "is") (symbol "bad")})

(defmacro special-defn
  [name args body]
  (if-not (contains? forbidden-list name)
    (list 'defn name args body)
    "you can't define this function"))

(special-defn my-sum [a b] (+ a b))
(special-defn my-diff [a b] (- a b))
(macroexpand-1 '(special-defn my-fn [a] a))
(my-sum 1 2)
(my-diff 1 2)

; 47. Unquote
(defn strange-fn
  [coll]
  (apply - (apply + coll) coll))
(strange-fn [1 2 3 4])

(defmacro strange-macro
  [coll]
  `(apply - (apply + ~coll) ~coll))
(strange-macro [1 2 3 4])

; 48. Splicing
(defmacro strange-print
  [str]
  `(do
     ~@(println (clojure.string/reverse str))
     ~@(println (clojure.string/upper-case str))
     ~@(println (clojure.string/lower-case str))
     ~str))

(strange-print "foo")
(strange-print "!baz!")
(strange-print "cloJURE")

; 49. Gensym
(defmacro auto-sum
  [x]
  `(let [my-var# 10]
     (+ my-var# ~x)))

; 50. Macros - Advices
(defmacro macro-inc
  [x]
  `(inc x))

'(1 2 3)
(+ 1 2)
