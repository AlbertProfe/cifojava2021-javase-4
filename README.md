# cifojava2021-javase-4 
JPA and Rest Controller (Swagger) with Spring Boot. JPA @OnToMany, @ManyToOne @ManyToMany (just JPA). 

Welcome to the cifojava2021-javase-4 and javaeewiki!

# cifojava2021-javase-4 and javaee
JPA @OneToMany, @ManyToOne, @ManyToMany and @JoinColumn, @JoinTable
- Spring Boot JPA **without** @Controller, View and Thymeleaf
- So we use **CommandLineRunner** to test JPA _entities_.
- Applications.properties
- Classes: JPA @Entity Employee and CrudRepository Interface
- Database: H2 (local or in Memory) and ddl.auto

JPA **and REST API** @OneToMany, @ManyToOne, @ManyToMany and @JoinColumn, @JoinTable and @RestController
- Rest Controller (Postman and Swagger)


## amazonDeliver (java-EE spring)

- amazonDeliver : `n:m` with `1:n` `n:1`
   - @Entity as TA (_OrderService_)
   - with _CommandLineRunner_ 
   - **Employee <> OrderService <> Shop**
- amazonDeliver2 : `n:m` with `1:n` `n:1`
   -  add another @Entity to OrderService (_Vehicle_)
   - with _CommandLineRunner_ 
   - Employee <> OrderService <> Shop 
   - **OrderService <> Vehicle**
- amazonDeliver3 : `n:m`
   - without @Entity as TA (_Product_)
   - with _CommandLineRunner_ 
   - Employee <> OrderService <> **Shop <> Product**
   - OrderService <> Vehicle
- amazonDeliver4 : `n:m` 
   - web Project (we don't need **CommandLineRunner** because it is a web project now wiht @RestController **but** we leave it to fill the db)
   - Employee <> OrderService <> Shop <> Product
   - OrderService <> Vehicle
   - @RestController
      - @EmployeeRestController with all CRUD operations
      - Postman
      - @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") at _entities_
- amazonDeliver5 : `n:m` 
   - web Project (we don't need **CommandLineRunner** because it is a web project now wiht @RestController **but** we leave it to fill the db)
   - Employee <> OrderService <> Shop <> Product
   - OrderService <> Vehicle
   - @RestController
      - @EmployeeRestController with all CRUD operations
      - **Swagger**
           - class: SpringFoxConfig
           - Dependency
           - Main @Bean
           - Open URL: http://localhost:8086/swagger-ui.htm
      - @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") at _entities_ 



<a href="https://github.com/AlbertProfe/images/blob/main/cifospring2021/amazon.png"><img src="https://github.com/AlbertProfe/images/blob/main/cifospring2021/amazon.png" width="600"></a>

## employeeExpenses (java-EE spring)

- employeeExpenses: `1:m` unidirectional 
   - Employee <> Expense
- employeeExpenses2: `n:m` bidirectional
   - Employee <> Expense
   - Employee <> Holidays
- employeeExpenses3: `n:m` TA without @Entity
   - Employee <> Expense
   - Employee <> Holidays
   - Employee <> Course
- employeeExpenses4: `n:m` TA as @Entity and `1:n` `n:1`
   - Employee <> Expense
   - Employee <> Holidays
   - Employee <> EnrollmentCourse
- employeeExpenses5: `n:m` TA as two @Entity and `1:n` `n:1`
   - Employee <> Expense
   - Employee <> Holidays
   - Employee <> Enrollment <> Course


<a href="https://github.com/AlbertProfe/images/blob/main/cifospring2021/employeeExpenses5.png"><img src="https://github.com/AlbertProfe/images/blob/main/cifospring2021/employeeExpenses5.png" width="600"></a>
