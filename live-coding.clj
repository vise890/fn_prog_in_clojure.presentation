;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;; Fizz Buzz ;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn fizz-buzzify [n]
  (cond
   (= 0 (mod n 15)) "FizzBuzz"
   (= 0 (mod n 5)) "Buzz"
   (= 0 (mod n 3)) "Fizz"
   :else n))

(fizz-buzzify 15)
(fizz-buzzify 5)
(fizz-buzzify 3)
(fizz-buzzify 1)
(fizz-buzzify 1)
(fizz-buzzify 2)
(fizz-buzzify 1200)
(fizz-buzzify 40)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;; Currency Convertah ;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def currency-conversion-table {:eur 1.35
                                :usd 1.00
                                :inr 1/62})

(:eur currency-conversion-table)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn conversion-rate [from to]
  (/ (from currency-conversion-table)
     (to currency-conversion-table)))

(conversion-rate :usd :eur)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn convert [[amount from] to]
  (let [conversion-rate (conversion-rate from to)]
    [(* amount conversion-rate) to]))

(convert [15 :eur] :usd)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn convert-all [& money]
  (let [to (second (first money))]
    (map (fn [m] (convert m to)) money)))

(convert-all [10 :eur] [13.5 :usd])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn add-all [& moneys]
  (let [to (second (first moneys))
        converted-moneys (apply convert-all moneys)
        amounts (map first converted-moneys)
        total-amount (apply + amounts)]
    [total-amount to]))

(add-all [12 :eur] [12 :usd] [12 :inr])
