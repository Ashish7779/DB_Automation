package com.blz.qa.db_automation.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base_Class {
	public static Connection con;
	@BeforeTest
	public Connection setUp() throws SQLException {
		String dburl="jdbc:mysql://localhost:3306/db_automation";
		String username ="root";
		String password ="ashish123@kumar";
		Connection con = DriverManager.getConnection(dburl,username,password);
		return con;
	}
	
	@AfterTest
	public void tearDown() throws SQLException {
	
		con.close();
	}

}
