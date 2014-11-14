package com.selenium.wikitest.webpage.homepage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class SQLiteHomePage {

	private static final String homeConnection ="HomePage.ConnectionDetails"; 

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
		connection = DriverManager.getConnection(HomePageText.getString(homeConnection));
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

	// Insert link records into home page table
    public static void insertLanguageLinks(ArrayList<String[]> records) throws SQLException {
		
		try (Connection connection = DriverManager.getConnection(HomePageText.getString(homeConnection));
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
    
    public static void insertIntoTable(String tableName, String columnName, ArrayList<String> value) throws SQLException {

    	try (Connection connection = DriverManager.getConnection(HomePageText.getString(homeConnection));
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
		try (Connection connection = DriverManager.getConnection(HomePageText.getString(homeConnection));
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
