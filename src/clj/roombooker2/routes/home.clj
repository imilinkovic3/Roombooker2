(ns roombooker2.routes.home
  (:require [roombooker2.layout :as layout]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :as response]
            [roombooker2.db.core :as db]))

(defn home-page []
  (layout/render
    "home.html" {:reservations (db/get-all-reservations)}))

(defn about-page []
  (layout/render "about.html"))

(defn delete-reservation! [request]
                           (db/delete-reservation! (:params request) )
                           (response/found "/"))

(defn update-reservation! [request]
                           (db/update-reservation! (:params request) )
                           (response/found "/"))

(defn save-reservation! [request]
                         (db/save-reservation! (:params request) )
                         (response/found "/"))

(defn addReservation-page []
    (layout/render "addReservation.html"))

(defn allreservations-page []
(println (db/get-all-reservations))
  (layout/render
    "allreservations.html" {:reservations (db/get-all-reservations)}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (POST "/reservation" request (save-reservation! request))
  (GET "/addreservation" [] (addReservation-page))
  (POST "/deletereservation" request (delete-reservation! request))
  (POST "/updatereservation" request (update-reservation! request))
  (GET "/allreservations" [] (allreservations-page))
  (GET "/about" [] (about-page)))









