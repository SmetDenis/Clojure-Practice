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

