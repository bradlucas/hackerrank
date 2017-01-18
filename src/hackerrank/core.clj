(ns hackerrank.core
  (:use [clojure.string :only (split triml)])
  (:require [hackerrank.algorithms :refer :all]
            [hackerrank.functional.introduction :refer :all])
  (:gen-class))

(defn -main [& argse]
  (fp-hello-world-n-times))
