(ns ch1.linked-list-test

  (:use expectations)
  (:require [ch1.linked-list :refer :all])
  (:import [ch1.linked_list Node]))

;; eh
(expect Node (Node. nil nil))

(expect (Node. 5 nil) (n-conj nil 5))
(expect (range 6) (n-seq (reduce n-conj nil (range 6))))
(expect vector? (n-seq (reduce n-conj nil (range 6))))

(expect (Node. 4 nil) (n-last (reduce n-conj nil (range 5))))

(expect [1 3 2] (n-seq (n-remove (reduce n-conj nil [1 2 3 2]) 2)))

(expect [1 3] (n-seq (n-remove-all (reduce n-conj nil [1 2 3 2]) 2)))
(expect [1 3] (n-seq (n-remove-all (reduce n-conj nil [1 2 2 2 3 2]) 2)))


(expect 1 (:data (n-nth (reduce n-conj nil (range 5)) 2)))

;; (expect 1 (n-remove-duplicates (reduce n-conj nil [1 1 1 1 2 2 2])))
