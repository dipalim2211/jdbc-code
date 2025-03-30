package imdb.service;

import imdb.db.DBConnectionMovie;
import imdb.model.Genre;
import imdb.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Class : maintain data in database

public class JdbcMovieServiceImpl implements IMovieService{

    private Connection connection=null;

    public JdbcMovieServiceImpl(){
        connection= DBConnectionMovie.getConnection();
    }

    //To avoid repeatation of cade :
    //repeated code placed in one methode

    private Movie mapMovie(ResultSet rs){

        try {
          int  id = rs.getInt("id");
          String  name = rs.getString("name");
          int year = rs.getInt("year");
          String genre = rs.getString("genre");

            return new Movie(id,name,Genre.valueOf(genre),year);

        } catch (SQLException e) {
            e.printStackTrace();
            return  null;
        }

    }


    @Override
    public boolean addMovie(String name, Genre genre, int year) {

        final String insertQuery = "insert into movies(name,genre,year) values (?,?,?)";

        System.out.println("Query Inserted : "+insertQuery);

        try(PreparedStatement statement = connection.prepareStatement(insertQuery))
        {
            System.out.println("Connection : "+connection);

            statement.setString(1,name);
            statement.setString(2, genre.name());
            statement.setInt(3,year);

            int count = statement.executeUpdate();

            return (count>0) ? true : false;

            /*
            if(count>0){
                System.out.println("Movie Record Inserted");
            }else{
                System.out.println("Movie Record Not Inserted");
               // return false;
            }
             */

        }catch (Exception e) {
            e.printStackTrace();
            return false; //if any exception occur return false
        }
       // return true; //when added return true

    }

    @Override
    public Movie getMovieById(long id) {

        final String SELECT_QUERY = "select * from movies where id =?";

        try(PreparedStatement statement = connection.prepareStatement(SELECT_QUERY))

        {
            statement.setLong(1,id);
            ResultSet rs = statement.executeQuery();
            System.out.println("Connection : "+connection);

            while (rs.next()) {
               Movie movie =mapMovie(rs);
                return  movie;
            }
        rs.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {

        List<Movie> movies = new ArrayList<>();

        final String SELECT_QUERY = "select * from movies";

        try(PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
            ResultSet rs = statement.executeQuery())
        {
            System.out.println("Connection : "+connection);

            while (rs.next()) {
                Movie movie =mapMovie(rs);
                movies.add(movie);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
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
