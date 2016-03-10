# Introduction #

If you want to dive in and experiment with the automated tests, there are various steps you need to complete. Here's an overview of these steps. You may need to do some additional research if you're unfamiliar with some of the tools and concepts. Let me know how you get on by commenting on this wiki page. I can't promise I'll be able to help in individual cases, however I do read all your comments and try to improve the documentation and the project code based on comments and feedback.

I recommend using Microsoft Windows or Ubuntu to run the code as webdriver (see later) supports native events on these platforms. Native events allow webdriver to generate the tab characters used by some of this project's tests.

Also, the tests are currently written to use Firefox. I recommend you start with running the tests with Firefox (install a current version if you don't have the program already). You can tweak and experiment with other web browsers, platforms, etc once you've comfortable with running the example tests.

# Details #
Checkout the code from this site. See http://code.google.com/p/web-accessibility-testing/source/checkout for details of how to do so, you probably need to install a subversion client program, or similar software. There is some general advice from the code.google.com site on how to do so.

This project relies on the opensource WebDriver test automation tool, available as part of the selenium project http://code.google.com/p/selenium Download selenium-java-xxx.zip from http://code.google.com/p/selenium/downloads/list and unpack the contents of the file into a known folder.

For the internal tests, this project also relies on an older version of an embedded web server called jetty. Download jetty 6 from codehaus http://dist.codehaus.org/jetty/ Take the latest version (with the highest version number) and unpack the contents.

You will also need a Java compiler. I typically use Oracle's JDK available to download from http://www.oracle.com/technetwork/java/javase/downloads/index.html
If you use eclipse:
  * Create a new eclipse project, link it to the downloaded source for this project.
  * Add the jar files found in the `thirdparty/libs` to the java build path.
  * Add all the libraries from the unpacked selenium-java-xxx.zip to the build path as external libraries. These include the core library, named `selenium-java-`_version-number_`.jar ` and every file in the `libs` sub-folder. Currently there are around 45 jars in total.
  * Add the 3 jetty jar files from the lib folder to the build path in eclipse.

You should now be able to compile and run the tests. The tests are written as JUnit tests. The tests should each start a fresh instance of Firefox, tab around the web page - highlighting the visited elements with an orange background and complete without error.

Now you can experiment with creating tests for your web application. Good luck with your bug hunting!

# Coding Examples #
We have provided 2 Examples, one for the WCAG decorators the other for the Tabbing test. These files are called `Example.java` You can edit these files to change the URL of the content to test, or you can pass the URL as a command line parameter without needing to change the code at all.

## Examples of using the Accessibility Decorators ##
Here is a straight-forward example of running the Accessibility Decorators against this wiki page.
The key steps are:
  1. Get a copy of the HTML, in the following example we use jsoup. Tools such as Selenium would also work well and pages can even be loaded from a local file if all else fails.
  1. Create a new 'evaluator' object. Then add one or more packages e.g. wcag here.
  1. call `collectIssues` to apply the package(s) to the HTML contents.
  1. In this simple example we simply write the results to the console. Often you would want to write these to a log file instead.
```
document = Jsoup.parse(new URL("http://code.google.com/p/web-accessibility-testing/wiki/GettingStartedWithTheCode"),
                                        TIMEOUT);
                Evaluator evaluator = new Evaluator();
                evaluator.addPackage("org.a11ytesting.test.wcag");
                List<Issue> result = evaluator.collectIssues(document);
                
                for (Issue issue : result) {
        System.out.println(issue.toString());
                }
                  
```
## Fixing errors ##
You might encounter strange errors when first getting the code working on your machine; or you may discover problems and issues with the code, our designs, implementations, strange quirks on web sites you'd like to test, etc. This section is the starting point for all these topics.

### Fixing Build and Runtime issues ###
  * HttpHost not found - check you've included all the supporting jar files for Selenium/WebDriver. Currently there are roughly 10 jars in addition to the main selenium jar file.
  * Jetty BindException Address in use: Although I thought jetty would pick an available port I managed to create an environment where it picked port 8080 even though Android's adb had port forwarding set for 8080. I noticed the problem by loading http://localhost:8080/ in a web browser when I noticed something looking like a webdriver instance (wd/hub etc). After running `adb kill-server` **my** jetty instance was able to use port 8080 and the relevant tests ran.

### Problems and Issues with the code ###
Please create a new issue on this site. Tell us which revision of the code you're using, the operating system details, which version of Selenium/WebDriver you're using, the Driver you're using (Firefox, Chrome, IE, etc), and ideally provide either a URL of a web page where you're finding problems or some sample Web Content and a simple example of the failing test.

### Strange quirks ###
Raise an issue on this site. Like reporting an issue with the code, please provide as much detail as you can and describe the quirk(s) you discovered.