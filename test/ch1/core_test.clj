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
