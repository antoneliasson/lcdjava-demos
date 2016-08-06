LCDjava basic demo with Log4j2
==============================

This very simple demo shows how to interface with LCDjava and how to get LCDjava to log with Log4j2. It shows a single LCDproc screen with a title and a static string.

Building and running
--------------------

This is a Maven project. `mvn compile` to build the code and `mvn package` to make a JAR (this project only, without its dependencies).

To run it using Maven's exec plugin, use a command line like the following. This will make sure that all dependencies are available in the classpath before running.

    $ mvn exec:java
    [...]
    Usage: java org.boncey.lcdjava.demo.Demo <LCD host> <LCD port>
    $ mvn exec:java -Dexec.args="192.168.1.171 13666"
    16:42:49.342 [local.lcdjava_demos.BasicDemo.main()] INFO  org.boncey.lcdjava.LCD - Connected
    Connected to LCDd: Version = 0.5.7; protocol version = 0.3; width = 20; height = 4; cell width = 5; cell height = 8
