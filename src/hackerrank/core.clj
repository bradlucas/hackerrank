(ns hackerrank.core
  (:use [clojure.string :only (split triml)])
  (:require [hackerrank.algorithms :refer :all])
  (:gen-class))

(defn -main [& argse]
  (compare-triplets))
