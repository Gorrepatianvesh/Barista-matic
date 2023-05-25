Technologies - Spring Boot, Java 11, Maven,Postman
--------------------------------------------
Project Setup
---------------------
Do git clone repo using Gitbash or through IDE(Eclipse/ Intellij etc)

Open project in IDE

Do Maven clean install

Open BaristaMaticApplication.java file and then right click run as Java application


Below steps for different data inputs
---------------------------------------
1) Below endpoint will create initial ingredeint data .

http://localhost:8080/initialValues

![alt text](https://github.com/Gorrepatianvesh/Barista-matic/blob/main/Showcase/InitialValues.png)

| Method  | API                               | Request  | Response                    |
| ------- | --------------------------------- | -------- | --------------------------- |
| POST    |  http://localhost:8080/initialValues |          |  {     "Whipped Cream": {         "price": 1,         "quantity": 10     },     "Cream": {         "price": 0.25,         "quantity": 10     },     "Foamed Milk": {         "price": 0.35,         "quantity": 10     },     "Espresso": {         "price": 1.1,         "quantity": 10     },     "Decaf Coffee": {         "price": 0.75,         "quantity": 10     },     "Coffee": {         "price": 0.75,         "quantity": 10     },     "Cocoa": {         "price": 0.9,         "quantity": 10     },     "Sugar": {         "price": 0.25,         "quantity": 10     },     "Steamed Milk": {         "price": 0.35,         "quantity": 10     } }     |


2) Get the drink Caffe Mocha details

http://localhost:8080/getDrinkDetails/Caffe Mocha

![alt text](https://github.com/Gorrepatianvesh/Barista-matic/blob/main/Showcase/CaffeMocha.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getDrinkDetails/Caffe Mocha |          |  {     "price": 3.35,     "name": "Caffe Mocha" }     |


3)Get the drink Coffee details

http://localhost:8080/getDrinkDetails/Coffee

![alt text](https://github.com/Gorrepatianvesh/Barista-matic/blob/main/Showcase/Coffee.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getDrinkDetails/Coffee |          |  {     "price": 2.75,     "name": "Coffee" } |



4)Get the drink XYZ details

http://localhost:8080/getDrinkDetails/XYZ

![alt text](https://github.com/Gorrepatianvesh/Barista-matic/blob/main/Showcase/Invalid.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getDrinkDetails/XYZ |          |  Requested drink is not available|



5) Below endpoint will get current ingredeint data .

http://localhost:8080/currentValues

![alt text](https://github.com/Gorrepatianvesh/Barista-matic/blob/main/Showcase/CurrentValues.png)

| Method  | API                               | Request  | Response                    |
| ------- | --------------------------------- | -------- | --------------------------- |
| GET    |  http://localhost:8080/currentValues |          |  {     "Whipped Cream": {         "price": 1,         "quantity": 10     },     "Cream": {         "price": 0.25,         "quantity": 10     },     "Foamed Milk": {         "price": 0.35,         "quantity": 10     },     "Espresso": {         "price": 1.1,         "quantity": 10     },     "Decaf Coffee": {         "price": 0.75,         "quantity": 10     },     "Coffee": {         "price": 0.75,         "quantity": 10     },     "Cocoa": {         "price": 0.9,         "quantity": 10     },     "Sugar": {         "price": 0.25,         "quantity": 10     },     "Steamed Milk": {         "price": 0.35,         "quantity": 10     } }   |




6)Click on 5-6 times Coffee drink

http://localhost:8080/getDrinkDetails/Coffee

![alt text](https://github.com/Gorrepatianvesh/Barista-matic/blob/main/Showcase/NotAvailable1.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getDrinkDetails/Coffee |          |  Ingredients are not sufficent |



7) Below endpoint will reset ingredeint data .

http://localhost:8080/resetValues

![alt text](https://github.com/Gorrepatianvesh/Barista-matic/blob/main/Showcase/ResetValues.png)

| Method  | API                               | Request  | Response                    |
| ------- | --------------------------------- | -------- | --------------------------- |
| POST    |  http://localhost:8080/resetValues |          |  {     "Whipped Cream": {         "price": 1,         "quantity": 10     },     "Cream": {         "price": 0.25,         "quantity": 10     },     "Foamed Milk": {         "price": 0.35,         "quantity": 10     },     "Espresso": {         "price": 1.1,         "quantity": 10     },     "Decaf Coffee": {         "price": 0.75,         "quantity": 10     },     "Coffee": {         "price": 0.75,         "quantity": 10     },     "Cocoa": {         "price": 0.9,         "quantity": 10     },     "Sugar": {         "price": 0.25,         "quantity": 10     },     "Steamed Milk": {         "price": 0.35,         "quantity": 10     } }     |



To Run Junits 
-----------
Unit Testing  Junit (run com.barista.BaristaServiceTest.java class)

![alt text](https://github.com/Gorrepatianvesh/Barista-matic/blob/main/Showcase/junits.png)

For Dockerization
-----------------
use dockerfile to create image
