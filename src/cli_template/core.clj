
(ns cli-template.core
  ^{ :author "rasmussen.cd@gmail.com"
     :doc "CLI template for command line option handling"
     :modified "2018-01-15"}
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(use '[clojure.string :only [index-of]])

; Example of a source level include file
(load-file "src/tell-tale.clj") ; reads from src directory

;; This should be modified
; This can't be derived from sun.java.command line when using Leiningen
(def prog-name
  "Simple program name to be included in help text."
  "cli-template")

;; Should be kept up to date
(def version
  "Simple program version string that can be easily evaluated."
  "0.1.0")

;; This should be modified
(def name-desc
  "Succinct one line summary of programs purpose."
  (format "%s - Example program for Clojure CLI interface" prog-name))

(def version-text
  "Formated program version for inclusion in help text."
  (format "%s version %s" prog-name version))

;; This should be modified
; Add these as needed: [--manual] 
;     --manual prints manual page contents
(def usage-text
  "Terse program syntax text to be used in embedded help."
  (format "
  Usage: %s [-v|--verbose] [-q|--quiet]
            [-h|--help] [--version] [--trace]
  
  Where:

  -v|--verbose enable verbose output messages, (repeatable)
  -q|--quiet reduces normal program output to a minimum
  -h|--help prints this usage text
     --trace prints trace info
     --version prints program version\n" prog-name))

; Can't load this until usage-text is defined
;(load-file "src/manual.clj")

;; This should be modified
(def cli-options
  "This is a vector of options to be enforced by cli/parse-opts
   See clojure.github.io/tools.cli/ for details."
  [ ;; An option with a required argument
    ["-p" "--port PORT" "Define Port number"
      :default 80
      :parse-fn #(Integer/parseInt %)
      :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]

    ;; A non-idempotent option
    ["-v" "--verbose" "Verbosity level"
      :id :verbosity
      :default 0
      :assoc-fn (fn [m k _] (update-in m [k] inc))]

    ;; A boolean option defaulting to nil
    ["-q" "--quiet"   "Reduce verbosity as much as possible"]
    ["-h" "--help"    "Usage & suggest manual"]
    [nil  "--version" "One line only"]
;    [nil  "--manual"  "Complete command-line user documentation"]
    [nil  "--trace"   "Turn on run-time tracing"]])

; Stub for logging later
(defn- prog-logger [msg] nil)

(defn exit-logger
  "Print msg and if code is non-zero, log the msg.
  System/exit with code."
  [msg code]
  (if (pos? code)
    (prog-logger msg))
  (println msg)
  (System/exit code))

(defn exit-msg
  "When perp is specified, call exit-logger with a fatal error.
  When perp is not specified, print msg and exit without error."
  [msg & perp]
  (if perp
    (exit-logger (format "%s: %s: %s. Exiting."
                         prog-name (first perp) msg) 1)
    (exit-logger msg 0)))

(defn cli-errors-perp
  "Extract perp from parse-opts :errors.
   Perp is the name of what caused the error."
  [cli-errors]
  (let [err0 (first cli-errors)]
    (subs err0 (+ 1 (index-of err0 \")) (- (count err0) 1))))

(defn -main
  "CLI library scaffolding for command line options.
  -main will process the command line and react to specified options
  then run the core logic with the remaining arguments."
  [& args]
  (if-not args
    (exit-msg usage-text))        

  (let [cli-parsed (parse-opts args cli-options)
        cli-opts (cli-parsed :options)    ; get these 2 vectors
        cli-errors (cli-parsed :errors)]

    (def tell-tale (cli-opts :trace))
    (tell-entry "cli-template" args)))
    (tell-val cli-parsed)
    (tell-val cli-errors)

    (cond                  ; one-shot options that exit
      cli-errors (exit-msg "Invalid option"
                   (cli-errors-perp cli-errors))
      (cli-opts :help) (exit-msg usage-text)
;      (cli-opts :manual) (exit-msg manual-text) ; uncomment to enable
      (cli-opts :version) (exit-msg version-text))

    (if (pos? (cli-opts :verbosity))
      (println "This where the core functionally happens."))

    (if-not (cli-opts :quiet)
      (println "Core logic needed to do great things. Apply within."))))
