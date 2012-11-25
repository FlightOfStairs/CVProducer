(ns cvproducer.core
  (:use cvproducer.html)
  (:use cvproducer.alistairsmith)
  (:use fleet))

(defn get-resource [resource-path]
  (slurp (clojure.java.io/resource resource-path)))

(def builds [ { :template "template.html" :output "alistair-smith.html" :meta { :style (get-resource "style.css" ) } }
              { :template "template.txt"  :output "alistair-smith.txt"  :meta {} } ] )

(defn do-build [build]
  (spit
    (:output build)
    ((fleet [data meta] (get-resource (:template build))) cv (:meta build) )))

(defn -main []
  (dorun
    (map do-build
      builds)))
