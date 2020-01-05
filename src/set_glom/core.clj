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

(defn display-sets
  "Expects a list of sets and prints each set with nice formatting"
  [sets]
  ; (map
  ;   (fn [item] (println (str "  {" (clojure.string/join ", " item) "}")))
  ;   sets))
  (println sets))

(defn glom-sets
  "Given two sets 'target' and 'additional'. Returns the union if they have intersecting items. Otherwise returns the target set unchanged."
  [target additional]
  (if (empty? (set/intersection target additional))
    target
    (set/union target additional)))

(defn iterate-main
  "Generate a new iteration of the list of sets. Combine sets as needed using 'glom-sets' and combine with any unaffected sets."
  [current-sets new-set]
  (do
    (def sets
      (conj
        (filter #(empty? (set/intersection new-set %)) current-sets)
        (reduce (fn [target-set additional-set] (glom-sets target-set additional-set)) new-set current-sets)))
    (display-sets sets)
    sets))

(defn -main
  "Read in sets of items from the command line. Combine the sets as needed."
  []
  (loop [sets '()]
    (def line (get-line))
    (if (= line "quit")
      sets
      (recur (iterate-main sets (parse-set line))))))