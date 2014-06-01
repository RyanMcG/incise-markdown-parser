(ns incise.parsers.impl.markdown-test
  (:require [clojure.java.io :refer [file resource]]
            (incise [load :refer (load-parsers-and-layouts)])
            [incise.test-helpers :refer :all]
            [clojure.test :refer :all]
            [incise.parsers.html :refer [html-parser]]
            [incise.parsers.impl.markdown :refer :all])
  (:import [java.io File]))

(use-fixtures :once (custom-config-fixturer :in-dir "resources/test"
                                            :out-dir "/tmp"))

(def ^:private parse (comp slurp first force parser))

(defn- result [] (parse (file (resource "test/markdown-options.md"))))

(deftest markdown-parsing
  (load-parsers-and-layouts)
  (testing "default options"
    (is (re-find #"<html>" (result)) "generates html content")
    (is (re-find #"First line Second line" (result)) "parses without hardwraps"))
  (testing "custom options"
    (with-custom-config {:parsers {:markdown {:extensions [:hardwraps]}}}
      (is (re-find #"First line<br/>Second line" (result))
          "parses with hardwraps"))))
