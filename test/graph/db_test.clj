(ns graph.db-test
  (:use clojure.test
        graph.db))

(connect)

(deftest create-root-test
  (let [root (create-root "Life")]
    (testing "Creates a root node"
      (is (:name (fetch (:id root)) "Life")))))

(deftest create-test
  (let [root (create-root "Life")
        child (create "Work" root)]
    (testing "Creates a node with a parent"
      (is (:name (fetch (:id child)) "Work")))))
