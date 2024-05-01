# Api Test Automation with Rest Assured-Cucumber

## Tools

* **Java17** - Lang
* **Intellij IDE** - IDE
* **Rest Assured** - API
* **Cucumber7** - Gherkin Lang Framework
* **Junit5** - Assertion & Validation Framework
* **Allure** - Raporting
* **Logback** - Logging
* **Json-server** - Database 

## Json Server Setup

* Installing JSON Server: https://www.digitalocean.com/community/tutorials/json-server


* Go to project path on terminal and run command

  ```
  json-server --port 7000 --routes routes.json --watch db.json
  ```

## Test Run

1. It can be run based on scenario or feature by pressing the green RUN button on the IDE


2. Run with mvn command

> **Note:** allure must be setup

* Run with tags

  ```
  mvn clean test -Dtest="CucumberRunnerTest" -DexcludedGroups="Ignore" -Dtags="verify_user_deleted" 
  ```
  
* Run with groups

  ```
  mvn clean test -DexcludedGroups="Ignore" -Dgroups="smoke"
  ```
  
* System env

  ```
  mvn clean test -Denv="local"
  ```

## Allure


* Run command 

`allure serve target/allure-results `

## Project Structure

```                   
├── src
│   ├── test                      
│   │   ├── java
│   │   │  ├── api  
│   │   │  │  ├──callers
│   │   │  │      └── user              
│   │   │  │  ├── models
│   │   │  │      └── user      
│   │   │  │  ├── requests
│   │   │  ├── configs
│   │   │  ├── globals                 
│   │   │  ├── steps  
│   │   │  │   └── user
│   │   │  ├── utils              
│   │   │  └── CucumberRunnerTest      
│   │   ├── resources
│   │   │  ├── features  
│   │   │  │  └── user
│   │   │  │      └── create_user.feature 
│   │   │  ├── allure.properties  
│   │   │  ├── logback.xml  
├── db.json
├── routes.json
├── pom.xml
└── README.md
```

## Naming Convention

```
package name = my_package

file name = MyFile

feature file name = my_feature_file.feature

class name = MyClass

method name = myMethodName

variable name = myVariable

enum = ALL_CAPITAL

tag name = @my_tag 

api caller class = MyClassApiCaller 

api request class = MyClassApiRequest 

api request model json = myModel.json
```

## Tagging

* When tagging scenarios snake_case should be used

```  
@smoke = A scenario/feature which is expected to run in the smoke scope
@prod  = Scenarios to be run on prod environment
@regression  = Cases to be run during regression
@feature_tag = Tag name to be given to each feature file. Example: @feature_login
@scenario_tag = The unique tag to be given to each scenario. Example: @success_login   
```