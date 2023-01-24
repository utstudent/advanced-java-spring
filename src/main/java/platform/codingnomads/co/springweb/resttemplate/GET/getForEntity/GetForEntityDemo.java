package platform.codingnomads.co.springweb.resttemplate.GET.getForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.QuoteTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.ActivityTemplate;

import java.util.Arrays;

@SpringBootApplication
public class GetForEntityDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForEntityDemo.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            ResponseEntity<QuoteTemplate[]> responseEntity =
                    restTemplate.getForEntity("https://zenquotes.io/api/random", QuoteTemplate[].class);

            if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
                QuoteTemplate[] quoteTemplate = responseEntity.getBody();
                System.out.println("random quote: "+Arrays.toString(quoteTemplate));
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }

            ResponseEntity<ActivityTemplate> activityResponseEntity =
                    restTemplate.getForEntity("http://www.boredapi.com/api/activity/", ActivityTemplate.class);

            if (activityResponseEntity.getStatusCode().equals(HttpStatus.OK) && activityResponseEntity.getBody() != null) {
                ActivityTemplate activityTemplate = activityResponseEntity.getBody();
                System.out.println("random activity: " + activityTemplate);
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }

            ResponseEntity<ActivityTemplate> twoParticipantsActivityResponseEntity =
                    restTemplate.getForEntity("http://www.boredapi.com/api/activity?participants=2", ActivityTemplate.class);

            if (twoParticipantsActivityResponseEntity.getStatusCode().equals(HttpStatus.OK) && twoParticipantsActivityResponseEntity.getBody() != null) {
                ActivityTemplate activityTemplate = twoParticipantsActivityResponseEntity.getBody();
                System.out.println("Two participants random activity: " + activityTemplate);
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }
        };
    }
}
