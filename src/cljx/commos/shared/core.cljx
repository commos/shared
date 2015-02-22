(ns commos.shared.core)

(defn flatten-keys
  "Transform a nested map to a map ks->v where v is not a map."
  [m]
  (let [step (fn step [root m]
               (mapcat (fn [[k v]]
                         (if (map? v)
                           (step (conj root k) v)
                           [[(conj root k) v]]))
                       m))]
    (into {} (step [] m))))
