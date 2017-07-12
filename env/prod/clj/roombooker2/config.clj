(ns roombooker2.config
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[roombooker2 started successfully]=-"))
   :middleware identity})
