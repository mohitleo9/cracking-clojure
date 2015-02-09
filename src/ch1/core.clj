(ns ch1.core)

(defn is-uniq-chars?
  "returns true if all the unique chars in a string"
  [string]
  (every? true? (for [x (take (dec (count string)) (iterate inc 0))]
     (every? nil? (for [y (subs string (+ x 1))]
                    (if (= (get string x) y)
                      true))))))
