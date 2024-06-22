## Required
- Tomcat: 8.5
- JDK: 1.8
- SQL Server | Azure Data Studio
- Maven 3.9.6

## Databases
- Create file `.env` at root directory with below data

```text
DB_URL=jdbc:sqlserver://localhost:1433;DatabaseName=ClothesShop
DB_USER=
DB_PASSWORD=
GOOGLE_CLIENT_ID=
GOOGLE_CLIENT_SECRET=
GOOGLE_REDIRECT_URI=
GOOGLE_LINK_GET_TOKEN=https://accounts.google.com/o/oauth2/token
GOOGLE_LINK_GET_USER_INFO=https://www.googleapis.com/oauth2/v1/userinfo?access_token=
GOOGLE_GRANT_TYPE=authorization_code
```
