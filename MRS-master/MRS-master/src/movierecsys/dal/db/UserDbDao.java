/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movierecsys.dal.db;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import movierecsys.be.Movie;
import movierecsys.be.User;
import movierecsys.dal.intereface.IUserRepository;

/**
 *
 * @author pgn
 */
public class UserDbDao implements IUserRepository
{

    @Override
    public List<User> getAllUsers()
    {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setServerName("10.176.111.31");
        ds.setDatabaseName("Netflix");
        ds.setUser("CS2018A_14");
        ds.setPassword("CS2018A_14");

        List<User> users = new ArrayList<>();
        
        try (Connection con = ds.getConnection())
        {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM User;");
            while(rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                User user = new User(id, name);
                users.add(user);
            }

        } catch (SQLException ex)
        {
        }
        return users;
    }

    @Override
    public User getUser(int id)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(User user)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
