(ns incise.parsers.impl.markdown
  (:require (incise.parsers [core :as pc]
                            [html :refer [html-parser]])
            [incise.config :as conf]
            [me.raynes.cegdown :as md]))

(def ^:private default-extensions
  [:fenced-code-blocks
   :autolinks
   :quotes
   :abbreviations
   :tables
   :definition-lists
   :strikethrough
   :smartypants])

(defn- get-extensions []
  (conf/get-in [:parsers :markdown :extensions] default-extensions))

(defn- markdown-to-html [markdown-str]
  (md/to-html markdown-str (get-extensions)))

(def parser (html-parser markdown-to-html))

(pc/register [:md :markdown] #'parser)
