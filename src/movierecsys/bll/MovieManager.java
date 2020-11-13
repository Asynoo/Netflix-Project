package movierecsys.bll;

import movierecsys.be.Movie;
import movierecsys.be.User;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies;
    private List<User> users;

     public MovieManager(List<Movie> movies,List<User> users){
         this.movies = movies;
         this.users = users;
     }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<User> getUsers() {
        return users;
    }
}
