(ns set-glom.core)

(defn -main
  "Combine sets of items on the commandline."
  []
  (do
    (print "> ")
    (flush)
    (def new-set (read-line))
    (println (str "You typed: " new-set))))