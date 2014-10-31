package com.selenium.wikitest.webpage.homepage;

import java.io.UnsupportedEncodingException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.DatatypeConverter;

public class SQLiteJDBCHomePage {
// Create table with 2 columns Link and Title
// In LanguageLink.csv file, loop through records, adding them to the table
    //Creates a 2D ArrayList from table 
	public static ArrayList<LanguageLink> queryLanguageLinks() {
    	ArrayList<LanguageLink> records = new ArrayList<>(200);
		Connection conn = null;
		Statement stmt = null;
//    	int rowCount = 0;

    	try {
			//STEP 2: Register JDBC driver
	      conn = getConnection(HomePageText.getString("HomePage.ConnectionDetails"));
	      stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT * FROM LanguageLinks;" );
	      while ( rs.next() ) {
	    	 String  xpath = rs.getString("Link");
	    	 String title = rs.getString("Title");
	    	 records.add(new LanguageLink(xpath, title));

	         System.out.println( "XPath = " + xpath );
	         System.out.println( "Page Title = " + title );
	      }
	      rs.close();
	      stmt.close();
		} catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }

	    System.out.println("Operation done successfully");
	    return records;
    }
    
    public static Connection getConnection(String connectionInfo) {
    	Connection conn = null;
//    	Statement stmt = null;
    	try{
    		//STEP 2: Register JDBC driver
    		Class.forName("org.sqlite.JDBC");

    		//STEP 3: Open a connection
    		conn = DriverManager.getConnection(connectionInfo);
    		System.out.println("Connected to database successfully...");
    	}
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	return conn;
    }
    
    public static void buildLanguageLinkTable() {
    	
    }
    
    
    // Insert link records into home page table
    public static ResultSet insertLanguageLinks(ArrayList<LanguageLink> linkData) {
    	try {
    		Connection connection = null;
    		Statement stmt = null;
    		try{
    			//STEP 2: Register JDBC driver
    			Class.forName("org.sqlite.JDBC");

//    			//STEP 3: Open a connection
    			connection = getConnection(HomePageText.getString("HomePage.ConnectionDetails"));
    			stmt = connection.createStatement();
    			
    			// Walk through the list of XPaths to the links
    			Iterator<LanguageLink> LinkIterator = linkData.iterator();
    			int count = 0;
    			while (LinkIterator.hasNext()) {
    				LanguageLink curr = LinkIterator.next();
    				SQLiteJDBCHomePage.insertLanguageLink(stmt, curr.getLinkXPath(), curr.getExpectedResultTitle());
    				count++;
    			}
    			System.out.println("Link count: " + count);

    		}catch(SQLException se){
    			//Handle errors for JDBC
    			se.printStackTrace();
    		}catch(Exception e){
    			//Handle errors for Class.forName
    			e.printStackTrace();
    		}finally{
    			//finally block used to close resources
    			try{
    				if(stmt!=null) {
    					stmt.close();
    					connection.close();
    					connection = null;
    				}
    			}catch(SQLException se){
    			}// do nothing
    			try{
    				if(connection!=null) {
    					stmt.close();
    					connection.close();
    					connection = null;
    				}
    			}catch(SQLException se){
    				se.printStackTrace();
    			}//end finally try
    		}//end try
    		
		} catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }

    	System.out.println("Operation done successfully");
	    return null;
    }

    public static void updateLanguageLinkTitles(ArrayList<LanguageLink> links) {
    	try {
    		Connection connection = null;
    		Statement stmt = null;
    		try{
    			//STEP 2: Register JDBC driver
    			Class.forName("org.sqlite.JDBC");

    			//STEP 3: Open a connection
    			connection = getConnection(HomePageText.getString("HomePage.ConnectionDetails"));
    			stmt = connection.createStatement();
    	    	for (LanguageLink link : links) {
					updateLanguageLinkTitle(stmt, link.getLinkXPath(), link.getExpectedResultTitle());
				}
    		}catch(SQLException se){
    			//Handle errors for JDBC
    			se.printStackTrace();
    		}catch(Exception e){
    			//Handle errors for Class.forName
    			e.printStackTrace();
    		}finally{
    			//finally block used to close resources
    			try{
    				if(stmt!=null) {
    					stmt.close();
    					connection.close();
    					connection = null;
    				}
    			}catch(SQLException se){
    			}// do nothing
    			try{
    				if(connection!=null) {
    					stmt.close();
    					connection.close();
    					connection = null;
    				}
    			}catch(SQLException se){
    				se.printStackTrace();
    			}//end finally try
    		}//end try

    	} catch ( Exception e ) {
    		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    		System.exit(0);
    	}

    	System.out.println("Operation done successfully");
    }
    
    private static void updateLanguageLinkTitle(Statement statement, String existingLink, String updateTitle) {
    	try {
    		String sql = "UPDATE LanguageLinks " +
    				"SET title = '" + updateTitle +
    				"' WHERE link = '" + existingLink + "';";
    		statement.executeUpdate(sql);

    		System.out.println("Updated record in the LanguageLinks table...");

    	}catch(SQLException se){
    		//Handle errors for JDBC
    		se.printStackTrace();
    	}
    	System.out.println("Operation done successfully");
    }

    
    // Insert one link record into home page table
    private static void insertLanguageLink(Statement statement, String link, String title) {
    	try {
    		String sql = "INSERT INTO LanguageLinks " +
    				"VALUES ('" + link + "', '" + title + "');";
    		statement.executeUpdate(sql);

    		System.out.println("Inserted records into the table...");

    	}catch(SQLException se){
    		//Handle errors for JDBC
    		se.printStackTrace();
    	}
    	System.out.println("Operation done successfully");
    }
    
    public static String convertUnicodeEncodedToString(String encoded) {
    	String[] arr = encoded.split("u");
    	String text = "";
    	for(int i = 1; i < arr.length; i++){
    		// replace this substring with method that removes \
    		int slash = arr[i].indexOf("\\");
    		if (slash != -1) {
    			arr[i] = arr[i].substring(0, slash);
    		}
    	    int intVal = Integer.parseInt(arr[i], 16);
    	    text += (char)intVal;
    	}
    	System.out.println(text);
    	return text;
    }
    
    public static String convertStringToUnicode(String toConvert) {
    	String hexOut = new String();
    	try {
    	    byte[] utf8Bytes = toConvert.getBytes("UTF8");
    	    byte[] defaultBytes = toConvert.getBytes();

    	    String roundTrip = new String(utf8Bytes, "UTF8");
    	    System.out.println("roundTrip = " + roundTrip);
    	    System.out.println(defaultBytes);
	    	String hex = DatatypeConverter.printHexBinary(utf8Bytes);
	    	System.out.println(hex);
    	    for (int i = 0; i < hex.length(); i = i + 2) {
    	    	hexOut = hexOut + "\\u00" + hex.substring(i, i + 2);
    	    }
    	    System.out.println(hexOut);
    	    //printBytes(utf8Bytes, "utf8Bytes");
    	    //System.out.println();
    	    //printBytes(defaultBytes, "defaultBytes");
    	} 
    	catch (UnsupportedEncodingException e) {
    	    e.printStackTrace();
    	}
    	return hexOut;
    }
    
//    public void closeConnection() {
//    	try {
//			c.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//    }
//
//	public static void main(String[] args) throws SQLException, Exception {
//		SQLiteJDBC linkData = new SQLiteJDBC();
//		ArrayList<ArrayList<String>> data = linkData.QueryAllLanguageLinks();
//	}
//
}
