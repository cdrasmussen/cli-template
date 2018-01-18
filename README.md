# cli-template

## Description

  This is a template for a CLI utility program in Clojure. Its goal is to
  minimize the effort of repeatedly building similar machinery.  
  Edit parts you want, delete what you don't want.
  
  It has no core functionality of its own since the expected sequence
  is to build a core functionality module with its own unit tests then
  use this code as a basis for a command line utility that will host
  your new core module.

  By using this development pattern the developer is following the
  strategy of polyvalent development described in Eric Raymond's "Art
  of Unix Programming".

  Command line parsing is provided by clojure.tools.cli for which we
  are all grateful.

## Installation

  Download from http://github.com/cdrasmussen/cli-template

## Invocation

  $ lein uberjar
  $ java -jar target/uberjar/cli-template-0.1.0-standalone.jar [args]

## Options
<pre>
  Usage: cli-template [-v|--verbose] [-q|--quiet]
                   [-h|--help] [--version] [--trace]
  
  Where:
  -v|--verbose enable verbose output messages, (repeatable)  
  -q|--quiet reduces normal program output to a minimum  
  -h|--help prints this usage text  
     --trace prints trace info  
     --version prints program version
</pre>

## Additional Files

  * src/manual.clj  
    An exercise in automating a manpage embedded in source code.  
    It is in it's own file so as not to force developers to
    deal with its verbosity when developing a simple utility where
    an embedded man page isn't apropos.

  * src/trace-ops.clj
    Simple trace functions enabled by a boolean.

## Notice to Developers

  I wrote this to help other developers, especially those new to Clojure.
  To share your thoughts on this topic, please email me at
  rasmussen.cd@gmail.com with cli-template in the subject line.

## License

Copyright © 2017 CD Rasmussen, rasmussen.cd@gmail.com

Distributed under the Eclipse Public License either version 1.0 or any
later version.

_updated 2018-01-18_
