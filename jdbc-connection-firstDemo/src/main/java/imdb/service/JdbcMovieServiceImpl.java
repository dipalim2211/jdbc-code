package imdb.service;

import imdb.model.Genre;
import imdb.model.Movie;

import java.util.List;

//Class : maintain data in database

public class JdbcMovieServiceImpl implements IMovieService{
    @Override
    public Movie addMovie(String name, Genre genre, int year) {
        return null;
    }

    @Override
    public Movie getMovieById(long id) {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return List.of();
    }

    @Override
    public boolean updateMovie(long id, String name, Genre genre, int year) {
        return false;
    }

    @Override
    public boolean deleteMovie(long id) {

        return false;
    }

    @Override
    public List<Movie> searchMovieByGenre(Genre genre) {
        return List.of();
    }

    @Override
    public List<Movie> searchMovieByYear(int Year) {
        return List.of();
    }
}
