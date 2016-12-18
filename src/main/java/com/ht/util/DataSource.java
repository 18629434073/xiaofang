package com.ht.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;

public class DataSource extends XMLChangeBroadcaster
{
  private String dataSourceName;
  private String dataSourceDriver;
  private String dataSourceConnection;
  private String dataSourceCipher;
  private String dataSourceUserName;
  private String dataSourcePassword;
  private String dataSourceClassPath;
  private String maxActive;

  private HashMap<String, String> hmPropertys = new HashMap<String, String>();
  private boolean defaultDS = false;
  private boolean defaultManager = true;
  private ClassLoader cl = null;

  private Logger logger = Logger.getLogger(DataSource.class);

  public DataSource(String name, String driver, String connection, String cipher, String userName, String password, String classPath, HashMap<String, String> hmPropertys)
  {
    this.dataSourceName = name;
    this.dataSourceDriver = driver;
    this.dataSourceConnection = connection;
    this.dataSourceCipher = cipher;
    this.dataSourceUserName = userName;
    this.dataSourcePassword = password;
    this.dataSourceClassPath = classPath;
    if (hmPropertys == null)
      this.hmPropertys.put("maxActive", "30");
    else
      this.hmPropertys = hmPropertys;
  }

  public String getMaxActive()
  {
    HashMap<String, String> hmPropertys = this.hmPropertys;
    Set<String> keys = hmPropertys.keySet();
    for (Object key :keys)
    {
      if (key.equals("maxActive"))
      {
        this.maxActive = hmPropertys.get(key);
      }
    }
    return this.maxActive;
  }

  public void setMaxActive(String maxActive)
  {
    if (this.maxActive == null) {
      this.maxActive = "";
    }
    if (!(this.maxActive.equals(maxActive))) {
      this.maxActive = maxActive;
      this.hmPropertys.put("maxActive", maxActive);
      fireChange(this.dataSourceName, 3, 5);
    }
  }

  public String getName()
  {
    return this.dataSourceName;
  }

  public void setName(String name)
  {
    String oldName = this.dataSourceName;
    this.dataSourceName = name;
    fireChange(oldName, name, 5);
  }

  public void setDefault(boolean value)
  {
    this.defaultDS = value;
  }

  public boolean isDefaultDS()
  {
    return this.defaultDS;
  }

  public String getDriver()
  {
    return this.dataSourceDriver;
  }

  public String getConnection()
  {
    return this.dataSourceConnection;
  }

  public String getUserName()
  {
    return this.dataSourceUserName;
  }

  public String getCipher()
  {
    return this.dataSourceCipher;
  }

  public String getPassword()
  {
    return this.dataSourcePassword;
  }

  public String getClassPath()
  {
    return this.dataSourceClassPath;
  }

  public void setConnection(String connection)
  {
    if (connection.equals(this.dataSourceConnection))
      return;
    this.dataSourceConnection = connection;
    fireChange(this.dataSourceName, 3, 5);
  }

  public void setUserName(String userName)
  {
    if (userName.equals(this.dataSourceUserName))
      return;
    this.dataSourceUserName = userName;
    fireChange(this.dataSourceName, 3, 5);
  }

  public void setCipher(String cipher)
  {
    if (cipher.equals(this.dataSourceCipher))
      return;
    this.dataSourceCipher = cipher;
    fireChange(this.dataSourceCipher, 3, 5);
  }

  public void setPassword(String password)
  {
    if (password.equals(this.dataSourcePassword))
      return;
    this.dataSourcePassword = password;
    fireChange(this.dataSourceName, 3, 5);
  }

  public Connection getJDBCConnection()
    throws SQLException
  {
    Connection con = null;
    try
    {
      if (this.defaultManager)
      {
        con = DriverManager.getConnection(this.dataSourceConnection, this.dataSourceUserName, this.dataSourcePassword);
      }
      else
      {
        con = JDBCDriverManager.getConnection(this.dataSourceConnection, this.dataSourceUserName, this.dataSourcePassword, this.cl);
      }
      this.logger.debug(new Object[] { "getCon", "Got connection: ", con });
    }
    catch (Exception ex)
    {
      SQLException se = new SQLException(ex.getMessage());
      se.initCause(ex);
      throw se;
    }
    return con;
  }

  public void releaseConnection(Connection conn)
    throws SQLException
  {
    conn.close();
  }
  
}