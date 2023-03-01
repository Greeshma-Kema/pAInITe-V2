package com.mohs10.database_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

public class User_info {
	
		
	@Test
    public void testDB () throws ClassNotFoundException, SQLException	
{		
	Class.forName("com.mysql.jdbc.Driver");
	
	System.out.println("Driver loaded");
	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo","root","Hailey@700");
	
	System.out.println("Connected to MySQL DB");
	
	Statement smt=con.createStatement();
	
	//to get all the info of table, see below query for reference
	 ResultSet rs=smt.executeQuery("select * from userinfo1");
	 
	//To delete any particular row, see below query for reference
	//String sqldlt ="DELETE FROM userinfo1 WHERE Email='testingautomation40@gmail.com'";
	//PreparedStatement pst_del =  con.prepareStatement(sqldlt);	
	// int del=pst_del.executeUpdate(sqldlt);
	 
	 //to insert a row in table, see below query for reference
	// String sqlinsert="INSERT INTO userinfo1 (Email, Password, Shoppingcart)\n" + "VALUES ('maha@gmail.com', 'password123', 'shoes')";
	 //PreparedStatement pst_ins =  con.prepareStatement(sqlinsert);
	// int ins=pst_ins.executeUpdate(sqlinsert);
	 
	 //to update any column records in table, see below query for reference
//	 String sqlupdate="UPDATE userinfo1\n" + "SET email = 'John@gmail.com'\n" + "WHERE email = 'tharunnurat@gmail.com'";
	// PreparedStatement pst_upd =  con.prepareStatement(sqlupdate);
	// int upd=pst_upd.executeUpdate(sqlupdate);
	 
	 //To alter
	//String sqlalter=" ALTER TABLE userinfo1 ADD Name varchar(255)";
	 String sqlalter=" ALTER TABLE userinfo1 DROP COLUMN Address";
	PreparedStatement pst_alt =  con.prepareStatement(sqlalter);
	 int alt=pst_alt.executeUpdate(sqlalter);
	 
	
	 
	 
	while(rs.next())
	{
	String Email=rs.getString("Email");
	System.out.println(":Database record is "+Email);
	
		String Password=rs.getString("Password");
	System.out.println(":Database record is "+Password);

	} 
}
}
