package platform.codingnomads.co.springtest.lab;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import platform.codingnomads.co.springtest.TestUtil;
import platform.codingnomads.co.springtest.lab.SpringTestLab;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;
import platform.codingnomads.co.springtest.lab.service.MovieServiceImpl;
import platform.codingnomads.co.springtest.mockingmethods.models.Ingredient;
import platform.codingnomads.co.springtest.mockingmethods.models.Recipe;
import platform.codingnomads.co.springtest.mockingmethods.models.Step;
import platform.codingnomads.co.springtest.testingjsonresponsecontent.models.Review;
import platform.codingnomads.co.springtest.usingtestresttemplate.models.CoffeePreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = SpringTestLab.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    MovieServiceImpl movieService;

    @Test
    @Order(1)
    public void testGetAllMoviesSuccess() throws Exception {

        //set up get request for all recipe endpoint.
        this.mockMvc.perform(get("/all"))
                .andDo(print())
                //expect status is 200 OK
                .andExpect(status().isOk())
                //expect it will be returned as JSON
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                //expect there are 4 entries
                .andExpect(jsonPath("$", hasSize(2)))
                //expect the first entry to have ID 1
                .andExpect(jsonPath("$[0].id").value(24))
                //expect the first entry to have name test recipe
                .andExpect(jsonPath("$[0].name").value("The Shawshank Redemption"))
                //expect no ingredients for first entry
                .andExpect(jsonPath("$[0].rating").value(9.3))
                //expect the second entry to have id 2
                .andExpect(jsonPath("$[1].id").value(25))
                .andExpect(jsonPath("$[1].rating").value(8.0))
                //expect the second entry to have a minutesToMake value of 2
                .andExpect(jsonPath("$[1].name").value("The Pursuit of Happyness"));
    }
    @Test
    @Order(2)
    public void testGetAllMoviesSuccessMockService() throws Exception {

        when(movieService.getAllMovies()).thenReturn(
                new ArrayList<>(Arrays.asList(
                        Movie.builder()
                                .id(1L)
                                .name("Lord of the Rings")
                                .rating(9.1)
                                .build(),
                        Movie.builder()
                                .id(2L)
                                .name("Matrix")
                                .rating(9.3)
                                .build())
                )
        );

        //set up get request for all recipe endpoint
        mockMvc.perform(get("/all"))
                .andDo(print())
                //expect status is 200 OK
                .andExpect(status().isOk())
                //expect it will be returned as JSON
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                //expect there are 4 entries
                .andExpect(jsonPath("$", hasSize(2)))
                //expect the first entry to have ID 1
                .andExpect(jsonPath("$[0].id").value(1))
                //expect the first entry to have name test recipe
                .andExpect(jsonPath("$[0].name").value("Lord of the Rings"))
                //expect no ingredients for first entry
                .andExpect(jsonPath("$[0].rating").value(9.1))
                //expect the second entry to have id 2
                .andExpect(jsonPath("$[1].id").value(2))
                //expect the second entry to have a minutesToMake value of 2
                .andExpect(jsonPath("$[1].name").value("Matrix"));
    }

    @Test
    @Order(3)
    public void testGetAllMoviesSuccessBehavior() throws Exception {

        Movie movie = new Movie();

        MockHttpServletResponse response =
                this.mockMvc.perform(get("/all")
                                //set request Content-Type header
                                .contentType("application/json")
                                //set HTTP body equal to JSON based on recipe object
                                .content(TestUtil.convertObjectToJsonBytes(movie))
                        )

                        //confirm HTTP response meta
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        //confirm Location header with new location of object matches the correct URL structure

                        //confirm some recipe data
                        .andExpect(jsonPath("$[0].id").value(24))
                        .andExpect(jsonPath("$[0].name").value("The Shawshank Redemption"))

                        .andExpect(jsonPath("$[1].id").value(25))
                        .andExpect(jsonPath("$[1].name").value("The Pursuit of Happyness"))

                        .andReturn().getResponse();
    }


    @Test
    public void testgetMoviesByMinimumRatingNormalBehavior() throws Exception {
        //when RecipeService's getRecipeById() method is called with any Long passed in
        when(movieService.getMoviesWithMinimumRating(anyDouble()))
                //it will return the above defined recipe
                .thenReturn(
                        new ArrayList<>(Arrays.asList(
                                Movie.builder()
                                        .id(1L)
                                        .name("searched movie 1")
                                        .rating(5.7)
                                        .build(),

                                Movie.builder()
                                        .id(2L)
                                        .name("searched movie 2")
                                        .rating(6.9)
                                        .build()
                        ))
                );

        //test that the controller works properly when the above recipe is guaranteed to be returned from its
        mockMvc.perform(get("/movies/5.9"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value(containsString("searched movie 1")))
                .andExpect(jsonPath("$[0].rating").value(5.7));
    }

    @Test
    public void testgetMoviesByMinimumRatingFailureBehavior() throws Exception {
        when(movieService.getMoviesWithMinimumRating(anyDouble())).thenThrow(new RuntimeException("No movies could be found with that minimum rating."));

        this.mockMvc.perform(get("/movies/9.5"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString("No movies could be found with that minimum rating.")));
    }

    @Test
    @Order(6)
    public void testGetAllMoviesFailure() throws Exception {

        //delete all entries to force error
        //movieService.deleteAllMovies();
        //perform GET all recipes
        this.mockMvc.perform(get("/all"))
                .andDo(print())
                //expect 404 NOT FOUND
                .andExpect(status().isNotFound())
                //expect error message defined in RecipeService class
                .andExpect(jsonPath("$").value("There are no movies!"));

    }
}
