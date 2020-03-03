#!/bin/sh
ARTIFACT=securityapi
VER=1.0
LIBS=./build/libs
JAR=$LIBS/$ARTIFACT-$VER
GROUP=com.churchclerk

cp $JAR-SNAPSHOT.jar $JAR.jar

/c/wip/apache-maven-3.6.1/bin/mvn install:install-file -Dfile=$JAR.jar -DgroupId=$GROUP -DartifactId=$ARTIFACT -Dversion=$VER -Dpackaging=jar
