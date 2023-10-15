(ns CodeBasics.l05-Strings
  (:require [clojure.string :as s]))

; 25. Strings
(defn str-reverse
  [string]
  (s/reverse string))

(defn str-reverse-2
  [str]
  (s/join #"" (reduce (fn [acc x] (cons x acc)) [] (s/split str #""))))

(str-reverse "Hello")                                       ; "olleH"
(str-reverse "")                                            ; ""

; 26. Chars
(defn next-chars
  [string]
  (let [chars-code (map int (seq string))
        next-chars (map char (map inc chars-code))]
    (s/join #"" next-chars)))

(defn next-chars-2
  [str]
  (s/join "" (map #(char (+ 1 (int %))) (seq (char-array str)))))

(next-chars "")                                             ; ""
(next-chars "abc")                                          ; "bcd"
(next-chars "12345")                                        ; "23456"

; 27. String formatting
(defn number-presenter
  [n]
  (format "decimal %d  octal %o  hex %x  upper-case hex %X" n n n n))

(number-presenter 63)                                       ; => "decimal 63  octal 77  hex 3f  upper-case hex 3F"
(number-presenter 14)                                       ; => "decimal 14  octal 16  hex e  upper-case hex E"
