(ns set-glom.core)
(def split clojure.string/split)
(def trim clojure.string/trim)

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
  (set (split (trim string) #"\s+")))

(defn glom-sets
  "For now just prints the new set to add, and returns the initial vector of sets"
  [sets-vec new-set]
  (do
    (println new-set)
    sets-vec))

(defn -main
  "Read in sets of items from the command line. Combine the sets as needed."
  []
  (loop [sets-vec []]
    (def line (get-line))
    (if (= line "quit")
      sets-vec
      (recur (glom-sets sets-vec (parse-set line))))))