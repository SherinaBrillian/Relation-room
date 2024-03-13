# SpringBoot Relationship Query Builder

## What does this add to SpringBoot? How do I setup my project with this?

This addition to the SpringBoot framework provides a powerful tool for building and querying relationships between entities in your project. To set up your project to utilize this feature:

- Ensure you have SpringBoot set up and configured in your project.
- Include the necessary dependencies for the Relationship Query Builder in your pom.xml or build.gradle file.
- Extend your models with the Relationship Query Builder, typically by adding it to your repository implementation.

## Relationship

The Relationship Query Builder facilitates the establishment and management of relationships between entities. In your project, you can define relationships between entities such as tables tbroom and tbchats. For example, you might establish a one-to-many relationship where one room can have multiple conversations or comments .

This relationship can be configured through query and model configurations that match the table structure in this project. You can clone my repository be-hajidanumroh-chat first before attempting to relate the two tables.

First, You would setup your query in your constant directory :

```java
SELECT r.roomUid, r.orderUid, r.statusUid, r.createdAt AS createdAt, r.updatedAt AS updatedAt, c.chatUid, c.sender, c.message, c.createdAt AS createdAt FROM tbroom r LEFT JOIN tbchats c ON r.roomUid = c.roomUid
```

### One To Many

tbRoom and tbChats have a one-to-many relationship. This means that each room in tbRoom can have multiple conversations or comments in tbChats. For example, one discussion room (tbRoom) can have many comments (tbChats) representing the discussions happening within it.

This relationship is implemented through model classes such as RoomResponseModel, which includes representations of conversations (ChatsModel) associated with specific rooms, allowing the application to easily access and display relevant information.

Next, we set up the RoomResponseModel directory and enhance it with the Builder tool.

```java
public class RoomResponseModel {
    private String roomUid;
    private String orderUid;
    private String statusUid;
    private String createdAt;
    private String updatedAt;
    private ChatsModel chatsModel;
}
```

After that, we also add the builder to the ChatsModel.

## Environment Variables

To run this application, you need to set up the following environment variables:

- spring.datasource.url: The URL of your MySQL database.
- spring.datasource.username: The username to access your MySQL database.
- spring.datasource.password: The password to access your MySQL database.
- spring.datasource.driver-class-name: The JDBC driver class name for MySQL, which is com.mysql.cj.jdbc.Driver.
- spring.jpa.hibernate.ddl-auto=update
  Hibernate strategy mode for DDL (Data Definition Language), set to update to automatically update the database schema.
  Ensure that you set these values according to your MySQL database configuration.

## Deployment

To deploy this application, follow these steps:

1. Clone the repository to your local machine.
2. Set up the environment variables in your deployment environment or in your IDE's run configuration.
3. Build the project using Gradle or Maven.
4. Run the application using your preferred method (e.g., ./gradlew bootRun for Gradle or mvn spring-boot:run for Maven).
5. Once the application is running, it will be accessible at the specified port (default is 8080).

## API Reference

Testing for this application can be done using Postman. You can perform various HTTP requests to the API endpoints to test the functionality. Here are the steps to test the application:

1. Open Postman.
2. Set up requests for the API endpoints defined in the application.
3. Send requests to create, read, update, or delete data in the database.
4. Verify that the responses from the API endpoints are as expected.
5. Test different scenarios to ensure the robustness of the application.

Ensure that you have set up your MySQL database properly and that the application is running before testing. You can also automate testing using Postman collections and Newman for continuous integration pipelines.

This project provides a solid foundation for building backend services with Spring Boot and MySQL database connectivity. Customize it according to your requirements and extend its functionality as needed.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/11708290-7c9feff6-3865-40fe-aced-239108032805?action=collection%2Ffork&collection-url=entityId%3D11708290-7c9feff6-3865-40fe-aced-239108032805%26entityType%3Dcollection%26workspaceId%3Db8082477-685c-4add-8d56-64f1c34ecbdc#?env%5Bphp%5D=W3sia2V5IjoicGhwLXNlcnZlciIsInZhbHVlIjoiIGh0dHA6Ly8xMjcuMC4wLjE6ODAwMCIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJkZWZhdWx0In0seyJrZXkiOiJiZWFyZXItdG9rZW4iLCJ2YWx1ZSI6IiIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJzZWNyZXQifSx7ImtleSI6ImJlYXJlci10b2tlbiIsInZhbHVlIjoiIiwiZW5hYmxlZCI6ZmFsc2UsInR5cGUiOiJkZWZhdWx0In1d)
