;;;; tell-tale ;;;;;;;;;;;;;;;
(def tell-tale "When false, tell functions will not run" false)

(defn tell-entry "Announce a function's name and args"
  [name & args]
  (if tell-tale (println "Entry" name args)))

(defmacro tell-val "Prints the name, value and type of x" [x]
  `(do (if tell-tale (println ">>" '~x ~x (type ~x))) ~x))

(defn tell-hash "Dump keys and values of hashval" [hashval]
  (if tell-tale
    (doseq [key (keys hashval)] (println key (hashval key)))))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
