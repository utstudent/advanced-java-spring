package platform.codingnomads.co.springtest.lab.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.service.MovieService;
import platform.codingnomads.co.springtest.lab.service.MovieServiceImpl;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class MovieController {

    private MovieServiceImpl movieService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllMovies() {
        try {
            return ResponseEntity.ok(movieService.getAllMovies());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<?> deleteAllMovies() {
        try {
            movieService.deleteAllMovies();
            return ResponseEntity.ok("All movies were deleted.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/movies/{rating}")
    public ResponseEntity<?> getMoviesByMinimumRating(@PathVariable("rating") Double rating) {
        try {
            List<Movie> matchingMovies = movieService.getMoviesWithMinimumRating(rating);
            return ResponseEntity.ok(matchingMovies);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
