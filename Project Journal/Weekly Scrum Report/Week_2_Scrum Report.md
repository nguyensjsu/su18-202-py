# Scrum Report 2

What did the team do the past week?

What is the team going to do next week?

What are the current blockers/challenges the team is facing?


## Yamini Muralidharen

-  Worked on migrating from local dynamo db to aws dynamo db
-   worked on querying Menu to display the list of items and sizes available 
-  Worked on payments api that will check the following scenearios
-  Check whether the card is valid 
-  Check whether the balance is sufficient to make transaction 
- Check whether order is valid to make a transaction
- Worked on deploying the microservice to a load balanced EC2 Cluster 
- We focussed on the XP core value as Feedback as it helped us to merge the code into a single code base and make changes to the code to accomplish the flow .

### Blockers
- We faced challenges while migrating to global db and deploying  it to clusters.


## Gyanesh Pandey
- Worked on setting up local DynamoDB and then connected to the global DynamoDB instance.
- Completed the AddCard API from the data model to API endpoint.
- Added some failure scenarios. Card number should be 16 digit and Pin should be 4.
- Worked on packaging an external jar as a dependency in the project.
- Deployed the jar to a docker container on AWS. 

### Challenges
- Addition of an external jar took quite a bit of searching as it is not a favorite methodology these days.



## Abhi Yelipeddi
1. Successfully implemented spring boot application and connected to local orders dynamodb.
2. Implemented makeorder, showall, deletebyid, orderbyid, deleteall REST APIs using local dynamodb
3. Migrated from local dynamodb to global dynamodb order table.
4. Worked on adding random id generator for the ordered primary key in ordertable.
5. Worked on OrderService.java and OrderServiceImplementation.java files. These files implement APIs for find the order name and call the respective coffee classes to get the cost.
6. Decoupled the code from the controller and model and moved the business logic change from 
order controller to model package
7. Integrated code with other team members and verified the order REST APIs on Postman
8. Implemented some jUnit test cases for delete all REST API and showall REST APIs
9. Worked on Architecture diagram 
10. Analyzed and studied the steps to deploy jar in Elastic Bean Stack

## Challenges
1. Integrating with other team members REST APIs. 
2. Merging and modularizing the code in a common project.


## Vidhi Sharma
- Worked on differnet operations for User API like saving the user detials, deleting the details, quering the user details
- Wrote AWS Policy for the access control of IAM Users and Roles
- We worked on mergeing all the API's created by team memembers and Resolved all merge conflicts
 

### Blockers
- Created Authentication API using lamba functiona and API Gateway but facing issues while invoking Lambda function

