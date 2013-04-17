(ns graph.db
  (:require [clojurewerkz.neocons.rest :as nr]
            [clojurewerkz.neocons.rest.nodes :as nn]
            [clojurewerkz.neocons.rest.relationships :as nrl]))

(defn connect []
  (nr/connect! "http://localhost:7474/db/data/"))

(defn- create-doc [title]
  (nn/create {:name title}))

(def create-root create-doc)

(defn fetch [id]
  (nn/get id))

(defn create [name parent]
  (let [doc (create-doc name)]
    (nrl/create parent doc :parent)
    doc))
