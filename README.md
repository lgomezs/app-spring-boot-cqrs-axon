## Event Sourcing using Axon and Spring Boot
    
CQRS stands for Command Query Responsibility Segregation. At its heart is the notion that you can use a different model to update 
information than the model you use to read information.
Axon is not just a framework, but an infrastructure that also involves an Axon server. 
The Axon server manages a bus event and all the mecanisms to manage the commands and queries:

## Compile
    
    mvn clean install
   
## Running

Start the application
   
    docker-compose up -d 

The application will run at:

    http://localhost:8080/swagger-ui.html#/

Stop the application

    docker-compose stop

Stop the application and remove all data 

    docker-compose down
    
## Axon URI

    http://localhost:8024/

## H2 console

    http://localhost:8080/h2-console/
    
    
   start axon:
   
   ![Screenshot from running application](img/axon-server.png?raw=true "axons server start")
    
   POST save beneficiary:
   
   ![Screenshot from running application](img/post-beneficiary.png?raw=true "post save")
    
   view events:
   
   ![Screenshot from running application](img/save-events.png?raw=true "events")
   
   view data in h2:
    
   ![Screenshot from running application](img/save-h2.png?raw=true "save h2")
    