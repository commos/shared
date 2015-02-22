(defproject org.commos/shared "0.1.0"
  :description "Shared commos libs"
  :url "http://github.com/commos/shared"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0-alpha5"]]
  :source-paths ["target/generated/clj"]
  :resource-paths ["target/generated/cljs"]
  :prep-tasks [["cljx" "once"] "javac" "compile"]
  :profiles {:dev {:aliases {"cleantest" ["do" "clean"
                                          ["cljx" "once"]
                                          ["test"]]}
                   :dependencies [[com.cemerick/piggieback "0.1.5"]
                                  [org.clojure/clojurescript "0.0-2850"]]
                   :plugins [[com.keminglabs/cljx "0.5.0"]
                             [lein-cljsbuild "1.0.4"]]
                   :repl-options {:nrepl-middleware
                                  [cemerick.piggieback/wrap-cljs-repl]}
                   :source-paths ["src/dev/clj"
                                  ;; for repl:
                                  "target/generated/cljs"]
                   :test-paths ["target/generated/test/clj"
                                ;; for repl:
                                "target/generated/test/cljs"]
                   :cljsbuild
                   {:builds [{:id "test"
                              :source-paths ["target/generated/cljs"
                                             "target/generated/test/cljs"
                                             "test/cljs"]
                              :compiler {:output-to "target/js/test.js"
                                         :output-dir "target/js"
                                         :optimizations :none
                                         :target :nodejs
                                         :cache-analysis true}}]}}}
  :cljx {:builds [{:source-paths ["src/cljx"]
                                    :output-path "target/generated/clj"
                                    :rules :clj}
                                   {:source-paths ["src/cljx"]
                                    :output-path "target/generated/cljs"
                                    :rules :cljs}

                                   {:source-paths ["test/cljx"]
                                    :output-path "target/generated/test/clj"
                                    :rules :clj}

                                   {:source-paths ["test/cljx"]
                                    :output-path "target/generated/test/cljs"
                                    :rules :cljs}]})
