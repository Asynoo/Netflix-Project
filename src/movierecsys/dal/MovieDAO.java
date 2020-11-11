/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import movierecsys.be.Movie;

/**
 *
 * @author pgn
 */
public class MovieDAO
{

    private static final String MOVIE_SOURCE = "data/movie_titles.txt";

    /**
     * Gets a list of all movies in the persistence storage.
     *
     * @return List of movies.
     * @throws java.io.FileNotFoundException
     */
    public List<Movie> getAllMovies() throws FileNotFoundException, IOException
    {
        List<Movie> allMovies = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(MOVIE_SOURCE))))
        {
            String line;
            while ((line = reader.readLine()) != null && !line.isBlank())
            {
                try
                {
                    Movie mov = stringArrayToMovie(line);
                    allMovies.add(mov);
                } catch (Exception ex)
                {

                }
            }
        }catch (FileNotFoundException fnfe)
        {
            System.out.println("We've done a fucky-wucky");
            fnfe.printStackTrace();
        }
        return allMovies;
    }

    /**
     * Reads a movie from a , s
     *
     * @param movString
     * @return
     * @throws NumberFormatException
     */
    private Movie stringArrayToMovie(String movString)
    {
        String[] arrMovie = movString.split(",");

        int id = Integer.parseInt(arrMovie[0]);
        int year = Integer.parseInt(arrMovie[1]);
        String title = arrMovie[2];

        return new Movie(id, year, title);
    }

    /**
     * Creates a movie in the persistence storage.
     *
     * @param releaseYear The release year of the movie
     * @param title The title of the movie
     * @return The object representation of the movie added to the persistence
     * storage.
     */
    private Movie createMovie(int releaseYear, String title)
    {
        //TODO Create movie.
        return null;
    }

    /**
     * Deletes a movie from the persistence storage.
     *
     * @param movie The movie to delete.
     */
    private void deleteMovie(Movie movie)
    {
        //TODO Delete movie
    }

    /**
     * Updates the movie in the persistence storage to reflect the values in the
     * given Movie object.
     *
     * @param movie The updated movie.
     */
    private void updateMovie(Movie movie)
    {
        //TODO Update movies
    }

    /**
     * Gets a the movie with the given ID.
     *
     * @param id ID of the movie.
     * @return A Movie object.
     */
    private Movie getMovie(int id)
    {
        //TODO Get one Movie
        return null;
    }

}
