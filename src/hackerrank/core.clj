(ns hackerrank.core
  (:use [clojure.string :only (split triml)])
  ;; (:require [hackerrank.algorithms.warmup :refer :all]
  ;;           [hackerrank.functional.introduction.introduction :refer :all]
  ;;           [hackerrank.functional.recursion.recursion :refer :all])
  (:require [hackerrank.algorithms.even-tree :as g]
            [hackerrank.ai.saveprincess :as s]
            [hackerrank.ai.botcleanr :as b]
            [hackerrank.functional.introduction.functions-or-not :as f]
            [hackerrank.functional.introduction.area-of-a-polygon :as a]
            )
  (:gen-class))

(defn -main [& args]
  (a/run))
