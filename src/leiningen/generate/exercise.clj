(ns leiningen.generate.exercise
  (:require [leiningen.generate.templates :as tmpl]
            [leiningen.new.templates :refer [name-to-path render-text]]
            [leiningen.core.main :as main]))

(defn data
  [{:keys [:chapter :exercise] :as all}]
  (let [name (str chapter "-" exercise)]
    (assoc
     all
     :name name
     :module (format "chapter%02d" (read-string chapter))
     :project "sicp"
     :sanitized (name-to-path name))))

(defn exercise
  "Generate a new exercise source, test and doc"
  [project chapter exercise]
  (let [data (data {:chapter chapter :exercise exercise})]
    (doto (tmpl/renderer "exercise")
      (tmpl/create-file "source.clj" "src/{{project}}/{{module}}/{{sanitized}}.clj" data)
      (tmpl/create-file "test.clj" "test/{{project}}/{{module}}/{{sanitized}}_test.clj" data)
      (tmpl/create-file "doc.md" "doc/{{module}}/ex_{{sanitized}}.md" data))))
