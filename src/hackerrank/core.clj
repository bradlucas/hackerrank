(ns hackerrank.core
  (:use [clojure.string :only (split triml)])
  (:require [hackerrank.algorithms.warmup :refer :all]
            [hackerrank.functional.introduction :refer :all]
            [hackerrank.functional.recursion :refer :all])
  (:gen-class))

(defn -main [& args]
  (pascals-triangle (Integer/parseInt (read-line))))
