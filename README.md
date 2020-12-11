# Web Application Proof of Concept

The proof of concept for the web application is a [Spring Boot](https://spring.io/) project written in Java.

## Goals

Team Delta set out to achieve the following goals in the Spring Boot project to prove that the Web Application was feasible:

1. Calling data from a database from the web application.
2. Displaying the retrieved data in JSON format.
3. Adding data to the database.

## Running Instructions

1. Please ensure that you have installed Java and [JDK](https://www.oracle.com/uk/java/technologies/javase-downloads.html) on your system and the environment variables are set.
2. Open your terminal and cd into the &#39;SpringAPI&#39; folder and then cd in to the &#39;demo&#39; folder.
3. Run the command mvnw spring-boot:run if you are using Windows or ./mvnw spring-boot:run on MacOS/Linux then wait for the web application to run.
4. Open your web browser and head to localhost:8080

## Goal 1 &amp; Goal 2: Calling Data from the Database and Displaying as JSON

As stated in the Technical Report, the database is externally hosted by [FreeMySQLHosting](https://www.freemysqlhosting.net/). The database only has one table called &#39;random&#39; and this table has three columns called: ColA (string), ColB (int) and ID (primary key).

![](RackMultipart20201211-4-f0im8x_html_6f14b33db6f59de2.png)
_Database table &#39;random&#39; shown in PhpMyAdmin_

To call data from the database the application needs to connect to it first. This is achieved using JDBC.

![](RackMultipart20201211-4-f0im8x_html_9a47154675f7268b.png)

You can call all the data in the database by clicking the &#39;View Table&#39; button or by typing in localhost:8080/greeting/all into the address bar which should return the below results.

![](RackMultipart20201211-4-f0im8x_html_a247d8a118c3f28d.png)

Below is how this data is retrieved and displayed:

![](RackMultipart20201211-4-f0im8x_html_d7a7ebedfffafd94.png)

The method getAll() in the &#39;Random&#39; model executes a query on the &#39;random&#39; table in the database that selects all of content in the table and stores the result of the executed query as a ResultSet. The ResultSet is iterated through to store each of its items as a custom class, RandomDB and these items are put into a list that gets returned to the main program.

![](RackMultipart20201211-4-f0im8x_html_95ef4c1b1083aa41.png)

The URL /greeting/all maps to the greetingAll method in the GreetingController class that calls and returns the getAll() method in the &#39;Random&#39; model. The GreetingController class is declared as Spring Boot&#39;s @RestController which effectively means that it generates whatever gets returned to it as JSON.

![](RackMultipart20201211-4-f0im8x_html_273fc93dd80757ef.png)

T ![](RackMultipart20201211-4-f0im8x_html_c8e354731963fc7.png)
 he getRow(int ID) is a method in the &#39;Random&#39; model that works similarly to get the getAll() method but just retrieves a single row by ID instead of all rows.

## Goal 3: Adding Data to the Database

Data can be added to the database through the web application using a Python script. The script, requestTester.py, sends a POST request to the locally hosted web application which is then handled by the greetingInsert method in the GreetingController class as shown below:

![](RackMultipart20201211-4-f0im8x_html_9af70ed33e56d831.png)

This method calls the insert(ColA, ColB) method from the &#39;Random&#39; model:

![](RackMultipart20201211-4-f0im8x_html_ee8e8d294f9047dd.png)
