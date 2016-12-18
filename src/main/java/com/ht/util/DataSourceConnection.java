package com.ht.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import java.sql.*;


public class DataSourceConnection{
    private static Logger logger = Logger.getLogger(DataSourceConnection.class);
    private static DataSourceConnection dataSourceConnection = null;
    private static BasicDataSource dataSource = null;

	public BasicDataSource getDataSource() {
		return dataSource;
	}

	private DataSourceConnection(){
		DataSourceFactory factory = new DataSourceFactory();
		try{
			dataSource = factory.getDefaultDataSource();
		} catch(Exception e){
			logger.error(e);
		}
	}

	public synchronized static DataSourceConnection getInstance() throws Exception {
		if (null == dataSourceConnection) {
			dataSourceConnection = new DataSourceConnection();
		}
		return dataSourceConnection;
	}
	
	  public static void main(String[] args) {
			  
			  String driver = "com.mysql.jdbc.Driver";        
	         String url = "jdbc:mysql://192.168.1.9:3306/icare";
	         String user = "icareuser";   
	          String password = "icareuser";   
		      // String url = "jdbc:mysql://mysql707.cp.hostnet.nl:3306/db157563_icwhich";
		      /* String url = "jdbc:mysql://mysql707.cp.hostnet.nl:3306/db157563_icwhich";
	           String user = "u157563_icwhich";   
	           String password = "icwhichno1"; */ 
	           try { 
	             
	             Class.forName(driver);  
	             Connection conn = DriverManager.getConnection(url, user, password);  
	            if(!conn.isClosed()) 
	              System.out.println("Succeeded connecting to the Database!"); 
	            else {
	            	 System.out.println("Can not connec to the Database!"); 
	            }
	            	
	            Statement stat = conn.createStatement();
	            String sql = "select * from ICARE_USER";
	            ResultSet rs = stat.executeQuery(sql);
	            while(rs.next()) {
	            	System.out.println(rs.getString(2));
	            }

			//DataSourceConnection.getInstance().getDataSource();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	  }
}
