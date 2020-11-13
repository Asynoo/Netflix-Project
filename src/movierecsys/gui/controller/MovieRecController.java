/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import movierecsys.be.Movie;
import movierecsys.bll.MovieManager;
import movierecsys.bll.util.MovieSearcher;
import movierecsys.dal.MovieDAO;
import movierecsys.dal.UserDAO;

/**
 *
 * @author pgn
 */
public class MovieRecController implements Initializable
{
    /**
     * The TextField containing the URL of the targeted website.
     */
    @FXML
    private TextField txtMovieSearch;

    /**
     * The TextField containing the query word.
     */
    @FXML
    private ListView<String> lstMovies;

    private MovieSearcher movSearch = new MovieSearcher();
    private MovieManager movManager = new MovieManager(new MovieDAO().getAllMovies(),new UserDAO().getAllUsers());

    public MovieRecController() throws IOException {
    }


    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
       txtMovieSearch.textProperty().addListener((observableValue, s, t1) -> {
           lstMovies.setItems(movSearch.search(movManager.getMovies(),txtMovieSearch.getText()));
       });
        
    }
}