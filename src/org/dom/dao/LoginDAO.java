package org.dom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.dom.model.Login;

public class LoginDAO {

	private Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Class.forName("oracle.jdbc.driver.OracleDriver")
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=daitest;user=sa;password=Avianca2015!";
            //String connString="jdbc:oracle:thin:@prodHost:1521:ORCL";
            return DriverManager.getConnection(connectionUrl);
        } catch (SQLException sqlEx) {
            System.out.println("SQL Exception: "+ sqlEx.toString());
            return null;
        } catch (ClassNotFoundException classEx) {
            System.out.println("Class Not Found Exception: "+ classEx.toString());
            return null;
        } catch (Exception Ex) {
            System.out.println("Exception: "+ Ex.toString());
            return null;
        }
    }
	
	public void save(Login login) throws SQLException{
        String sql = "INSERT INTO Login (idlogin, usrname, pwd) VALUES (" + login.getId() + ",'" + login.getUsername() + "','" + login.getPassword() + "')";
        Statement stmt = getConnection().createStatement();
        stmt.executeUpdate(sql);
        stmt.close();
    }
	
	
}
