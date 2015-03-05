(ns ch1.linked-list-test

  (:use expectations)
  (:require [ch1.linked-list :refer :all])
  (:import [ch1.linked_list Node]))

;; eh
(expect Node (Node. nil nil))

(expect (Node. 5 nil) (n-conj nil 5))
(expect (range 6) (n-seq (reduce n-conj nil (range 6))))
(expect vector? (n-seq (reduce n-conj nil (range 6))))

