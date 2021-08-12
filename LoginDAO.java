package com.elearning.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.elearning.dbutils.DBUtils;

public class LoginDAO implements LoginDAOI {

	

	@Override
	public boolean login(String username, String password, String role) {
		try
        {
            Connection con = DBUtils.getConnection(); 
            Statement stmt = con.createStatement();
            ResultSet rs;
			if(role.equalsIgnoreCase("admin"))
            	rs = stmt.executeQuery("select email,password from admin");
            else
            	rs = stmt.executeQuery("select email,password from user1");
            while(rs.next())
            {
             String usernameDB = rs.getString("email");
             String passwordDB = rs.getString("password");
             
              if(username.equals(usernameDB) && password.equals(passwordDB))
              {
                 return true; 
              }
            }
        }
        catch(SQLException e)
		{
        	e.printStackTrace();
		}
		return false;
	}

}
