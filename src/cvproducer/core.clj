(ns cvproducer.core
  (:use cvproducer.html)
  (:use cvproducer.alistairsmith)
  (:use fleet))

(def templates ["template.html" "template.txt"])

(defn get-resource [resource-path]
  (slurp (clojure.java.io/resource resource-path)))

(defn -main []
  (println (str ((fleet [data meta] (get-resource (second templates))) cv {}))))