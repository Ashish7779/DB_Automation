package com.blz.qa.db_automation.testing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DB_Test extends Base_Class {
	@Test
	public void getTableData() throws SQLException {
		con = this.setUp();
		//Statement Object to send queries.
		Statement stmt = con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from emp");
		while (rs.next())
	    {
	        int id =rs.getInt(1);
	        String name =rs.getString(2);
	        int salary =rs.getInt(3);
	        
	        System.out.println(id+"  "+name+"  "+salary );
	    }
	}
	@Test
	 public void insertData() throws SQLException {
		 con=this.setUp();
		 PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
		 ps.setInt(1,4);
		 ps.setString(2, "Ashish");
		 ps.setInt(3, 1300);
		 ps.executeUpdate();
		 getTableData();
	 }
	@Test 
	 
	 public void updateTableData () throws SQLException {
		con=this.setUp();
		 PreparedStatement ps = con.prepareStatement("update emp set name = ? where id = ?");
		 ps.setInt(2, 3);
		 ps.setString(1, "Suraj");
		 
		 ps.executeUpdate();
		 getTableData(); 
	 }
	@Test
	
	public void deleteTaleData() throws SQLException {
		 con=this.setUp();
		 PreparedStatement ps = con.prepareStatement("delete from emp where Id= ?");
		 ps.setInt(1, 2);
		 ps.executeUpdate();
		 getTableData(); 
		
	}
	

}
