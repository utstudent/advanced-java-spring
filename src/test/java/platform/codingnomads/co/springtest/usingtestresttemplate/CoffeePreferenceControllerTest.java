package platform.codingnomads.co.springtest.usingtestresttemplate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import platform.codingnomads.co.springtest.usingtestresttemplate.models.CoffeePreference;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = UsingTestRestTemplateMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoffeePreferenceControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testPostCoffeePreference() throws Exception {

        //build new CoffeePreference to post
        CoffeePreference preferenceToPost = CoffeePreference.builder()
                .type("Black")
                .size(CoffeePreference.Size.LARGE)
                .sugar(false)
                .iced(true)
                .intensity(9)
                .build();

        //send POST request using TestRestTemplate
        ResponseEntity<CoffeePreference> postedCoffeePreference =
                testRestTemplate.postForEntity("/coffee", preferenceToPost, CoffeePreference.class);

        //confirm Location header is correct
        String locationHeader = Objects.requireNonNull(postedCoffeePreference.getHeaders().getLocation()).toString();
        assertThat(locationHeader).isEqualTo("http://www.url.com/new/location");

        //confirm ID was assigned
        assertThat(Objects.requireNonNull(postedCoffeePreference.getBody()).getId()).isNotNull();
    }

    @Test
    public void testGetCoffeePreferenceByIdSuccessBehavior() throws Exception {
        final long coffeId = 1;

        ResponseEntity<CoffeePreference> getCoffeePreferance =
                testRestTemplate.getForEntity("/coffee/" + coffeId, CoffeePreference.class);

        //confirm Location header is correct
//        String locationHeader = Objects.requireNonNull(getCoffeePreferance.getHeaders().getLocation()).toString();
//        assertThat(locationHeader).isEqualTo("http://localhost:8080/coffee/1");

        String contentTypeHeader = Objects.requireNonNull(getCoffeePreferance.getHeaders().getContentType()).toString();
        assertThat(contentTypeHeader).isEqualTo("application/json");

        //confirm ID was assigned
        assertThat(Objects.requireNonNull(getCoffeePreferance.getBody()).getId()).isNotNull();
        assertThat(Objects.requireNonNull(getCoffeePreferance.getBody().getType().equalsIgnoreCase("Americano")));
        assertThat(Objects.requireNonNull(getCoffeePreferance.getBody().getIntensity()).equals(7));
        assertThat(Objects.requireNonNull(getCoffeePreferance.getBody().getSize().equals("LARGE")));
        assertThat(Objects.requireNonNull(getCoffeePreferance.getBody().isIced()).booleanValue());
        assertThat(Objects.requireNonNull(getCoffeePreferance.getBody().isSugar()).equals(false));
    }
}
