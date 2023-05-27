I think I will open this project to Hacktoberfest 2023.

# Guidelines for Hacktoberfest 2023 Contributors

I will definitely consider pull requests associated with an issue and maybe 
consider pull requests associated with a TODO (considered an Action Item in 
NetBeans).

Contributors should have a proper Java IDE (most are available for free) and 
TestNG. This project uses Java 8 and TestNG. Contributors may use later versions 
of Java provided they don't use features not available in Java 8.

In my testing framework project, I demonstrated that it's possible to create a 
testing framework without using an existing testing framework. Surely it's 
possible to create a build tool without an existing build tool, but I wasn't  
interested in that.

Not at first anyway. So at first this project used Apache Ant, which, as far as 
I can tell, is the NetBeans default. However, once I get the auxiliary stuff 
working, I will change the project to not use any existing build tools.

Pull requests trying to impose Maven or Gradle on this project will be rejected 
as spam. If there's an example of how not to make a build tool, that's gotta be 
Maven.

Pull requests about making this build tool build itself will be viewed much more 
favorably.
