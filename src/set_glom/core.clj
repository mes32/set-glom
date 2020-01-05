(ns set-glom.core
  (:require
    [clojure.set :as set]
    [clojure.string :as string]))

(defn get-line
  "Get one line of input from the user (via CLI)"
  []
  (do
    (print "> ")
    (flush)
    (read-line)))

(defn parse-set
  "Parse a space delimited string of items and return those items in a hash-set"
  [string]
  (set (string/split (string/trim string) #"\s+")))

(defn glom-sets
  "For now just prints the new set to add, and returns the initial vector of sets"
  [current-sets new-set]
  (set/union current-sets new-set))

(defn -main
  "Read in sets of items from the command line. Combine the sets as needed."
  []
  (loop [sets #{}]
    (def line (get-line))
    (if (= line "quit")
      sets
      (recur (glom-sets sets (parse-set line))))))