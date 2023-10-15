(ns CodeBasics.l08-State)

; 37. State - intro
(defn transit [w1 w2 amount]
      (vector (swap! w1 - amount) (swap! w2 + amount)))

(defn transit-2 [first-acc second-acc amount]
      (let [first-proceeded (swap! first-acc - amount)
            second-proceeded (swap! second-acc + amount)]
           [first-proceeded second-proceeded]))

(transit (atom 100) (atom 20) 20)                           ; => [80 40]
(transit (atom 50) (atom 30) 50)                            ; => [0 80]

; 38. Atoms validation
(defn vec-even? [avec]
      (and
        (not (empty? avec))
        (vector? avec)
        (every? even? avec)))

(defn vec-even-2? [v]
      (if
        (and (vector? v) (= (count v) 0))
        false
        (= (count (filterv even? v)) (count v))))

(vec-even? [])                                              ; => false
(vec-even? [0 2 4 6])                                       ; => true
(vec-even? [1 3 5])                                         ; => false

; 39. Agents
(defn transit-a [a1 a2 amount]
      (await (send a1 - amount))
      (await (send a2 + amount))
      [@a1 @a2])

(transit-a (agent 100) (agent 20) 20)                       ; => [80 40]
(transit-a (agent 50) (agent 30) 50)                        ; => [0 80]

; 40. Watchers
(def aa (atom 0))
(add-watch aa :custom-watcher (fn [_ _ old new] (print (str "Change state from " old "to " new "."))))
(swap! aa inc)
(swap! aa inc)
(swap! aa dec)

; 41. Polymorphism
(defmulti my-calc #(first %))
(defmethod my-calc "+" [expr] (apply + (rest expr)))
(defmethod my-calc "-" [expr] (apply - (rest expr)))
(defmethod my-calc "*" [expr] (apply * (rest expr)))

(my-calc ["+" 1 2])                                         ; => 3
(my-calc ["-" 3 1])                                         ; => 2
(my-calc ["*" 3 3])                                         ; => 9

; 42. Protocols/Records
(defprotocol SaysSomething (say-something [this] "Method to say"))
(defrecord Creature [voice] SaysSomething (say-something [this] (println (str (:voice this) ", World!"))))
(def human (Creature. "Hello"))
(def cat (Creature. "Meow"))
(def dog (Creature. "Bark"))
(say-something human)
(say-something cat)
(say-something dog)

; 42. Protocols/Records v2
(defprotocol SaysSomething-2 (say-something-2 [_] "Hey, I can talk!"))
(defrecord Human-2 [] SaysSomething-2 (say-something-2 [_] (println "Hello, World!")))
(defrecord Cat-2 [] SaysSomething-2 (say-something-2 [_] (println "Meow, World!")))
(defrecord Dog-2 [] SaysSomething-2 (say-something-2 [_] (println "Bark, World!")))
(def human (Human-2.))
(def kitten (Cat-2.))
(def dog (Dog-2.))
(say-something-2 human)
(say-something-2 kitten)
(say-something-2 dog)
