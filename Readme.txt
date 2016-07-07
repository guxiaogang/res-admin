Preparation:
1,This APP is based on JDK7, please install JDK7 first.
2,This App is build by Maven, please install Maven, version 3.0 or above.
3,Database:mysql. Create Database, db name 'res' is recommended.
4,Initialise DB tables, SQL script: res.sql

Debug
1, Excute mvn eclipse:eclipse in the project dirctory.
2, Import project into eclipse workspace.
3, Change config file 'db-config.properties' in src\main\resources\conf, includs db user name and db password.
3, Debug the Main Class 'ApplicationServer.java' in package:com.anz.res

Package
1,Excute commond 'mvn package'. if successful, you will find 'admin.war' in the 'target' directory.


