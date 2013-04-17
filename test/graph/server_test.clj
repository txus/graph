(ns graph.server-test
  (:use clojure.test
        graph.server))

(deftest ok-test
  (let [response (ok nil)]
    (testing "Returns 200 as the status code"
      (is (:status response) 200))
    (testing "Returns OK as the body"
      (is (:body response) "OK"))))
