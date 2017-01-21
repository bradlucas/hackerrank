(ns hackerrank.core
  (:use [clojure.string :only (split triml)])
  (:require [hackerrank.algorithms.warmup :refer :all]
            [hackerrank.functional-programming.introduction.introduction :refer :all]
            [hackerrank.functional-programming.recursion.recursion :refer :all])
  (:gen-class))

(defn -main [& args]
  (run-eval-ex))
