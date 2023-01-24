package platform.codingnomads.co.springweb.resttemplate.PATCH;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.Task;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.User;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.UserResponseObject;

import java.util.Objects;

@SpringBootApplication
public class PatchMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(PatchMain.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            //create an empty Task
            Task task = new Task();

            //be sure to use a valid task id
            task.setId(171);

            //set fields you want to change. All other fields are null and will not be updated
            task.setName("use patchForObject()");
            task.setDescription("this task was updated using patchForObject()");

            //send the PATCH request using the URL, the Task created above and the ResponseObject Class
            ResponseObject objectResponse = restTemplate
                    .patchForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/" + task.getId(), task, ResponseObject.class);

            System.out.println(Objects.requireNonNull(objectResponse));

            task.setName("PATCH using exchange()");
            task.setDescription("This task was updated using PATCH");

            HttpEntity<Task> httpEntity = new HttpEntity<>(task);
            ResponseEntity<ResponseObject> response = restTemplate
                    .exchange("http://demo.codingnomads.co:8080/tasks_api/tasks/" + task.getId(), HttpMethod.PATCH, httpEntity, ResponseObject.class);

            System.out.println(Objects.requireNonNull(response));
            System.out.println("************************************************************************************************");

            User userToBePatched = new User();

            userToBePatched.setId(381);

            userToBePatched.setEmail("MrClean@yahoo.com");

            UserResponseObject userObjectResponse = restTemplate
                    .patchForObject("http://demo.codingnomads.co:8080/tasks_api/users/" + userToBePatched.getId(), userToBePatched, UserResponseObject.class);

            System.out.println(Objects.requireNonNull(userObjectResponse));

            userToBePatched.setEmail(null);
            userToBePatched.setLast_name("Clean");

            HttpEntity<User> userHttpEntity = new HttpEntity<>(userToBePatched);
            ResponseEntity<UserResponseObject> userResponse = restTemplate
                    .exchange("http://demo.codingnomads.co:8080/tasks_api/users/" + userToBePatched.getId(), HttpMethod.PATCH, userHttpEntity, UserResponseObject.class);

            System.out.println(Objects.requireNonNull(userResponse));
        };
    }
}
