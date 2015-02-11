(ns ch1.core)

(defn is-uniq-chars?
  "returns true if all the unique chars in a string"
  [string]
  (every? true? (for [x (take (dec (count string)) (iterate inc 0))]
     (every? nil? (for [y (subs string (+ x 1))]
                    (if (= (get string x) y)
                      true))))))

(defn is-uniq-chars-2?
  "another attempt at unique chars"
  [string]
  (loop [x 0]
    (cond
      (= x (count string)) true
      (.contains (subs string (inc x)) (str (get string x))) false
      :else (recur (inc x)))))

(defn rev
  "reverses a string"
  [string]
  (apply str (reverse string)))
