package com.ht.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

public final class JDBCDriverManager
{
  private static final Vector drivers = new Vector();

  private static Logger logger = Logger.getLogger(JDBCDriverManager.class);

  private static boolean isRegistered(Driver driver)
  {
    int version = driver.getMajorVersion() * 100 + driver.getMinorVersion();
    Iterator it = drivers.iterator();
    while (it.hasNext())
    {
      Driver d = (Driver)it.next();
      int check = d.getMajorVersion() * 100 + d.getMinorVersion();
      if ((check == version) && (d.getClass().getName().equals(driver.getClass().getName())))
      {
        return true;
      }
    }
    return false;
  }

  public static void register(String driverClass, ClassLoader cl)
    throws Exception
  {
    logger.debug(new Object[] { "register", "Register Driver: ", driverClass });
    if (cl == null)
    {
      cl = Thread.currentThread().getContextClassLoader();
    }
    if (driverClass == null)
    {
      throw new Exception();
    }
    Driver driver = (Driver)Class.forName(driverClass, true, cl).newInstance();
    if (isRegistered(driver))
      return;
    drivers.add(driver);
    logger.debug(new Object[] { "register", "Driver registered: ", driverClass });
  }

  public static void deregister(Driver driver)
  {
    if (driver == null)
    {
      return;
    }
    try
    {
      Iterator it = drivers.iterator();
      while (it.hasNext())
      {
        Driver di = (Driver)it.next();
        if (di == driver)
        {
          it.remove();
          break;
        }
      }
    }
    catch (Exception e)
    {
      logger.error(new Object[] { e });
    }
  }

  public static Connection getConnection(String url, String id, String pwd, ClassLoader cl)
    throws Exception
  {
    logger.debug(new Object[] { "getConnection", "Get Connection to: ", url, " using ", id });
    if (url == null)
    {
      throw new Exception("The url cannot be null");
    }
    if (cl == null)
    {
      cl = Thread.currentThread().getContextClassLoader();
    }
    Properties info = new Properties();
    if (id != null)
    {
      info.put("user", id);
    }
    if (pwd != null)
    {
      info.put("password", pwd);
    }

    Exception reason = null;
    Iterator it = drivers.iterator();
    while (it.hasNext())
    {
      Driver di = (Driver)it.next();
      try
      {
        logger.debug(new Object[] { "getConnection", "Try: ", di });
        Connection result = di.connect(url, info);
        if (result != null)
        {
          return result;
        }
      }
      catch (Exception ex)
      {
        if (reason == null)
        {
          reason = ex;
        }
      }
      catch (Error err)
      {
        throw err;
      }

    }

    if (reason != null)
    {
      throw reason;
    }
    return DriverManager.getConnection(url, info);
  }
}