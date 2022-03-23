# Api Challenge for Hiring Event

The project is an attempt to solve one of the challenge provided by one of the Company in one of the Hiring Event

Problem Statements:

1. To display the first entry of total individuals vaccinated for a given state as `/<state>`

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

## Running the tests (Testing API using PostMan)

<!-- Giving the link to the heroku deployment and mentioning the response ot the link -->

## Deployment (to heroku for better access) 

<!-- Deploying the war onto Heroku and testing with the link
 -->
 The WAR is deployed on the Heroku server with the url to the WAR as `https://netcore-api-heroku.herokuapp.com/`. As there is no home page mentioned inthe WAR so it will not return anything when the above url is visited.
 
 1. For the first problem statement, the WAR should be visited at theh url `https://netcore-api-heroku.herokuapp.com/` along with the endpoint `/getTotal`  and the state name. For example the url with the endpoint for the state `Assam` would be
 > `https://netcore-api-heroku.herokuapp.com/getTotal/Assam`
 
 [Click here to visit the link and see the result(first entry of total individuals vaccinated) for state = Assam](https://netcore-api-heroku.herokuapp.com/getTotal/Assam).

## Built With

- Spring - The most used Web framework in Java
- Java - The undelying language used.
- Postman - For API testing
- Tomcat V9 - As a Local development server

## References:

- [Baledung Spring website](https://www.baeldung.com/)
- [Heroku Website for deploying WAR](https://devcenter.heroku.com/articles/war-deployment)
