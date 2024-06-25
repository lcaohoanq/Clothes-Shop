# Setup

## Required
- Tomcat: 8.5
- JDK: 1.8
- SQL Server | Azure Data Studio
- Maven 3.9.6

## Databases
- Create file `.env` at root directory with below data

```text
DB_URL=jdbc:sqlserver://localhost:1433;DatabaseName=ClothesShop
DB_USER=sa
DB_PASSWORD=
GOOGLE_CLIENT_ID=
GOOGLE_CLIENT_SECRET=
GOOGLE_REDIRECT_URI=
GOOGLE_LINK_GET_TOKEN=https://accounts.google.com/o/oauth2/token
GOOGLE_LINK_GET_USER_INFO=https://www.googleapis.com/oauth2/v1/userinfo?access_token=
GOOGLE_GRANT_TYPE=authorization_code
```

***
# Report
## [1]. Introduction
[<img src="intro.gif">](https://github.com/lcaohoanq/Clothes-Shop/blob/main/intro.gif)

## [2]. Feature
### Login

![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/47c7b065-0a27-4fc7-810b-ba849f5a756d)

- [Advanced] Login with Google

![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/57869e8c-2679-44ca-9c48-f3b36ef0fd25)

![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/c7475b69-11c7-4a63-b34a-6bd949bab872)

- Privacy & Terms Of Service
![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/230528e6-a2f7-4608-8ec6-778bfda0f5d4)

![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/d8a8ce32-e3e7-4db3-b781-cb58e83832a8)

- See user profile

![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/4f0e1149-9f7f-4323-a432-aed53813aef9)



### Wishlist
![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/17208a4a-1b7b-4b2c-959f-d2eb02091a3a)

### Cart
- View Cart
- ![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/9876d72c-2a3f-41e3-8662-b99935bbe3cc)
- Update Cart
- ![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/5b255980-e4c2-4a2a-9e5a-143c9241bf60)
- Delete Cart
- ![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/c44e7933-6d8d-43a7-ac1d-ae2dd043ad5c)


### Checkout
![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/a6589914-9788-4409-b343-573eae961717)

- Normal user do checkout
![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/13d4e82f-8979-4772-943e-ce7a2b883256)

- Admin cannot perform the checkout feature
![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/4e584574-14ed-4738-8ea6-732f0dc32158)


- Require Login for checkout
![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/540478af-b088-4b7c-8970-4d487035daaf)

### Admin
![image](https://github.com/lcaohoanq/Clothes-Shop/assets/136492579/b0e5253d-3222-411b-a847-aec4d1b6fd06)

