(ns graph.server
  (:use compojure.core)
  (:require [compojure.route :as route])
  (:require [compojure.handler :as handler])
  (:use org.httpkit.server))

(defn root [req]
  {:status  200
   :headers {"Content-Type" "text/plain"}
   :body    "OK"})

(defroutes all-routes
  (GET "/" [] root))

(defn -main
  [& args]
  (run-server (handler/site #'all-routes) {:port 8080}))

