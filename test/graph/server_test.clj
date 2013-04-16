(ns graph.server-test
  (:use clojure.test
        graph.server))

(deftest root-test
  (let [response (root nil)]
    (testing "Returns 200 as the status code"
      (is (:status response) 200))
    (testing "Returns OK as the body"
      (is (:body response) "OK"))))
