package Repositories;

import Domains.Movie;

import java.util.List;

public interface IMovieRepo {
    List<Movie> getAllMovies();
    Movie getMovieById(Long id);

    void addMovie(Movie movie);
}
