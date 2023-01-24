package platform.codingnomads.co.springweb.resttemplate.POST.postForLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.ActivityTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Task;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;
import platform.codingnomads.co.springweb.resttemplate.POST.models.UserResponseObject;

import java.net.URI;
import java.util.Objects;

@SpringBootApplication
public class PostForLocationMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PostForLocationMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            Task newTask = Task.builder()
                    .name("learn how to use postForLocation()")
                    .description("get comfortable using the RestTemplate postForLocation() method")
                    //be sure to use a valid user id
                    .userId(380)
                    .completed(false)
                    .build();

            //use postForLocation() to get the URL for the new resource
            URI returnedLocation = restTemplate
                    .postForLocation("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);

            System.out.println(Objects.requireNonNull(returnedLocation));

            ResponseEntity<?> responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);

            System.out.println(responseEntity.getHeaders().get("Location"));


            System.out.println("-------------------------------------------------------------------");
            User newUser = User.builder()
                    .email("helloMrNice3@gmail.com")
                    .first_name("Nice")
                    .last_name("man")
                    .build();

            URI UserReturnedLocation = restTemplate
                    .postForLocation("http://demo.codingnomads.co:8080/tasks_api/users", newUser, UserResponseObject.class);

            System.out.println(Objects.requireNonNull(UserReturnedLocation));

            ResponseEntity<UserResponseObject> UserResponseEntity =
                    restTemplate.getForEntity("http://demo.codingnomads.co:8080/tasks_api"+UserReturnedLocation , UserResponseObject.class);

            if (UserResponseEntity.getStatusCode().equals(HttpStatus.OK) && UserResponseEntity.getBody() != null) {
                UserResponseObject userResponseObject = UserResponseEntity.getBody();
                System.out.println("User response entity: " + userResponseObject);
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }
        };
    }
}
