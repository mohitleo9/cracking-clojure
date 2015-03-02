(ns ch1.core-test
  (:use expectations)
  (:require [ch1.core :refer :all]))

(expect nil? nil)

(expect  true (is-uniq-chars? "asdf"))
(expect  false (is-uniq-chars? "aadf"))

(expect  true (is-uniq-chars-2? "asdf"))
(expect  false (is-uniq-chars-2? "aadf"))

(expect  "fdaa" (rev "aadf"))

(expect true (is-permuation? "asdf" "fdsa"))
(expect false (is-permuation? "aasdf" "fdsa"))

(expect "%20f" (replace-space " f"))
(expect "%20f%20%20l" (replace-space " f  l"))
(expect "%20" (replace-space " "))

(expect "3a" (compress-string "aaa"))
(expect "a" (compress-string "a"))

(expect [[4 1]
         [5 2]
         [6 3]] (rotate-matrix [[1 2 3]
                             [4 5 6]]))

(expect [[0 0 0]
         [1 3 0]] (clear-matrix [[4 5 0]
                                 [1 3 9]]))

(expect true (is-rotation? "asdf" "fasd"))
