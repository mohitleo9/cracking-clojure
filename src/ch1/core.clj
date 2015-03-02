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

(defn rotate-matrix
  "given a matrix this function rotates it by 90 degrees"
  [matrix]
  (for [col (range (count (get matrix 0)))]
      (for [row (reverse (range (count matrix)))]
        (get (get matrix row) col))))

(defn clear-matrix
  "given a matrix, the function transforms the whole row and col of an element if it is zero."
  [matrix]
  (let [zeros (loop [row 0 acc []]
          (if-not (< row (count matrix))
            acc ;; return this
            (recur (inc row) (into acc (loop [col 0 acc2 []]
                                         (if-not (< col (count (get matrix 0)))
                                           acc2
                                           (recur (inc col) (into acc2 (if (zero? (get (get matrix row) col))
                                                                         [row col])))))))))]
    (let [rows (set (take-nth 2 zeros)) cols (set (take-nth 2 (rest zeros)))]
      (for [x (range (count matrix))]
        (for [y (range (count (get matrix 0)))]
          (if (or (contains? rows x)(contains? cols y))
            0
            (get (get matrix x) y)))))))

(defn is-rotation?
  "given two strings it checks if one is the roation of another using isSubstring (java yuck!)"
  [str1 str2]
  (.contains (str str1 str1) str2))
