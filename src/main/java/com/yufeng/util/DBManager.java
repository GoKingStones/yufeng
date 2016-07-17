package com.yufeng.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBManager {

	 private static String  username = "root";
	 private static    String password = "root";
	 //private static    String url = "jdbc:mysql://localhost:3336/gps";
	 private static    String url = "jdbc:mysql://localhost:3306/gps";
	 private static  	 String driver="com.mysql.jdbc.Driver";

	 static{
		 try {  
			 		Class.forName(driver).newInstance();
	         
	        } catch (Exception e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	 }
	  
	  
	    public static Connection getConnection() throws Exception {  
	        return DriverManager.getConnection(url,username,password);
	    }  
	  
	    public static void closeConnection(Connection con) {  
	        try {  
	            if (con != null)  
	                con.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	    public static void closePrepStmt(PreparedStatement prepStmt) {  
	        try {  
	            if (prepStmt != null)  
	                prepStmt.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	    public static void closeResultSet(ResultSet rs) {  
	        try {  
	            if (rs != null)  
	                rs.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	  
}
