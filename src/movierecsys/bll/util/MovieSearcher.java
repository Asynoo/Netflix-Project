/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.bll.util;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import movierecsys.be.Movie;

/**
 *
 * @author pgn
 */
public class MovieSearcher
{
    public ObservableList<String> search(List<Movie> searchBase, String query)
    {
        List<String> searchResults = new ArrayList<>();
        for (Movie movie:searchBase){
            if ((movie.getTitle() + " " + movie.getYear()).toLowerCase().contains(query.toLowerCase())){
                searchResults.add(movie.toString());
            }
        }

        return FXCollections.observableList(searchResults);
    }
    
}
