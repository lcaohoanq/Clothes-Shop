# Required
- Tomcat: 8.5
- JDK: 1.8
- SQL Server
- Maven 3.9.6 (currently using)

# Config
> I'm using IntelliJ
## Tomcat
- Edit configuration:
  - Add New Configuration (+) -> Tomcat Server -> Tomcat Local
  - At tab Server
    - Application server -> Configure... (point to the path where tomcat installed, `C:\Program Files\Apache Software Foundation\Tomcat 8.5`)
  - Tab Deployment
    - Add Artifact...
    - Config Application context (optional)
## Maven
```bash
mvn clean
mvn install1
```

## Databases

- port: 1433
- Create `.env` file at root directory

```text
DB_URL=jdbc:sqlserver//<your_host>:<port>;DatabaseName=ClothesShop
DB_USER=<username>
DB_PASSWORd=<password>
```
