package com.ht.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Properties;

public class DataSources extends XMLChangeBroadcaster {
	private static DataSources datasourcesObj = null;
	private HashMap<?, ?> dataSources;
//	private static final String CONF_FILE = "F:/ECLIPSE_DATA/icare/web/WEB-INF/persistence-mysql.properties";
	private String CONF_FILE;
	private String defaultDSName;

	private static Logger logger = Logger.getLogger(DataSources.class);

	private DataSources() {
		try {
			CONF_FILE = DataSources.class.getResource("/").toURI().getPath().replace("//","/").replace("classes/", "persistence-mysql.properties");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	public static DataSources getInstance() {
		if (datasourcesObj == null) {
			datasourcesObj = new DataSources();
		}
		return datasourcesObj;
	}

	public DataSource initialize() {
		DataSource source = null;
		File file = null;
		Properties props = null;
		FileInputStream fs = null;
		try {
			file = new File(CONF_FILE);
			if (file.exists()) {
				props = new Properties();
				fs = new FileInputStream(file);
				props.load(fs);
				String driver = "jdbc.driverClassName";
				String url = "jdbc.url";
				String userId = "jdbc.username";
				String userPwd = "jdbc.password";
				if (props.getProperty(driver) != null) {
					driver = props.getProperty(driver);
				} else {
					driver = "";
				}
				if(props.getProperty(url) != null) {
					url = props.getProperty(url);
				} else {
					url = "";
				}
				if(props.getProperty(userId) != null) {
					userId = props.getProperty(userId);
				} else {
					userId = "";
				}
				if(props.getProperty(userPwd) != null) {
					userPwd = props.getProperty(userPwd);
				} else {
					userPwd = "";
				}
				source = new DataSource("icare", driver, url, "des56",userId, userPwd, "", null);
			}
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (fs != null) {
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return source;
	}

	public DataSource getDataSource(String name) {
		return ((DataSource) this.dataSources.get(name));
	}

	public DataSource getDefaultDataSource() {
		return ((DataSource) this.dataSources.get(this.defaultDSName));
	}

	public boolean isDataSource(String name) {
		return (getDataSource(name) != null);
	}

	public static void main(String[] args) {
		/*
		 * String filePath = "D:\\test\\datasource.xml";
		 * System.out.println("test"); DataSources.getInstance().initialize();
		 */
		BasicDataSource dataSource;
		try {
			dataSource = DataSourceConnection.getInstance().getDataSource();
			Connection conn = dataSource.getConnection();
			 Statement stat = conn.createStatement();
	            String sql = "select * from ICARE_USER";
	            ResultSet rs = stat.executeQuery(sql);
	            while(rs.next()) {
	            	System.out.println(rs.getString(2));
	            }
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}