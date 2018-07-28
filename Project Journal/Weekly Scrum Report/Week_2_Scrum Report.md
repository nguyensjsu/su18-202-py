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



## Vidhi Sharma
- Worked on differnet operations for User API like saving the user detials, deleting the details, quering the user details
- Wrote AWS Policy for the access control of IAM Users and Roles
- We worked on mergeing all the API's created by team memembers and Resolved all merge conflicts
 

### Blockers
- Created Authentication API using lamba functiona and API Gateway but facing issues while invoking Lambda function

