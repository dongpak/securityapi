Security API
==================
Security API provides a helper function that deals with [JWT](https://jwt.io/),
and simplifies securing a REST API.

SecurityApi.process() takes one argument of type SecurityToken.
The existence of JSON Web Token in SecurityToken determines
whether the SecurityApi.process() signs and creates JSON Web Token
or verifies the JSON Web Token.

## Local Maven Repo
ARTIFACT=securityapi
VER=1.0
LIBS=./build/libs
JAR=$LIBS/$ARTIFACT-$VER.jar
GROUP=com.churchclerk
mvn install:install-file -Dfile=$JAR -DgroupId=$GROUP -DartifactId=$ARTIFACT -Dversion=$VER -Dpackaging=jar

## Jenkins v2.222
In Global Tool Configuration, 
* Add a Maven Installations
* Set name as "Maven 3.6.3" for example
* Check "Install automatically" 
* Select the version
* Add an installer from Apache.

As part of a build step, 
* Add "Invoke top-level Maven targets"
* Select the Maven installation "Maven 3.6.3" for example
* Set "install:install-file" as the goal
* Add -D parameters in the Properties

## Build Gradle
Add "mavenLocal()" to the repositories {} as shown below:
 
```
repositories {
    mavenCentral()
    mavenLocal()
}
``` 

Add following to dependencies:

```
implementation 'com.churchclerk:securityapi:1.0'
runtimeOnly 'com.auth0:java-jwt:3.2.0'
```
