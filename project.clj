(defproject incise-markdown-parser "0.1.0-SNAPSHOT"
  :description "The default markdown parser for incise."
  :url "https://github.com/RyanMcG/incise-markdown-parser"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[incise-core "0.2.0-SNAPSHOT"]
                 [me.raynes/cegdown "0.1.0"]]
  :repl-options {:init-ns incise.repl}
  :main incise.core)
