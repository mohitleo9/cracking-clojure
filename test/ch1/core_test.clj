(ns ch1.core-test
  (:use expectations)
  (:require [ch1.core :refer :all]))

(expect nil? nil)

(expect (is-uniq-chars? "asdf") true)
(expect (is-uniq-chars? "aadf") false)
