(ns sicp.core
  (:require [clojure.math.numeric-tower :as math])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn tolerance?
  "abstraction for recursive approximations"
  [x fun guess]
  (<
   (math/abs (- (fun guess) x))
   0.000000000001))

(defn sqrt
  [x]
  (letfn
   [(good-enough? [guess]
      (tolerance? x #(* % %) guess))
    (improve [guess]
             (/ (+ guess (/ x guess)) 2))
    (sqrt-iter [guess]
               (cond
                 (good-enough? guess)
                 guess
                 :else
                 (recur (improve guess))))]
    (sqrt-iter 1.0)))

(defn cube-root
  [x]
  (letfn [(good-enough? [guess]
            (tolerance? x #(* % % %) guess))
          (improve [guess]
                   (/ (+ (* 2 guess) (/ x (* guess guess))) 3))
          (iter [guess]
                (cond
                  (good-enough? guess)
                  guess
                  :else
                  (recur
                   (improve guess))))]
    (iter 1.0)))

(defn ackerman
  [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (recur (- x 1)
                     (ackerman x (- y 1)))))
