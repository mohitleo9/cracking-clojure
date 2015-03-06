(ns ch1.linked-list)

(defrecord Node [data n-next])

(defn n-conj
  "given a head node and a new value(data) it adds the new value to the linkedlist represented by the head"
  [head data]
  (cond
    (nil? head) (Node. data nil)
    :else (Node. (:data head) (n-conj (:n-next head) data))))


(defn nn-conj
  [head node]
  (cond
    (nil? head) node
    :else (Node. (:data head) (nn-conj (:n-next head) node))))

(defn n-seq
  "given a head Node returns a vector of the linkedlist data"
  [head]
  (when head
    (vec (cons (:data head) (n-seq (:n-next head))))))

(defn n-last
  [head]
  (if-not (:n-next head)
    head
    (recur (:n-next head))))

(defn n-remove
  "given a node and a data it removes the first occurance of data"
  [head data]
  (cond
    (nil? head) nil
    (= data (:data head)) (:n-next head)
    :else (Node. (:data head) (n-remove (:n-next head) data))))

(defn n-remove-all
  "given a node and a data it removes all the occurances of data"
  [head data]
  (cond
    (nil? head) nil
    (= data (:data head)) (n-remove-all (:n-next head) data)
    :else (Node. (:data head) (n-remove-all (:n-next head) data))))
(defn n-nth
  "given a head an a number returns the n-th node"
  [head n]
  (cond
    (nil? head) nil
    (zero? (dec n)) head
    (< (dec n) 0) nil
    :else (n-nth (:n-next head) (dec n))))

(defn n-remove-duplicates
  "given a node it removes all the duplicates from the linkedlist."
  [head]
  (cond
    (nil? head) nil
    :else (Node. (:data head) (n-remove-duplicates (n-remove-all (:n-next head) (:data head))))))
