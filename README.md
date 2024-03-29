# SPRING-BOOT-TESTING



### RESSOURCES

-  https://www.youtube.com/@ProgrammingKnowledge 

- 

## What is Unit Testing?

Unit Testing is a type of software testing in which a small piece of code is tested to see if the code works as expected. The name is derived from the fact that tests are done on a unit by unit basis. The goal of Unit testing is to help reduce the cost of bug fixes, as this way, bugs or errors in the code level are identified early in the development lifecycle. The cost of fixing bugs rises exponentially as it progresses into the later stages of the Software Development Lifecycle, which makes unit testing a critical element and money saving for the company.

Traditionally, unit testing was not considered part of the QA team responsibility, as it is mostly performed at the development phase of an application or a product and is typically performed by the software developer.

However, with the transition into Agile and DevOps methodologies and dimentals of traditional teams, where now QA professionals’ role is responsibility on the overall product quality, this is gradually changing. Using PractiTest’s FireCracker tool you can now integrate your Unit testing results automatically into PractiTest so you can integrate them as part of your overall testing coverage and reporting

## What is Integration Testing?

Integration testing, as its name implies, verifies that the interface between two software units or modules works correctly. It is a broader type of testing that covers connection between 2 or more moduled and can also in some cases, cover the whole application.

In the end-to-end process of software testing, Integration Testing will be performed after the Unit Testing and before System Testing.

It is a very common activity in large organizations, that are not Independent software vendors (ISVs) which means that their main business doesn’t involve software development, to perform integration testing, to ensure different off-the-shelf softwares can work seamlessly together, without harming each other’s functionality.

- Integration testing involves testing the integration of different parts of the system together. Two different parts or modules of the system are first integrated and then integration testing is performed.

### UNIT TEST VS INTEGRATION TEST

| **Unit Testing**                                                         | **Integration Testing**                                                            |
| ------------------------------------------------------------------------ | ---------------------------------------------------------------------------------- |
| It tests small modules or a piece of code of an application or a product | Two or more units of a program are combined and tested as a group                  |
| It's a quick write-and-run test                                          | It is slower to run                                                                |
| Typically performed by a software developer                              | It is traditionally carried out by a separate team of testers                      |
| It can be performed at any time                                          | It is usually carried out after Unit Testing but before the overall system testing |
| It has very low maintenance                                              | It has very high maintenance                                                       |
| It has very limited in scope, as it only covers a piece of code          | It has wider scope as it covers broader part of the application or the product     |
| It focus on one single module                                            | It pays attention to integration among two or more modules                         |
| Finding errors is relatively easy                                        | Finding errors is more difficult                                                   |
| Test executor knows the internal design of the software                  | Testers don't know the internal design of the software                             |
| It is white box testing                                                  | It is a black box testing                                                          |

| Tests the single component of the whole system i.e. tests a unit in isolation. | Tests the system components working together i.e. test the collaboration of multiple units. |
| ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------- |
| Faster to execute                                                              | Can run slow                                                                                |
| No external dependency. Any external dependency is mocked or stubbed out.      | Requires interaction with external dependencies (e.g. Database, hardware, etc.)             |
| Simple                                                                         | Complex                                                                                     |
| Conducted by developer                                                         | Conducted by tester                                                                         |
