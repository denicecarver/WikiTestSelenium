package com.selenium.wikitest.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class SQLiteJDBC {

	private static final String homeConnection = "jdbc:sqlite:src\\com\\selenium\\wikitest\\data\\wikidata.db";

	public final static int xPathID = 0;
	public final static int titleID = 1;
	
	public static ArrayList<String[]> queryData(String table, String column1Name) throws Exception {
		ArrayList<String[]> listStrings = queryData(table, column1Name, column1Name);
		return listStrings;
	}    
	
	public static ArrayList<String[]> queryData(String table,
					String column1Name, String column2Name) throws SQLException {
		ArrayList<String[]> records = new ArrayList<>(200);
		ResultSet rs = null;
		Connection connection;
		connection = DriverManager.getConnection(homeConnection);
		try (Statement statement = connection.createStatement()) {
			rs = statement.executeQuery( "SELECT * FROM " + table + ";" );
			while ( rs.next() ) {
				String[] search = new String[2];
				search[0] = rs.getString(column1Name);
				search[1] = rs.getString(column2Name);
				records.add(search);
			}
			rs.close();
		}

		return records;
	}    
	
	public static ArrayList<String[]> queryData(
			String table,
			String column1Name,
			String column2Name,
			String column3Name) throws SQLException {
		ArrayList<String[]> records = new ArrayList<>(200);
		ResultSet rs = null;
		Connection connection;
		connection = DriverManager.getConnection(homeConnection);
		try (Statement statement = connection.createStatement()) {
			rs = statement.executeQuery( "SELECT * FROM " + table + ";" );
			while ( rs.next() ) {
				String[] search = new String[3];
				search[0] = rs.getString(column1Name);
				search[1] = rs.getString(column2Name);
				search[2] = rs.getString(column3Name);
				records.add(search);
			}
			rs.close();
		}

		return records;
	}    

	// Insert link records into home page table
    public static void insertLanguageLinks(ArrayList<String[]> records) throws SQLException {
		
		try (Connection connection = DriverManager.getConnection(homeConnection);
				 Statement statement = connection.createStatement()) {

			for (String[] record : records) {
				String title = record[titleID];
				if (title.contains("'")) {
					title = title.replace("'", "''");
				}
				insertLanguageLink(statement, record[xPathID], record[titleID]);
			}
		}
    }
    
    // Insert one link record into home page table
    private static void insertLanguageLink(Statement statement, String link, String title) throws SQLException {
    		String sql = "INSERT INTO LanguageLinks (Link, Title) VALUES ('" +
    				link + "', '" + title + "');";
    		statement.executeUpdate(sql);
    }
    
    // Insert one link record into home page table
    private static void insertSQL(Statement statement, String sql) throws SQLException {
    		statement.executeUpdate(sql);
    }

    public static void insertIntoTable(String tableName, String[] columnNames, String[] valueSet) {

        Connection connection = null;
        Statement statement = null;
    	try {
    	Class.forName("org.sqlite.JDBC");  
    	connection = DriverManager.getConnection(homeConnection);
    	statement = connection.createStatement();
    	

    		String columns = columnNames[0];
    		String values = "'" + valueSet[0] + "'";
    		for (int i = 1; i < columnNames.length; i++) {
    			columns = columns + "," + columnNames[i];
    			values = values + ",'" + valueSet[i] + "'";
    		}
    		String sql = "INSERT INTO " + tableName +
    				" (" + columns + ") VALUES (" + values + ");";
    		insertSQL(statement, sql);
    		statement.close();
    		connection.close();
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
//                statement.close();  
                connection.close();  
            } catch (Exception e) {  
//                e.printStackTrace();  
            }
        }
    }

    public static void updateRecord(String tableName, String columnName, String value, String whereDelimiter) {

        if (whereDelimiter == null || whereDelimiter.equals("")) {
        	return;
        }
    	Connection connection = null;
        Statement statement = null;
    	try {
    	Class.forName("org.sqlite.JDBC");  
    	connection = DriverManager.getConnection(homeConnection);
    	statement = connection.createStatement();
    	

//    		String columns = columnNames[0];
//    		String values = "'" + valueSet[0] + "'";
//    		for (int i = 1; i < columnNames.length; i++) {
//    			columns = columns + "," + columnNames[i];
//    			values = values + ",'" + valueSet[i] + "'";
//    		}
    		String sql = "UPDATE " + tableName +
    				" SET " + columnName + " = '" + value + "' WHERE " + whereDelimiter + ";" ;
    		insertSQL(statement, sql);
    		statement.close();
    		connection.close();
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
//                statement.close();  
                connection.close();  
            } catch (Exception e) {  
//                e.printStackTrace();  
            }
        }
    }
    
    public static void insertIntoTable(String tableName, String columnName, ArrayList<String> value) throws SQLException {

    	try (Connection connection = DriverManager.getConnection(homeConnection);
    			Statement statement = connection.createStatement()) {

    		for (String record : value) {
    			insertRecord(statement, tableName, columnName, record);
    		}
    	}
    }
    
    private static void insertRecord(Statement statement, String tableName, String columnName, String value) throws SQLException {
    	String sql = "INSERT INTO " + tableName +
    			" (" + columnName + ") VALUES ('" + value + "');";
    	statement.executeUpdate(sql);
    }

    public static void updateLanguageLinkTitles(ArrayList<String[]> records) throws SQLException {
		try (Connection connection = DriverManager.getConnection(homeConnection);
			 Statement statement = connection.createStatement()) {
    	    	for (String[] record : records) {
					updateLanguageLinkTitle(statement, record[xPathID], record[titleID]);
				}
		}
    }
    
    private static void updateLanguageLinkTitle(Statement statement, String existingLink, String updateTitle) throws SQLException {
    	String sql = "UPDATE LanguageLinks " +
    			"SET title = '" + updateTitle +
    			"' WHERE link = '" + existingLink + "';";
    	statement.executeUpdate(sql);
    }
    
}
