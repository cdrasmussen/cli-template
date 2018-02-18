# Clojure CLI Template

## Description 

This is a template for a CLI (command line interface) utility program
in [Clojure, a JVM Lisp implementation](https://clojure.org/).  
The goal of this template is to minimize the effort of repeatedly
building similar machinery.  
In short, edit the parts you want, delete what you don't.

This template has no core functionality of its own since the expected
development sequence is to build a core functionality library module
with its own unit tests then use this template to host that core
functionality whether it is to be used as a utility or launch a GUI or
a server.

This development pattern follows the polyvalent development strategy
described in [Eric Raymond's "Art of Unix Programming"](http://www.catb.org/esr/writings/taoup/).  
Polyvalent development is a strategy where Clojure is well suited.

Command line parsing is provided by
[clojure.tools.cli](https://github.com/clojure/tools.cli), which
this template is based on.

## Installation

Download from http://github.com/cdrasmussen/cli-template  
The files in this directory are supported by the build tool
[Leiningen](https://leiningen.org/).

## Invocation
<PRE> 
  $ cd cli-template  
  $ lein uberjar  
  $ java -jar target/uberjar/cli-template-0.1.0-standalone.jar [args]
</PRE>

## Example Options Provided
<PRE>
Usage: cli-template [-v|--verbose] [-q|--quiet]
                    [-h|--help] [--version] [--trace]
Where:
-v|--verbose enable verbose output messages, (repeatable)  
-q|--quiet reduces normal program output to a minimum  
-h|--help prints this usage text  
   --trace prints trace info  
   --version prints program version
</PRE>

These options are provided by the
[clojure.tools.cli documentation](http://clojure.github.io/tools.cli/index.html#clojure.tools.cli/parse-opts)
as samples of different types of handlers.

## Additional Files

  * src/manual.clj  
    An exercise in automating a manpage embedded in source code.  
    It is in it's own file so as not to force developers to
    deal with its verbosity when developing a simple utility where
    an embedded man page isn't appropriate.

  * src/tell-tale.clj  
    Simple trace functions enabled by a boolean which is currently
    toggled by a command line switch. This is not intended to be a replacement
    for [clojure/tools.trace](https://github.com/clojure/tools.trace).

## To Developers

  I wrote this to help developers, especially those new to Clojure.
  To share your thoughts, email me at rasmussen.cd@gmail.com with
  "cli-template" in the subject.

## License

Copyright © 2017 CD Rasmussen, rasmussen.cd@gmail.com  
Distributed under the Eclipse Public License either version 1.0 or any
later version.

_updated 2018-02-17_
