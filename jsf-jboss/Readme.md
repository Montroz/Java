
1) Запустить EAP_HOME/bin/jboss-cli.bat

2) Выполнить команду

module add --name=com.postgresql --resources=../../../../Users/vborisov/projects/postgresql-9.4-1204.jdbc4.jar --dependencies=javax.api,javax.transaction.api



3) Запустить EAP_HOME/bin/standalone.bat

4) В jboss-cli выполнить команды

connect

/subsystem=datasources/jdbc-driver=postgresql:add(driver-name=postgresql,driver-module-name=com.postgresql,driver-xa-datasource-class-name=org.postgresql.xa.PGXADataSource)
