(ns ch1.core
  (:require [clojure.string :as str]))

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

(defn is-permuation?
  "takes two strings and see if one is the permuation of other"
  [string1, string2]
  (cond
    (not (= (count string1) (count string2))) false
    (= (sort string1) (sort string2)) true
    :else false))

(defn replace-space
   "given a string it replaces the spaces with %20"
   [string]
   (let [words (str/split string #" ")]
     (if-not (empty? words)
             (str/join "%20" words)
             "%20")))

(defn compress-string
  "given a string it compresses the string by prepending count,
  but returns the original string if the compressed string is longer"
  [string]
  (let [compressed (apply str
               (mapcat #(cons (count %)[(first %)])
                       (partition-by identity string)))]
    (if (> (count compressed) (count string))
      string
      compressed)))
