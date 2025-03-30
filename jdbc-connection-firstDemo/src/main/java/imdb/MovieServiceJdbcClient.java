package imdb;

import imdb.model.Movie;
import imdb.service.IMovieService;
import imdb.service.MovieServiceFactory;

import java.util.List;

//Service Layer - write business logic by using inputs and generate output in object format

public class MovieServiceJdbcClient
{

    public static void main(String[] args) {

        //Decide which storage you want

        IMovieService movieService = MovieServiceFactory.getMovieService("JDBC");
//        movieService.addMovie("A", Genre.COMEDY, 2010);
//        movieService.addMovie("hey baby", Genre.COMEDY, 2005);
//        movieService.addMovie("Inception", Genre.SCI_FI, 2008);
//        movieService.addMovie("Interstellar", Genre.SCI_FI, 2014);
//        movieService.addMovie("Parasite", Genre.THRILLER, 2019);
//        movieService.addMovie("Chava", Genre.HISTORICAL, 2025);
//        movieService.addMovie("Gone Girl", Genre.DRAMA, 2014);
//        movieService.addMovie("Superb", Genre.COMEDY, 2005);

        //Read all movie

        List<Movie> movies =movieService.getAllMovies();
        System.out.println(movies);

        //Read Movie by ID

        Movie movie=movieService.getMovieById(6);
        System.out.println(movie);

//
//        //Delete
//
//        boolean isDeleted=movieService.deleteMovie(200);
//
//        if(isDeleted){
//            System.out.println("Movie Deleted Successfully");
//        } else {
//            System.out.println("Movie Not Found");
//        }
//
//        movies=movieService.getAllMovies();
//        System.out.println(movies);
//
//        //Update
//
//        //change year 2005 to 2010
//        boolean isUpdated=movieService.updateMovie(1,"hey baby",Genre.COMEDY,2010);
//
//        if(isUpdated){
//            System.out.println("Movie Deleted Successfully");
//        }else {
//            System.out.println("Movie Not Found");
//        }
//        movies =movieService.getAllMovies();
//        System.out.println(movies);
//
//        //search
//
//        System.out.println("Searching Movie");
//
//        movies=movieService.searchMovieByGenre(Genre.SCI_FI);
//        System.out.println(movies);
//
//        movies=movieService.searchMovieByYear(2014);
//        System.out.println(movies);
    }

}
