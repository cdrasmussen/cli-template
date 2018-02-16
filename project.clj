(defproject cli-template "0.1.0"
  :description "CLI template for processing command options"
  :url "http://github.com/cdrasmussen/cli-template"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.cli "0.3.5"]]
  :main ^:skip-aot cli-template.core
  :target-path "target/%s"
  :plugins [[lein-codox "0.10.3"]]
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[expectations "2.1.8"]]}})
