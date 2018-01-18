# cli-template

## Description

  This is a template for a CLI utility program in Clojure. Its goal is to
  minimize the effort of repeatedly building similar machinery.
  
  It has no core functionality of its own since the expected sequence
  is to build a core functionality module with its own unit tests then
  use this code as a basis for the command line utility that will host
  that core module.

  By using this development pattern the developer is following the
  strategy of polyvalent development described in Eric Raymond's "Art
  of Unix Programming".

  Command line parsing is provided by clojure.tools.cli for which we
  are grateful.

## Installation

  Download from http://github.com/cdrasmussen/cli-template

## Invocation

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

### Additional Files

  * src/manual.clj  
    Exercise in automating a manpage using program source.  
    It is in it's own file so as not to force developers to
    deal with it when developing a simple utility.

  * src/trace-ops.clj
    Simple trace functions enabled by a boolean.

## License

Copyright © 2017 CD Rasmussen, rasmussen.cd@gmail.com

Distributed under the Eclipse Public License either version 1.0 or any
later version.

_updated 2018-01-18_
