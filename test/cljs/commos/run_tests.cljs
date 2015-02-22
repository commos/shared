(ns commos.run-tests
  (:require [cljs.nodejs :as nodejs]
            [cljs.test :refer-macros [run-tests]]
            [commos.shared.core-test]))

(nodejs/enable-util-print!)

(defn main []
  (run-tests 'commos.shared.core-test))

(set! *main-cli-fn* main)
