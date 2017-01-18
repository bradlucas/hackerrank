(ns hackerrank.core
  (:use [clojure.string :only (split triml)])
  (:require [hackerrank.algorithms.warmup :refer :all]
            [hackerrank.functional.introduction :refer :all])
  (:gen-class))

(defn -main [& argse]
  (compare-triplets))
