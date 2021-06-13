# HybridWeather Backend

Backend solution made with Spring Boot for using and parsing data from https://openweathermap.org API. The application uses data from the 5 day weather forecast endpoint 
(https://openweathermap.org/forecast5#cityid5) for 3 predetermined cities and makes endpoints for further handling with them.

## How to run :arrow_forward:
Running the app via java (you must have java 11 installed on your device):
> $ java -jar out/artifacts/Hybrid_Weather_jar/Hybrid-Weather.jar

Running the app via Maven (you must have Maven installed on your device):
Step 1:  
> $ mvn install  

Step 2:  

> $ mvn spring-boot:run  

Or use any modern IDE (Intellij, Eclipse, etc.) and just run it.

## Functions :gear:

:heavy_check_mark: Changeable APP_ID for openweather api in application.propreties  
:heavy_check_mark: Changeable CITY_NAMES and COUNTRY_CODES in application.propreties  
:heavy_check_mark: Changeable UNITS (metrics, imperial) which data is presented in application.propreties  
:heavy_check_mark: REST endpoint for fetching all the cities  
:heavy_check_mark: REST endpoint for fetching the average temeprature for all the cities  
:heavy_check_mark: Average temperature endpoint can take query parameters for further customization on data sent  
:heavy_check_mark: Average temperature endpoint auto sorted by temperature

## TODO :books:

:clipboard: Add more RuntimeExecptions for better error handling  
:clipboard: Add a DTOs for all the models, especially the ApiResponseObject  
:clipboard: Try and remove all for loops with streams/parralel-streams  
:clipboard: Add a simple database for caching results (Redis, H2...)  
:clipboard: Add function for getting the average temperature of a city/cities for each of the next 5 days  
:clipboard: Add Spring Security for CORS handling and any future security need  




