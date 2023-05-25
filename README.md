Technologies - Spring Boot, Java 11, Maven,Postman
--------------------------------------------
Project Setup
---------------------
Do git clone repo using Gitbash or through IDE(Eclipse/ Intellij etc)

Open project in IDE

Do Maven clean install

Open RewardPointsApplication.java file and then right click run as Java application


Below steps for different data inputs
---------------------------------------
1) Below endpoint will create sample data in map.

http://localhost:8080/initialValues

![alt text](https://github.com/Gorrepatianvesh/Barista-matic/blob/main/Showcase/InitialValues.png)

| Method  | API                               | Request  | Response                    |
| ------- | --------------------------------- | -------- | --------------------------- |
| POST    |  http://localhost:8080/initialValues |          |  {     "Whipped Cream": {         "price": 1,         "quantity": 10     },     "Cream": {         "price": 0.25,         "quantity": 10     },     "Foamed Milk": {         "price": 0.35,         "quantity": 10     },     "Espresso": {         "price": 1.1,         "quantity": 10     },     "Decaf Coffee": {         "price": 0.75,         "quantity": 10     },     "Coffee": {         "price": 0.75,         "quantity": 10     },     "Cocoa": {         "price": 0.9,         "quantity": 10     },     "Sugar": {         "price": 0.25,         "quantity": 10     },     "Steamed Milk": {         "price": 0.35,         "quantity": 10     } }     |

2) Get the customer total earning points and monthly wise total earning points

http://localhost:8080/getRewardPoints?customerName=customer1

![alt text](https://github.com/Raghuj95/CustomerRewardPoints/blob/main/Showcase/customer1.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getRewardPoints?customerName=customer1 |          |  {"totalPoints":180,"rewards":[{"month":3,"monthPoints":50},{"month":4,"monthPoints":130}]}     |

3)Get the customer total earning points and monthly wise total earning points

http://localhost:8080/getRewardPoints?customerName=customer2

![alt text](https://github.com/Raghuj95/CustomerRewardPoints/blob/main/Showcase/customer2.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getRewardPoints?customerName=customer2 |          |  {"totalPoints":200,"rewards":[{"month":3,"monthPoints":90},{"month":4,"monthPoints":110}]}    |

4)Incase of user is not found

http://localhost:8080/getRewardPoints?customerName=customer10

![alt text](https://github.com/Raghuj95/CustomerRewardPoints/blob/main/Showcase/nocustomer.png)

| Method  | API                                                          | Request  | Response                    |
| ------- | ------------------------------------------------------------ | -------- | --------------------------- |
| GET     | http://localhost:8080/getRewardPoints?customerName=customer10 |          |  {"totalPoints":0,"rewards":[]}    |

To Run Junits 
-----------
Unit Testing  Junit (run com.points.PointsServiceTest.java class)

![alt text](https://github.com/Raghuj95/CustomerRewardPoints/blob/main/Showcase/Junits.png)

For Dockerization
-----------------
use dockerfile to create image
