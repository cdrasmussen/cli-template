
;; This should be modified
(def author-text
  "Author contact information."
  "rasmussen.cd@gmail.com")

;; This should be modified
(def name-desc
  "Succinct one line summary of programs purpose."
  (format "%s - Example program for Clojure CLI interface" prog-name))

;; This should be modified
(def description-text
  "Verbose program description to use in help text"
  "
  Here should be a paragraph explaining what the program is intended
  to do. In what common circumstances it would be useful. List what
  side effects it has, if any and what it does not do if there could
  easily be misconceptions.

  This is intended to be a command-line handling template that can be
  used as a basis for a utility program launched from the command
  line. The expected sequence is to build the core functionality
  module then use this code as a starting point for the main.

  Here should be detailed explanations of each command line option
  listed in the usage-text other than the default text supplied in
  this template.

  -v|--verbose cause more verbose messages than the program would have
       normally

  -q|--quiet cause program output to be reduced to a minimum. In most
       cases this will be complete silence.

  -h|--help prints this usage text which is intended to be a guide to
       the syntax expected by this program,
  
     --manual prints manual page embedded in this program. While this
       text is a manual page in its format it is only meant to be a
       hold over until a full man page is supplied by the author.

     --trace prints trace info for program debugging and can easily be
       turned off if it does not suit the needs of the author.

     --version prints program version in a form simple enough to be
       easily parsed by other utilities to establish compatibility.")

;; This should be modified, maintain 2 leading spaces of indentation.
(def exit-text
  "Text to fill in the EXIT CODE section of the manpage."
  "  0 on normal exit, 1 for exit on error condition")

;; This should be modified
(def example-text
  "Examples of program use. If included, this should be verbose."
  (format "\n  Complete examples go here followed by explanations.

  # %s --trace
  Turns on value dumping in the program's main." prog-name))

(def manual-text  ; edit sections as needed
  "Approximate format of unix manpage style documentation."
  (format "
NAME\n\n  %s\n
SYNOPSIS\n  %s
DESCRIPTION\n  %s\n
EXIT CODE\n\n  %s\n
EXAMPLES\n  %s\n
VERSION\n\n  %s\n
AUTHOR\n\n  %s\n"
  name-desc usage-text
  description-text exit-text example-text version-text author-text))

