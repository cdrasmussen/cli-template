# cli-template

## Description 

  This is a template for a CLI (command line interface) utility program in Clojure.
  Its goal is to minimize the effort of repeatedly building similar machinery.  
  So edit parts you want, delete what you don't want.
  
  It has no core functionality of its own since the expected development sequence
  is to build a core functionality module with its own unit tests then
  use this code as a basis for a command line utility that will host
  that core functionality module. 

  This development pattern follows the polyvalent development strategy described
  in [Eric Raymond's "Art of Unix Programming"](http://www.catb.org/esr/writings/taoup/),
  Polyvalent development is a strategy for which Clojure is well suited.

  Command line parsing is provided by [clojure.tools.cli](https://github.com/clojure/tools.cli), for which we are all grateful.

## Installation

  Download from http://github.com/cdrasmussen/cli-template  
  The files in this directory are supported by the build tool
  [Leiningen](https://leiningen.org/).

## Invocation
 
  $ cd cli-template  
  $ lein uberjar  
  $ java -jar target/uberjar/cli-template-0.1.0-standalone.jar [args]

## Options
```
  Usage: cli-template [-v|--verbose] [-q|--quiet]
                   [-h|--help] [--version] [--trace]
  
  Where:
  -v|--verbose enable verbose output messages, (repeatable)  
  -q|--quiet reduces normal program output to a minimum  
  -h|--help prints this usage text  
     --trace prints trace info  
     --version prints program version
```

## Additional Files

  * src/manual.clj  
    An exercise in automating a manpage embedded in source code.  
    In it's own file so as not to force developers to
    deal with its verbosity when developing a simple utility where
    an embedded man page isn't apropos.

  * src/tell-tale.clj  
    Simple trace functions enabled by a boolean which is currently
    toggled by a command line switch. This is not intended to be a replacement
    for [clojure/tools.trace](https://github.com/clojure/tools.trace).

## To Developers

  I wrote this to help developers, especially those new to Clojure.  
  To share your thoughts, email me at
  rasmussen.cd@gmail.com with cli-template in the subject.

## License

Copyright © 2017 CD Rasmussen, rasmussen.cd@gmail.com  
Distributed under the Eclipse Public License either version 1.0 or any
later version.

_updated 2018-02-03_
