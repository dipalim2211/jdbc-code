package imdb.service;

import imdb.model.Genre;
import imdb.model.Movie;

import java.util.List;

//Service - Provide Data
//Who wants to work on Movie System need to perform this implementation
//Person working with memory or JDBC , Hibernate should follow this contract
//Implement how you want

public interface IMovieService {

   Movie addMovie(String name, Genre genre, int year);
   Movie getMovieById(long id);
   List<Movie> getAllMovies();
   boolean updateMovie(long id, String name, Genre Genre, int year);
   boolean deleteMovie(long id);
   List<Movie> searchMovieByGenre(Genre genre);
   List<Movie> searchMovieByYear(int Year);



}
