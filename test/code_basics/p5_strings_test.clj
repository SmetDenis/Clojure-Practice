(ns code_basics.p5-strings-test
  (:require [clojure.string :as s]
            [clojure.test :refer [deftest is]]))

; 25. https://code-basics.com/ru/languages/clojure/lessons/strings
(defn str-reverse
  [string]
  (s/reverse string))

(defn str-reverse-2
  [str]
  (s/join #"" (reduce #(cons %2 %1) [] (s/split str #""))))

(deftest logic-test-25
  (is (= "olleH" (str-reverse "Hello")))
  (is (= "" (str-reverse "")))
  (is (= "!gnirts-emos" (str-reverse "some-string!")))

  (is (= "olleH" (str-reverse-2 "Hello")))
  (is (= "" (str-reverse-2 "")))
  (is (= "!gnirts-emos" (str-reverse-2 "some-string!"))))

; 26. https://code-basics.com/ru/languages/clojure/lessons/chars
(defn next-chars
  [string]
  (let [chars-code (map int (seq string))
        next-chars (map char (map inc chars-code))]
    (s/join #"" next-chars)))

(defn next-chars-2
  [str]
  (s/join "" (map #(char (+ 1 (int %))) (seq (char-array str)))))

(deftest logic-test-26
  (is (= "" (next-chars "")))
  (is (= "bcd" (next-chars "abc")))
  (is (= "23456" (next-chars "12345")))
  (is (= "34567cde" (next-chars "23456bcd")))

  (is (= "" (next-chars-2 "")))
  (is (= "bcd" (next-chars-2 "abc")))
  (is (= "23456" (next-chars-2 "12345")))
  (is (= "34567cde" (next-chars-2 "23456bcd"))))

; 27. https://code-basics.com/ru/languages/clojure/lessons/format
(defn number-presenter
  [n]
  (format "decimal %d  octal %o  hex %x  upper-case hex %X" n n n n))

(deftest logic-test-27
  (is (= "decimal 63  octal 77  hex 3f  upper-case hex 3F" (number-presenter 63)))
  (is (= "decimal 14  octal 16  hex e  upper-case hex E" (number-presenter 14)))
  (is (= "decimal 2  octal 2  hex 2  upper-case hex 2" (number-presenter 2))))
