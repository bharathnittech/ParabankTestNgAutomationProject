# ParabankTestNgAutomationProject

Framework Design ---> Step by Step Procedure
============================================
1. Create new maven project  (Maven archetype ==> org.apache.maven.archetype ==> quickstart)

2. Adding all the dependencies required for our project in pom.xml
Dependencies 
--> browser driver setup ==> webdriver manager dependency (5.3.1)
--> web automation ==> selenium dependency (4.4.0)
--> framework support ==> testng dependency (7.4.0)
--> excel data ==> apche poi and apache poi-ooxml dependencies (5.2.3)
--> reporting ==> extent reports(3.0.0)

3. Adding plugins with in the pom.xml file to integrate framework with CI/CD tools

-->Maven Compiler Plugin ==> to maintain java versions to compile the code 
-->Maven Surefire Plugin ==> to maintain the testng suite files to run from maven

4. Creating folder structure

-->TestRunner ==> to maintain all testng xml files to run the scripts
-->Screenshots ==>to maintain all failure testcase screenshots
-->Reports ==>to maintain test reports
-->TestData ==>to maintain test cases related data excel sheets
-->Config ==> to maintain application configuration properties files

5. Creating Project Structure (multiple packages and classes to support automation)
-->src/main ==> will maintain all framework related programs
-->src/test ==>will maintain all application related programs

---->src/main will contain below components
--> com.framework.commons ==> all common methods related to web application automation
--> com.framework.webdriver ==> all common methods to launch , to close and to share browser driver details
--> com.framework.reports ==>all common methods to generate reports
--> com.framework.liseners ==> to maintain all the listeners to perform the operation based of the state and result of the test case
--> com.framework.utilities ==>to maintain all the utilities  to read excel, properties file and to maintain project constants 


---->src/test will contain below components
--> com.application.elements ==> to maintain all web-elements of application screens
--> com.application.actions ==> to maintain all the methods created to perform actions on webelements
--> com.application.tests ==> to maintain all test methods (actual test cases)

 
