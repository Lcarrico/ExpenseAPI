# Expense API
 
 This will be the backend to a RESTful API Service that will allow one to handle expense refund requests for a company or corporation.
 
 ## Installation
 
 Please install Java which you can get from [Here](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html).
 
 Next, please run the `gradlew` command inside the project. 
 
 Finally, run the command `gradlew fatJar` to create the runnable Jar file.
 
 ## Usage
 
 To run the server, go to the location of the created Jar file at `/build/libs`.
 
 Finally, run the generated snapshot using the command `java -jar ExpenseAPI-all-1.0-SNAPSHOT.jar`.
 
 ### Commands
 
 `POST /expenses` -> Creates a new expense request.
 
 `GET /expenses` -> Gets all expense requests.
 
 `GET /expenses/:id` -> Gets expense with id of ":id".
 
 `PUT /expenses/:id` -> Updates expense with id of ":id".
 
 `DEL /expenses/:id` -> Deletes expense with id of ":id".
 
 `
 
