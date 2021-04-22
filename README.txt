==========================
DESCRIPTION
==========================
This readme file describes the steps our team took to
install the software we used throughout this semester for our capstone project.

In our final documents submission, we've included all of the installation files
mentioned in this readme document.

======================
ORDER OF INSTALLATION
======================
1. JDK 14
2. NetBeans 12
3. Apache Tomcat 9 application server
4. MySQL 8 database server


********************
JDK 14 Installation
********************
-Run jdk-14.0.2_windows-x64_bin.exe
-Press leave any settings as default and press next
until you reach the installation screen. The JDK will now install (~10 minutes).
-After installing, click close

*************************
NetBeans 12 Installation 
*************************
-Run Apache-NetBeans-12.0-bin-windows-x64.exe
-Accept terms and leave default settings and press next 
until you reach installation screen. NetBeans will now install (~10 minutes)
-After installing, click finish

*****************************
Apache Tomcat 9 Installation
*****************************
-Before installation, ensure both 8080 and 8005 ports are not in use
as these are the ports used by Tomcat
-Run apache-tomcat-9.0.37.exe
-Accept terms and leave default settings and press next
until you reach the configuration menu
-Change the Server Shutdown Port to 8005
-Input "admin" into both username and password fields
-Continue pressing next until you reach installation screen. Apache Tomcat will now install (~10 minutes).

***************************************
MySQL 8 database server Installation
-Note- This setup requires a few steps
***************************************
-Run mysql-installer-community-8.0.21.0.msi
-Select Developer Default as setup type (selected by default) and press next
until you reach Check Requirements.
-Press Execute (install everything you're prompted to) and press next once complete
-When you reach MySQL-related items to be installed, press Execute
-Press next until you are asked for MySQL password.
-Enter root password as "password"
-Press next 2 times and then press Execute
-Press Finish
-Press next
-Press Finish
-Press next and enter "password" and check to ensure its correct
-Press next and press Execute
-Click Finish
-Click next and uncheck Start MySQL Shell after Setup and press Finish


=====================
CONFIGURING PROJECT
=====================
1. Adding Apache Tomcat
2. Adding Libraries and .jar files


*********************
Adding Apache Tomcat
*********************
-Open NetBeans
-Select Services tab
-Click Add Server and choose Apache Tomcat from the list
-Within the server location, input the location of of Tomcat on your machine
-Enter admin as both username and password
-Click finish and close

********************************
Adding Libraries and .jar files
********************************
-Open NetBeans and select the Capstone project
-Right click and open project properties.
-Open Libraries tab
-Click Add Library
-Select JSTL 1.2.1 and EclipseLink (JPA 2.1) and click Add Library
-Select add JAR/FOLDER
-Add the following .jar files
	org.eclipse.persistence.moxy-2.5.2.jar
	gson-2.8.6.jar
	javax.mail.jar
	mysql-connector-java-8.0.21.jar


===========
CONCLUSION
===========
This concludes the software installation of our Capstone project.

Regards,
Level Ground Recruitment developers (Kane Imler, Anthony Hosemann, Armaan Singh Klair, Amir Soltani, Kent Pawson).
