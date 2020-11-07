## :gear: Running Instructions

1. Please ensure that you have installed Java and [JDK](https://www.oracle.com/uk/java/technologies/javase-downloads.html) on your system and the environment variables are set.
2. Clone the repository: `git clone https://github.com/faizan-mohiuddin/SpringAPI.git`
3. `cd` into the cloned repository's demo folder
4. Run the command `mvnw spring-boot:run` if you are using Windows or `./mvnw spring-boot:run` on MacOS/Linux.

## :memo: Viewing the Results
1. Once you have successfully have the Spring Boot server running, open your web browser and go to `localhost:8080/greeting` which returns results in JSON format.
2. You can add `?name=` to the end of the URL. For example `localhost:8080/greeting?name=John` returns `{"id":2,"content":"Hello John!"}`
