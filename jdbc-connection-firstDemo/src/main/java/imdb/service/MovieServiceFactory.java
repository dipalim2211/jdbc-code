package imdb.service;

//Based on some methode return the services

public class MovieServiceFactory {

    public static IMovieService getMovieService(String type){
        if(type.equals("JDBC"))
        {
            return new JdbcMovieServiceImpl();
        } else if (type.equals("IN_MEMORY")) {
            return new InMemoryMovieServiceImpl();
        }else {
            throw new IllegalArgumentException("Invalid Service Type");
        }
    }


}
