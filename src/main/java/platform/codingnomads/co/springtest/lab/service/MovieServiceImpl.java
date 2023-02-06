package platform.codingnomads.co.springtest.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.repository.MovieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {

        List<Movie> movies =  movieRepository.findAll();

        if(movies.isEmpty()) {
            try {
                throw new Exception("There are no movies!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return movies;

    }

    @Transactional
    public void deleteAllMovies() throws Exception {
        try {
            movieRepository.deleteAll();
        } catch (Exception e) {
            throw new Exception(e.getMessage() + " Could not delete all.");
        }
    }

    public List<Movie> getMoviesWithMinimumRating(Double rating) {
        List<Movie> movies = movieRepository.findByRatingGreaterThanEqual(rating);

        if (movies.isEmpty()) {
            try {
                throw new Exception("No movies could be found with that minimum rating.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return movies;
    }
}
