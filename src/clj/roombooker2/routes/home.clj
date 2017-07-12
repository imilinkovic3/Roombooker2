(ns roombooker2.routes.home
  (:require [roombooker2.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [roombooker.db.core :as db]))

(defn home-page []
  (layout/render
    "home.html" {:reservations (db/get-all-reservations)}))

(defn about-page []
  (layout/render "about.html"))

(defn save-reservation! [request]
                         (db/save-reservation! (:params request) )
                         (response/found "/"))

(defn addReservation-page []
    (layout/render "addReservation.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/reservation" request (save-reservation! request))
  (GET "/about" [] (about-page)))









