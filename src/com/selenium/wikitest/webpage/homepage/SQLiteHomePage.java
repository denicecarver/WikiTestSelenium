package com.selenium.wikitest.webpage.homepage;

import com.selenium.wikitest.shared.SQLiteJDBC;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public final class SQLiteHomePage extends SQLiteJDBC {
	
	private static final String homeConnection ="HomePage.ConnectionDetails"; 
	
	public static ArrayList<LanguageLink> queryLanguageLinks() {
		ArrayList<LanguageLink> records = new ArrayList<>(200);

		loadConnection(HomePageText.getString(homeConnection));

		try {
			ResultSet rs = statement.executeQuery( "SELECT * FROM LanguageLinks;" );
			while ( rs.next() ) {
				String  xpath = rs.getString("Link");
				String title = rs.getString("Title");
				records.add(new LanguageLink(xpath, title));

				System.out.println( "XPath = " + xpath );
				System.out.println( "Page Title = " + title );
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
				insertLanguageLink(record.getLinkXPath(), record.getExpectedResultTitle());
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}

    	closeDBResources();
    }
    
    // Insert one link record into home page table
    private static void insertLanguageLink(String link, String title) throws SQLException {
    		String sql = "INSERT INTO LanguageLinks " +
    				"VALUES ('" + link + "', '" + title + "');";
    		statement.executeUpdate(sql);
    }

    public static void updateLanguageLinkTitles(ArrayList<LanguageLink> links) {
    			loadConnection(HomePageText.getString(homeConnection));
    	    	for (LanguageLink link : links) {
					try {
						updateLanguageLinkTitle(link.getLinkXPath(), link.getExpectedResultTitle());
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
