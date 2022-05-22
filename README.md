# Build Tool

In the Java ecosystem, build tools are a crucial part of the software 
development process. But they also add a lot of complexity that is best managed 
by integrated development environments (IDEs) like Apache NetBeans or IntelliJ 
IDEA.

You can see a similar phenomenon with Scala: sbt is the most used build tool for 
Scala projects. Originally referred to as "Simple Build Tool" but first released 
as just "sbt," some people started calling it "Scala Build Tool." Both acronym 
expansions are incorrect: sbt has always been able to build Java-only projects, 
and if it was ever simple, it sure as hell no longer is.

In this project, I aim to create a build tool for Java-only projects that is as 
simple as I can make it, and opinionated only when necessary to avoid 
complexity.

Instead of using XML files, the build tool will use markdown files to describe 
the project structure and [FINISH WRITING]
