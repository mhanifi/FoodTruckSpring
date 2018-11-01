# FoodTruckSpring

In this version I tried to use STS to create the RESTFull web service for the food truck project that was done before.

## Process
It is looking into the URL that is provided for FoodTruck data and read the information directly from there. It is getting user's latitude and longitude from user as part of the URL and feed it to the backend service to get the top 5 closest FoodTrucks. 

## Backend
I created an HTTP Get request using java Spring. It is a maven project. For the front-end it hasn't been completed due to lack of time but I'll get back to it and I used the same API from Google. this time instead of getting user's geolocation using the APL I am getting it from the user. 

## Build & Run
I could provide a good old war file for deploying on an external web server. Instead to make it simple I just used a main class and created a jar file so you can run the jar file and hit your http://localhost:8080/mylocation?lat=37.75212416&lon=-122.4032299
As you can see I used a sample lat & Lon in the URL.

I wll update this project with a proper UI that shows the locations on the map. Also it is lacking the test cases as well. 
