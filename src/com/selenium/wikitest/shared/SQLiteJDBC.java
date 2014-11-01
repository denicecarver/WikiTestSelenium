package com.selenium.wikitest.shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteJDBC {
	protected static Connection connection = null;
	protected static Statement statement = null;
    
	protected static void loadConnection(String connectDetails) {
		try{
			Class.forName("org.sqlite.JDBC");

			connection = DriverManager.getConnection(connectDetails);
    		statement = connection.createStatement();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
    
    protected static void closeDBResources() {
    	if(statement!=null) {
    		try {
    			statement.close();
    			connection.close();
    			connection = null;
    		} catch (SQLException e) {
    			e.printStackTrace();
    		} finally {
    			if(connection!=null) {
    				try {
    					statement.close();
    					connection.close();
    					connection = null;
    				} catch (SQLException e) {
    					e.printStackTrace();
    				}
    			}
    		}
    	}
    }

}
