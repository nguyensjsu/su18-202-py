Week 1 Scrum Report 

What did the team do the past week?

What is the team going to do next week?

What are the current blockers/challenges the team is facing? 

Gyanesh Pandey

Past Week
- We focussed on defining the problem. We also had a brainstorm session to figure what might be interesting features we might want to build on top of the basic ones.

- I created wireframes for the app, which help see the different user journeys.

- We created a Data Model which will support the Use Cases we want to tackle.The basic infrastructure for a spring boot application with DynamoDB has been set up.

Next Week
- We intend to complete our respective APIs and also merge it together.

Blockers/Challenges
- We are not sure about deploying into Docker containers. We hope to make progress on that front.



-----------------------------------------------------------------------------------------------------------------------------


Yamini Muralidharen


Past week
- We discussed the order of flows and finalized the apis which we are going to implement

-  Brainstormed with the team and proposed to use local dynamo db with spring boot 

- Refined the table models after discussing with the team

- Worked on payments api to get the value of the card table from local dynamodb and tested the api through Postman

- We focussed on the XP core value Communication and this helped us to understand the problem statement and come up with a better approach in the implementation of the project

Next Week

- I will be working on the payments api to query the cost from menu table 
- Check for balance from the card and process the order based on the card balance
- On successful payment , will send update to add the order 
- Deploy the apis to containers and migrate to global Dynamodb  


Challenges

- We have to look into database connectivity issues that may raise after deploying to containers



-----------------------------------------------------------------------------------------------------------------------------

Abhinaya Yelipeddi
-------------------

Past Week:

1. Did Brainstorming with the team members about the team project and ideas.
2. Finalized the data model during team discussions.
3. Learnt and understood the REST APIs, Curl, Postman and its usage.
4. Committed initial project (starbucks-py) to GitHub. The project is based on Spring Tool Suite/Spring Boot.
5. Added Order POJO with Ordername, Order id and price attributes to the Spring Boot project.
6. Worked on task prioritization with the team members.
7. Understood the serverless design model by referring to examples in Serverless Architectures on AWS book and other examples available online.
8. Used serverless boilerplate template aws-java-maven which has AWS lambda boilerplate code and created a (starbucks-orders) project. Used GET, POST and DELETE REST APIs to add order, delete order, show all orders and show specific order based on order id.
9. Used dynamodb as the data repository for the serverless project and deployed the project to AWS.
10. Documented the serverless order project deployment and tested using Curl and attached screenshots for the get orders, show all orders etc and also dynamodb order table in the AWS.
11. During scrum meetings with team members, identified other attributes to be incorporated such as timestamp, user id etc.
12. As we cannot deploy the serverless REST APIs in containers, resumed working on the Spring Boot implementation of the order REST APIs.
13. Implemented GET, POST and DETETE REST APIs for orders in the Spring boot project. But was using a local repository to save orders.
14. Yamini provided information/pointers about the local dynamodb. Referred to that information and created a local dynamodb instance.
15. Working on implementing the order REST APIs using Spring Boot using dynamodb instead of local repository to save orders.

Next Week:

1. Complete the Spring boot project for order REST APIs using dynamodb
2. Integrate with other team members REST APIs 
3. Will try to work on extra credit items if we do not forsee any integration issues.
4. Migrate from local dynamodb Order table to the main order table created by Vidhi.

------------------------------------------------------------------------------------------------------------------------------





Vidhi
