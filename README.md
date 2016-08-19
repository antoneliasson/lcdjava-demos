LCDjava big clock demo with SLF4J-Simple
========================================

This demo shows how LCDjava can be used in a project that periodically updates the display. It uses a Thread that gets the current time, formats it and displays it on the LCD using LCDproc Big Numbers. The thread then sleeps for a second (compensated for computational and thread-release delays) and starts over until interrupted.

It uses SLF4J's Simple Logger implementation, which just sends all log messages to STDERR.

Building and running
--------------------

This is a Maven project. `mvn compile` to build the code and `mvn package` to make a JAR (this project only, without its dependencies).

To run it using Maven's exec plugin, use a command line like the following. This will make sure that all dependencies are available in the classpath before running.

    $ mvn exec:java
    Usage: java BigClock <LCD host> <LCD port>
    $ mvn exec:java -Dexec.args="192.168.1.171 13666"
    [local.lcdjava_demos.BigClockDemo.main()] INFO org.boncey.lcdjava.LCD - Connected
    Connected to LCDd: Version = 0.5.7; protocol version = 0.3; width = 20; height = 4; cell width = 5; cell height = 8
    Press Ctrl+C to exit
    ^C[Thread-1] DEBUG org.boncey.lcdjava.LCD - Shutdown requested
    [Thread-1] DEBUG org.boncey.lcdjava.LCD - Waiting for LCDSocketPoller to terminate...
    [Thread-2] DEBUG org.boncey.lcdjava.LCDSocketPoller - Terminating
    [Thread-1] DEBUG org.boncey.lcdjava.LCD - Closing socket
