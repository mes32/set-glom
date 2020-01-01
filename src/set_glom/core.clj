(ns set-glom.core)

(defn get-line
  "Get one line of input from the user (via CLI)"
  []
  (do
    (print "> ")
    (flush)
    (read-line)))

(defn -main
  "Read in sets of items from the command line. Combine the sets as needed."
  []
  (loop [line nil]  
    (when (not= line "quit")
      (def new-line (get-line))
      (println new-line)    
      (recur new-line))))