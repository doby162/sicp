(ns sicp.core
  (:require [clojure.math.numeric-tower :as math])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn square
  [x] (* x x))

(defn good-enough?
  [guess x]
  (<
   (math/abs (- (square guess) x))
   0.000000000001))

(defn average
  [x y]
  (/ (+ x y) 2))

(defn improve
  [guess x]
  (average  guess (/ x guess)))

(defn sqrt-iter
  [guess x]
  (cond
    (good-enough? guess x)
    guess
    :else
    (recur (improve guess x)
           x)))

(defn sqrt
  [x]
  (sqrt-iter 1.0 x))
