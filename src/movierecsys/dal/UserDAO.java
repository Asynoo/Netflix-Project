/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import movierecsys.be.User;

/**
 *
 * @author pgn
 */
public class UserDAO
{
    private static final String USER_SOURCE = "data/users.txt";

    /**
     * Gets a list of all known users.
     * @return List of users.
     */
    public List<User> getAllUsers() throws FileNotFoundException, IOException
    {
        List<User> allUsers = new ArrayList<>();
        File file = new File(USER_SOURCE);

        // this works
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                try
                {
                    User name = stringArrayToUser(line);
                    allUsers.add(name);
                } catch (Exception ex)
                {

                }
            }
        }
        return allUsers;
    }

    private User stringArrayToUser(String t)
    {
        String[] arrUser = t.split(",");
        String name = arrUser[0];

        User allUsers = new User(name);
        return allUsers;
    }
    /**
     * Gets a single User by its ID.
     * @param id The ID of the user.
     * @return The User with the ID.
     */
    public User getUser(int id)
    {
        //TODO Get User
        return null;
    }
    
    /**
     * Updates a user so the persistence storage reflects the given User object.
     * @param user The updated user.
     */
    public void updateUser(User user)
    {
        //TODO Update user.
    }
    
}
