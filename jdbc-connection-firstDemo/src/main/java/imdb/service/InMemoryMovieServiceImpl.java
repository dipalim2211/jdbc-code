package imdb.service;

import imdb.model.Genre;
import imdb.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//Class who store data in memory

public class InMemoryMovieServiceImpl implements IMovieService {

    private HashMap<Long, Movie> movieMap;

    private long idCounter;

    public InMemoryMovieServiceImpl() {

        movieMap=new HashMap<>();
        idCounter=1;
        initializeMovie();
    }

    //Pre-data initialise in system
    private void initializeMovie()      // Call through Constructor
    {
        addMovie("hey baby", Genre.COMEDY,2005);
        addMovie("Inception",Genre.SCI_FI,2008);
        addMovie("Interstellar",Genre.SCI_FI,2014);
        addMovie("Parasite",Genre.THRILLER,2019);
        addMovie("Chava",Genre.HISTORICAL,2025);
        addMovie("Gone Girl",Genre.DRAMA,2014);
        addMovie("Superb",Genre.COMEDY,2005);
    }


    @Override
    public Movie addMovie(String name, Genre genre, int year) {

        Movie movie = new Movie(idCounter,name,genre,year);

        movieMap.put(idCounter,movie);
        idCounter++;
        return movie;

    }

    @Override
    public Movie getMovieById(long id) {
        return movieMap.get(id);
    }

    @Override
    public List<Movie> getAllMovies() {
        return new ArrayList<>(movieMap.values());
    }

    @Override
    public boolean updateMovie(long id, String name, Genre genre, int year) {
        Movie movie=movieMap.get(id);
        if(movie==null){
            return false;
        }
        else {
            movie.setName(name);
            movie.setGenre(genre);
            movie.setYear(year);
            return true;
        }
    }

    @Override
    public boolean deleteMovie(long id) {
        Movie movie=movieMap.remove(id);        //check returnType and it passes value

        if(movie!= null)
        {
            return  true;
        }
        return false;
    }

    @Override
    public List<Movie> searchMovieByGenre(Genre genre) {

        List<Movie>matchingMovie = new ArrayList<>();

        for(Movie movies : movieMap.values())
        {
            if(movies.getGenre().equals(genre))
            {
                matchingMovie.add(movies);
            }
        }
        return matchingMovie;

    }

    @Override
    public List<Movie> searchMovieByYear(int Year) {
        List<Movie>matchingMovie = new ArrayList<>();

        for(Movie movies : movieMap.values())
        {
            if(movies.getYear()==(Year))
            {
                matchingMovie.add(movies);
            }
        }

        //sort it by name
        Collections.sort(matchingMovie,(o1, o2) -> o1.getName().compareTo(o2.getName()));

        return matchingMovie;
    }
}
