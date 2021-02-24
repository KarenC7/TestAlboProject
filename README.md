# TestSpringProject
Application with Rest Services to get information about Marvel Characters and Comics Collaborators

## Requeriments
- Tomcat 7
- Java 8 (java version "1.8.0_281" 
- Mysql


## Database (MySQL)
1. Import the database on your local DBM (Suggested: XAMPP)
- By command line:  mysql -u username -p database_name < marvel.sql
2. You can find the configuration of DB on application.properties to change name or credentials

## To run code
1. Clone repository on your workspace
2. Open the project on your IDE
3. Maven Update *Force Update of Snapshots/Releases 
4. Run Maven Clean
5. Configure Tomcat 7.0 Server
6. Run on server (*If you can not initialize on Server then ->
    1. Run configurations -> Java Application -> New Configuration -> Select Project Test Albo -> Define main.class like com.albo.test.TestApplication
    2. Run configurations -> Run
)

## Main services
Important: You can find all posible request on https://www.postman.com/KarenCast7/ -> Test Albo

1. To get collaborators and roles by Character
http://localhost:8080/marvel/collaborators/ironman
http://localhost:8080/marvel/collaborators/capamerica

2. To get characters and comics by Character
http://localhost:8080/marvel/collaborators/ironman
http://localhost:8080/marvel/collaborators/capamerica

3. To do Sync of information
http://localhost:8080/_api/sync

3. You can change {localhost:8080} by {test.albo.mx}


## Keys to Use Api Key from Marvel
- Public Key: 1760c45ca4cabd6e9d4010e56df45bbd
- Private Key: 6774102a7410e67fffcc23a50614ecb53931d340
- Ts: 1

For example, a user with a public key of "1234" and a private key of "abcd" could construct a valid call as follows: http://gateway.marvel.com/v1/public/comics?ts=1&apikey=1234&hash=ffd275c5130566a2916217b101f26150 (the hash value is the md5 digest of 1abcd1234)

Note: You can find the call on SyncController.java and change the params

## To generate JAR
1. Run As -> Maven build
2. Write on blackspace "Goals": package
3. Run


## To execute .sh files 
1. Put getInformation.sh on {projectPath}/target or in the same path where you generate or save "test-0.0.1-SNAPSHOT.jar"
1. Example: exect on console ./getInformation.sh  (Recommended Git bash)
Nota: getInformation.sh run the application, then you can test services





