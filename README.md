# spring-boot-shell-out

This project is a POC for a customer who wanted to understand how to build a Command Line Interface (CLI) Wrapper in Spring Boot for pushing to Pivotal Cloud Foundry.  Their use case was that they wanted to use https://github.com/pivotalservices/cf-mgmt and git to create a web service to manage their Orgs and Spaces within Cloud Foundry.

This framework could be used as a wrapper for any CLI in a conatiner, pushed to Cloud Foundry.  This could allow you to automate environments any CLI to perform the actual execution while avoinding having to use the API (if available, and supported) directly.  There are much better ways of doing this if the wrapper was written in go using vendoring.

# How to use this Code

``` 
maven clean package
cf push -p target/shellout.zip
curl https://<enter cf endpoint here>
```
You should get some basic output showing git help, cf-mgmt help and a full listing of the container directory.


# A few Notes:
-----
1. You have to use maven-assembly-plugin to create a zip.  The spring-boot-maven-plugin will not let you set POSTIX file permissions.  

2.  You cannot use JAR or WAR.  The Jar command does not support archive creation with file permissions.  (Thinking about it a little more we did not try and just create a ZIP with spring-boot-maven-plugin and see if the file permissions get automatically added correctly.)

3. You have to manually set the manifest entries that org.springframework.boot.loader.JarLauncher expects to be there, otherwise the app will not start.  We coudln't find an easy way to repackage the original Jar and reuse the MANIFEST.MF (Maybe we should have tried harder).
