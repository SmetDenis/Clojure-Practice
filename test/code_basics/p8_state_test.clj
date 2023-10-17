(ns code_basics.p8-state-test
  (:require [clojure.test :refer [deftest is]]))

; 37. https://code-basics.com/ru/languages/clojure/lessons/about-state
(defn transit
  [w1 w2 amount]
  (vector (swap! w1 - amount) (swap! w2 + amount)))

(defn transit-2
  [first-acc second-acc amount]
  (let [first-proceeded  (swap! first-acc - amount)
        second-proceeded (swap! second-acc + amount)]
    [first-proceeded second-proceeded]))

(deftest logic-test-37
  (is (= [80 40] (transit (atom 100) (atom 20) 20)))
  (is (= [0 80] (transit (atom 50) (atom 30) 50)))

  (is (= [80 40] (transit-2 (atom 100) (atom 20) 20)))
  (is (= [0 80] (transit-2 (atom 50) (atom 30) 50))))

; 38. https://code-basics.com/ru/languages/clojure/lessons/atoms-validation
(defn vec-even?
  [vector]
  (and (not (empty? vector))
       (vector? vector)
       (every? even? vector)))

(defn vec-even-2?
  [v]
  (if (and (vector? v) (= (count v) 0))
    false
    (= (count (filterv even? v)) (count v))))

(deftest logic-test-38
  (is (= true (vec-even? [0 2 4 6])))
  (is (= false (vec-even? [1 3 5])))
  (is (= false (vec-even? [])))
  (is (= false (vec-even? [0 2 4 5])))
  (is (= true (vec-even? [2])))

  (is (= true (vec-even-2? [0 2 4 6])))
  (is (= false (vec-even-2? [1 3 5])))
  (is (= false (vec-even-2? [])))
  (is (= false (vec-even-2? [0 2 4 5])))
  (is (= true (vec-even-2? [2]))))

; 39. https://code-basics.com/ru/languages/clojure/lessons/about-agents
(defn transit-a
  [a1 a2 amount]
  (await (send a1 - amount))
  (await (send a2 + amount))
  [@a1 @a2])

(deftest logic-test-39
  (is (= [80 40] (transit-a (agent 100) (agent 20) 20)))
  (is (= [80 70] (transit-a (agent 100) (agent 50) 20)))
  (is (= [0 110] (transit-a (agent 10) (agent 100) 10)))
  (is (= [0 80] (transit-a (agent 50) (agent 30) 50))))

; 40. https://code-basics.com/ru/languages/clojure/lessons/about-watchers
(def aa (atom 0))
(add-watch aa :custom-watcher
           (fn [_ _ old new] (str "Change state from " old "to " new ".")))

(deftest logic-test-40
  (is (= 1 (swap! aa inc)))
  (is (= 2 (swap! aa inc)))
  (is (= 1 (swap! aa dec))))

; 41. https://code-basics.com/ru/languages/clojure/lessons/intro-polymorphism
(defmulti my-calc #(first %))
(defmethod my-calc "+" [expr] (apply + (rest expr)))
(defmethod my-calc "-" [expr] (apply - (rest expr)))
(defmethod my-calc "*" [expr] (apply * (rest expr)))

(deftest logic-test-41
  (is (= 3 (my-calc ["+" 1 2])))
  (is (= 2 (my-calc ["-" 3 1])))
  (is (= 9 (my-calc ["*" 3 3]))))

; 42. https://code-basics.com/ru/languages/clojure/lessons/protocols-and-records
(defprotocol SaysSomething (say-something [this] "Method to say"))
(defrecord Creature [voice] SaysSomething (say-something [this] (str (:voice this) ", World!")))
(def my-human (Creature. "Hello"))
(def my-cat (Creature. "Meow"))
(def my-dog (Creature. "Bark"))

(deftest logic-test-42-1
  (is (= "Hello, World!" (say-something my-human)))
  (is (= "Meow, World!" (say-something my-cat)))
  (is (= "Bark, World!" (say-something my-dog))))

(defprotocol SaysSomething-2 (say-something-2 [_] "Hey, I can talk!"))
(defrecord Human-2 [] SaysSomething-2 (say-something-2 [_] (str "Hello, World!")))
(defrecord Cat-2 [] SaysSomething-2 (say-something-2 [_] (str "Meow, World!")))
(defrecord Dog-2 [] SaysSomething-2 (say-something-2 [_] (str "Bark, World!")))
(def my-human-2 (Human-2.))
(def my-cat-2 (Cat-2.))
(def my-dog-2 (Dog-2.))

(deftest logic-test-42-2
  (is (= "Hello, World!" (say-something-2 my-human-2)))
  (is (= "Meow, World!" (say-something-2 my-cat-2)))
  (is (= "Bark, World!" (say-something-2 my-dog-2))))
