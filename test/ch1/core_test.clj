(ns ch1.core-test
  (:use expectations)
  (:require [ch1.core :refer :all]))

(expect nil? nil)

(expect  true (is-uniq-chars? "asdf"))
(expect  false (is-uniq-chars? "aadf"))

(expect  true (is-uniq-chars-2? "asdf"))
(expect  false (is-uniq-chars-2? "aadf"))
