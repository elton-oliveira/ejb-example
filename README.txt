1) The first thing that must be done is set the value of jboss.home in build.properties file to point to your jboss 7

2) Installing a JDBC driver as a module:
Step 1) Create a directory "fluentcode/oracle-driver/main" inside the "JBoss/modules" directory.
Step 2) Paste your "ojdbc6.jar" oracle Jdbc Driver inside the directory you created.
Step 3) Create a file "module.xml" inside the directory you created as following:

<module xmlns="urn:jboss:module:1.1" name="fluentcode.oracle-driver">
    <resources>
        <resource-root path="ojdbc6.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
        <module name="javax.servlet.api" optional="true"/>
    </dependencies>
</module>

Step 4) Open your "JBoss/standalone/configuration/standalone-full.xml" file and find <drivers> tag. Then add the driver declaration tag refering to your module as following:

<driver name="OracleJDBCDriver" module="fluentcode.oracle-driver"/>

3) Through the JBoss Web Interface creates the dataSource with JNDI java:jboss/datasources/OracleDS

4) To generate the jar project, deploy and run server, in terminal, run:

ant server.run