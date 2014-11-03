package com.selenium.wikitest.webpage.homepage;

import com.selenium.wikitest.shared.SQLiteJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class SQLiteHomePage extends SQLiteJDBC {
	
	private static final String homeConnection ="HomePage.ConnectionDetails"; 
	
//	public static ArrayList<String[]> queryLanguageLinks() {
//		ArrayList<String[]> records = new ArrayList<>(300);
//
//		loadConnection(HomePageText.getString(homeConnection));
//
//		try {
//			ResultSet rs = statement.executeQuery( "SELECT * FROM LanguageLinks;" );
//			while ( rs.next() ) {
//				String[] record = new String[2];
//				record[0] = rs.getString(HomePageText.getString("LanguageLinks.Column1"));
//				record[1] = rs.getString(HomePageText.getString("LanguageLinks.Column2"));
//				records.add(record);
//
//				System.out.println( "XPath = " + xpath );
//				System.out.println( "Page Title = " + title );
//			}
//			rs.close();
//		} catch ( Exception e ) {
//			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//			System.exit(0);
//		}
//
//    	closeDBResources();
//
//		return records;
//	}    
	
	public static ArrayList<String[]> queryData(String table, String column1Name) {
		return queryData(table, column1Name, column1Name);
	}    
	
//	public static ArrayList<String[]> queryData(String table, String columnName) {
//		ArrayList<String[]> records = new ArrayList<>(200);
//
//		loadConnection(HomePageText.getString(homeConnection));
//
//		try {
//			ResultSet rs = statement.executeQuery( "SELECT * FROM " + table + ";" );
//			while ( rs.next() ) {
//				String[] search = new String[1];
//				search[0] = rs.getString(columnName);
//				records.add(search);
//			}
//			rs.close();
//		} catch ( Exception e ) {
//			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//			System.exit(0);
//		}
//
//    	closeDBResources();
//
//		return records;
//	}    
	
	public static ArrayList<String[]> queryData(String table, String column1Name, String column2Name) {
		ArrayList<String[]> records = new ArrayList<>(200);

		loadConnection(HomePageText.getString(homeConnection));

		try {
			ResultSet rs = statement.executeQuery( "SELECT * FROM " + table + ";" );
			while ( rs.next() ) {
				String[] search = new String[2];
				search[0] = rs.getString(column1Name);
				search[1] = rs.getString(column2Name);
				records.add(search);
			}
			rs.close();
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}

    	closeDBResources();

		return records;
	}    

	// Insert link records into home page table
    public static void insertLanguageLinks(ArrayList<LanguageLink> linkData) {
    	loadConnection(HomePageText.getString(homeConnection));

    	for (LanguageLink record : linkData) {
    		try {
    			String title = record.getTitle();
    			if (title.contains("'")) {
    				title = title.replace("'", "''");
    			}
				insertLanguageLink(record.getXPath(), title);
			} catch (SQLException e) {
				System.out.println("xPath = " + record.getXPath());
				System.out.println("title = " + record.getTitle());
				e.printStackTrace();
			}
    	}

    	closeDBResources();
    }
    
    // Insert one link record into home page table
    private static void insertLanguageLink(String link, String title) throws SQLException {
    		String sql = "INSERT INTO LanguageLinks (Link, Title) VALUES ('" +
    				link + "', '" + title + "');";
    		statement.executeUpdate(sql);
    }
    
    public static void insertIntoTable(String tableName, String columnName, ArrayList<String> value) {
    	loadConnection(HomePageText.getString(homeConnection));

    	for (String record : value) {
    		insertRecord(tableName, columnName, record);
    	}

    	closeDBResources();
    }
    
    private static void insertRecord(String tableName, String columnName, String value) {
		String sql = "INSERT INTO " + tableName +
				" (" + columnName +
				") VALUES ('" + value + "');";
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Table: " + tableName);
			System.out.println("Record: " + value);
			e.printStackTrace();
		}
    }

    public static void updateLanguageLinkTitles(ArrayList<LanguageLink> links) {
    			loadConnection(HomePageText.getString(homeConnection));
    	    	for (LanguageLink link : links) {
					try {
						updateLanguageLinkTitle(link.getXPath(), link.getTitle());
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
    }
    
    private static void updateLanguageLinkTitle(String existingLink, String updateTitle) throws SQLException {
    	String sql = "UPDATE LanguageLinks " +
    			"SET title = '" + updateTitle +
    			"' WHERE link = '" + existingLink + "';";
    	statement.executeUpdate(sql);
    }
    
}
