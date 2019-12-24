(ns sicp.core
  (:require [clojure.math.numeric-tower :as math])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn square
  [x] (* x x))

(defn cube
  [x] (* x x x))

(defn good-enough?
  [guess x fun]
  (<
   (math/abs (- (fun guess) x))
   0.000000000001))

(defn average
  [x y]
  (/ (+ x y) 2))

(defn improve
  "((y + (y / x))  / x)
  y is the guess, x the input"
  [y x]
  (average  y (/ x y)))

(defn improve-cube
  "((x / y^2) + 2y) / 3
  y is the guess, x the input"
  [y x]
  (/
   (+
    (* 2 y)
    (/ x (* y y)))
   3))

(defn sqrt-iter
  [guess x]
  (cond
    (good-enough? guess x square)
    guess
    :else
    (recur (improve guess x)
           x)))

(defn sqrt
  [x]
  (sqrt-iter 1.0 x))

(defn cube-root-iter
  [guess x]
  (cond
    (good-enough? guess x cube)
    guess
    :else
    (recur
     (improve-cube guess x)
     x)))

(defn cube-root
  [x]
  (cube-root-iter 1.0 x))
