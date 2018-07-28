# su18-202-py

Architecture Diagram:
---------------------

![alt text](https://github.com/nguyensjsu/su18-202-py/blob/master/Architecture_diagram.png)

Overall Feature Set:
--------------------

1. Authenticate User and save user details in backend dynamodb
2. User can see the menu of various types of coffee available 
3. User can place order and specify the coffee size and the quantity 
4. If the user card has sufficient balance to cover the order, the order is placed.
5. Once the order is placed, it is saved in dynamodb.
6. User can query the order based on id.
7. User can delete the order based on id.
8. Api to show all the orders placed
9. Api to delete all the orders placed.
10. Api to delete the saved card.
11. Deployed API in AWS in Auto Scaled EC2 Cluster with Load Balancer
12. Deployed API to AWS as Docker Containers in Amazon Containers
13. Deployed the order API in AWS using Serverless framework using dynamodb and Amazon Lambda

Application Block Diagram:
--------------------
![alt text](https://github.com/nguyensjsu/su18-202-py/blob/master/CoffeeApp%20Block%20Diagram.png)

