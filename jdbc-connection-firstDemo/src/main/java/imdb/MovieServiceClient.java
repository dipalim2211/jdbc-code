package imdb;

import imdb.model.Movie;
import imdb.service.IMovieService;
import imdb.service.InMemoryMovieServiceImpl;
import imdb.model.Genre;
import imdb.service.MovieServiceFactory;

import java.util.List;

//Service Layer - write business logic by using inputs and generate output in object format

public class MovieServiceClient
{

    public static void main(String[] args) {

        //Decide which storage you want

           IMovieService movieService = MovieServiceFactory.getMovieService("IN_MEMORY");
           movieService.addMovie("A",Genre.COMEDY,2010);

        //Read Movie by ID

        Movie movie=movieService.getMovieById(6);
        System.out.println(movie);

        //Read all movie

        List<Movie> movies =movieService.getAllMovies();
        System.out.println(movies);

        //Delete

        boolean isDeleted=movieService.deleteMovie(200);

        if(isDeleted){
            System.out.println("Movie Deleted Successfully");
        } else {
            System.out.println("Movie Not Found");
        }

        movies=movieService.getAllMovies();
        System.out.println(movies);

        //Update

        //change year 2005 to 2010
        boolean isUpdated=movieService.updateMovie(1,"hey baby",Genre.COMEDY,2010);

        if(isUpdated){
            System.out.println("Movie Deleted Successfully");
        }else {
            System.out.println("Movie Not Found");
        }
        movies =movieService.getAllMovies();
        System.out.println(movies);

        //search

        System.out.println("Searching Movie");

        movies=movieService.searchMovieByGenre(Genre.SCI_FI);
        System.out.println(movies);

        movies=movieService.searchMovieByYear(2014);
        System.out.println(movies);
    }

}
