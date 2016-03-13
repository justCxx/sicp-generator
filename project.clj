(defproject sicp-generator "0.1.2"
  :description "SICP exercises generator"
  :url "https://github.com/justcxx/sicp-generator"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :eval-in-leiningen true
  :dependencies [[lein-gen "0.2.1"]]
  :profiles {:dev {:plugins [[lein-gen "0.2.1"]]}})
