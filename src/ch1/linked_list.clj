(ns ch1.linked-list)

(defrecord Node [data n-next])

(defn n-conj
  "given a head node and a new value(data) it adds the new value to the linkedlist represented by the head"
  [head data]
  (cond
    (nil? head) (Node. data nil)
    :else (Node. (:data head) (n-conj (:n-next head) data))))

(defn n-seq
  "given a head Node returns a vector of the linkedlist data"
  [head]
  (when head
    (vec (cons (:data head) (n-seq (:n-next head))))))
