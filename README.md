<a name="readme-top"></a>


<!-- ABOUT THE PROJECT -->
## About The Project

This application was created as a learning project for creating fullstack applications and API's with Spring framework.

Main features:
* Easy connectivity with [John Hopkins University Covid-19 API](https://github.com/CSSEGISandData/COVID-19) with included filters
* Downloading accesed Covid-19 statistics to local database in simplified form
* API for accesing data from database
* Website listing all main stats

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* [![Maven][Maven.io]][Maven-url]
* [![Springbbot][Springboot.io]][Springboot-url]
* [![MySQL][Mysql.io]][Mysql-url]
* [![Thymeleaf][Thymeleaf.io]][Thymeleaf-url]
* [![Bootstrap][Bootstrap.com]][Bootstrap-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- USAGE EXAMPLES -->
## Usage
To use this software you are required to have local MySQL database setup using software of your choice. _Database acces variables can be modified within `application.properites` file located in `src` folder_

1. After database has been set up and running, you can start using this application with included Maven Wrapper. Inside project folder run:
  ```sh
  ./mvnw spring-boot:run
  ```
  _Make sure your java installation is listed within your systems enviorment variable table_

2. After first launch, your local database is empty, so its required to request database updating command within API. To do this, send request to:
   ```sh
   http://localhost:8081/direct/update
   ```
   After database has been updated, you can start using main site which list all numeric values and database acces API.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- Requests and commands -->
## Commands and requests
Application consists of three controllers:
* Main controller - used for front-end site
* Database REST controller - for local database acces
* [John Hopkins University Covid-19 API](https://github.com/CSSEGISandData/COVID-19) REST controller - for accesing this API and getting specified data and updating local database with most recent data
  
List of requests you can send to application APIs:
1. Main controller - 
   As of now, main controller can only deliver one site which contains all data. You can acces it trough:
   ```sh
    http://localhost:8081
    ```
2. Database REST controller - 
   It is accesed by adding `/db` to main URL
   * Getting all data from database (Number of cases and deaths for each country)
     ```sh
     http://localhost:8081/db/getAll
     ```
   * Getting data from specific country
     ```sh
     http://localhost:8081/db/{Country}
     ```
3. Direct acces controller - 
   It is reached by adding `/direct` to main URL
   * Getting all data from John Hopkins API
     ```sh
     http://localhost:8081/direct/getAll
     ```
   * Getting data regarding all listed countries
     ```sh
     http://localhost:8081/direct/getCountries
     ```
   * Getting cached information, regarding time of the last update
     ```sh
     http://localhost:8081/direct/getMetaData
     ```
   * Getting information on single country
     ```sh
     http://localhost:8081/direct/getCountry/{Country}
     ```
   * Updating local database
     ```sh
     http://localhost:8081/direct/update
     ```
Note that `http://localhost:8081/db/getAll` and `http://localhost:8081/direct/getAll` won't give the same results. John Hopkins University API creates JSON response containing all available data as one JSON variable whilst database controller only sends information regarding specific countries.
In the same manner `http://localhost:8081/db/getAll` won't show same results as `http://localhost:8081/direct/getCountries` because the latter has information separated for each state and county. Local database stores data without that separation (It sums all data for specific country as one). 


<!-- ACKNOWLEDGMENTS -->
## Acknowledgments
Resources and minor libraries used within this project

* [John Hopkins University Covid-19 API](https://github.com/CSSEGISandData/COVID-19)
* [Lombok](https://projectlombok.org/)
* [Gson](https://github.com/google/gson)
* [JPA](https://spring.io/projects/spring-data-jpa)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- Prospect of developement -->
## Prospect of developement
Application could be extended with another features, for example:
* More filters to acces more specific data
* Accesing data sorted in specific way based on request
* Using updating command as scheduled task to keep local database with most recent data (_John Hopkins University ceased collecting data as on march 10, 2023_)
* Front-end side redesign with popular Javascript framework like React or Angular to create better user experience

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Piotr Snarski - snarski.piotrek@gmail.com

Project Link: [https://github.com/H33Kz/CovidStatsSummary](https://github.com/H33Kz/CovidStatsSummary)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->

[Maven.io]:https://img.shields.io/badge/Maven-purple?style=for-the-badge&logo=apache&logoColor=white
[Maven-url]:https://maven.apache.org/index.html

[Thymeleaf.io]: https://img.shields.io/badge/Thymeleaf-grey?style=for-the-badge&logo=thymeleaf&logoColor=white
[Thymeleaf-url]: https://www.thymeleaf.org/documentation.html

[Springboot.io]: https://img.shields.io/badge/Springboot-green?style=for-the-badge&logo=springboot&logoColor=white
[Springboot-url]: https://spring.io/projects/spring-boot

[Mysql.io]: https://img.shields.io/badge/MySQL-orange?style=for-the-badge&logo=mysql&logoColor=white
[Mysql-url]: https://dev.mysql.com/doc/

[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
