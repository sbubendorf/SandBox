# Simon's Java Sandbox

## Oracle Driver

In case you have an error in your pom.xml like

```
Missing artifact com.oracle.jdbc:ojdbc6:jar:11.1.0.8.0	pom.xml	/SandBox
```

Then you have to download the Oracle JDBC driver from [Oracle](http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-112010-090769.html) and install the artifact into your local Maven repository with

```
mvn install:install-file -Dfile={path to your download directory}/ojdbc6.jar -DgroupId=com.oracle.jdbc -DartifactId=ojdbc6 -Dversion=11.1.0.6.0 -Dpackaging=jar
```





