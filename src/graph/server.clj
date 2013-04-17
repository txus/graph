(ns graph.server
  (:use compojure.core)
  (:require [compojure.route :as route])
  (:require [compojure.handler :as handler])
  (:require [graph.db :as db])
  (:use org.httpkit.server))

(defn ok [req]
  {:status  200
   :headers {"Content-Type" "text/plain"}
   :body    "OK"})

(defroutes all-routes
  (GET "/" [] ok))

(defn -main
  [& args]
  (db/connect)
  (run-server (handler/site #'all-routes) {:port 8080}))

