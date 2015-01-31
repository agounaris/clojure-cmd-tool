(ns command-line-tool.core
  (:require [clojure.java.io :as io]) ; entire java.io library
  (:use [clojure.tools.cli :only (cli)]) ; expression loads only cli namesame from tools
  (:gen-class))

(defn do-something
  []
  (println "this tool could be doing something instead of just printing this"))

(defn run
  "Print out the options and the arguments"
  [opts args]
  (println (str "Options:\n" opts "\n\n"))
  (println (str "Arguments:\n" args "\n\n")))

(defn -main [& args]
  (let [[opts args banner]
        (cli args
             ["-h" "--help" "Show help" :flag true :default false]
             ["-f" "--first" "Delay between messages (a value type)" :default 2]
             ["-s" "--second" "REQUIRED: arguments)"]
             ["-t" "--third" "REQUIRED: arguments)"]
             ["-o" "--optional" "optional description"] ;; optional
             ["-t" "--test" "Test mode does not send" :flag true :default false]
             )]
    (when (:help opts)
      (println banner)
      (System/exit 0))
    (if
      (and
        (:second opts)
        (:third opts))
      (do
        (println "")
        (run opts args)
        (do-something))
      (println banner))))