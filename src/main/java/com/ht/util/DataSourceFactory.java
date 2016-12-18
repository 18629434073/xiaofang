package com.ht.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;


public class DataSourceFactory{
    private static Logger logger = Logger.getLogger(DataSourceFactory.class);
    private static DataSource datasource = null;

    public DataSourceFactory(){
    	setHibernateDialect("org.gjt.mm.mysql.Driver");
    }

    public BasicDataSource getDefaultDataSource() throws Exception{
        if(null == datasource){
            datasource = DataSources.getInstance().initialize();
        }
        int maxActive = 50;
        BasicDataSource ds = new BasicDataSource();
        if(datasource!=null){
            ds.setDriverClassName(datasource.getDriver());
            ds.setUrl(datasource.getConnection());
            ds.setUsername(datasource.getUserName());
            ds.setPassword(datasource.getPassword());
            try{
                maxActive = Integer.parseInt(datasource.getMaxActive());
            } catch (Exception e){
                maxActive = 50;
            }
        }
        ds.setMaxActive(maxActive);
        ds.setInitialSize(5);
        ds.setMaxWait(60000);
        ds.setMaxIdle(30);
        ds.setMinIdle(5);
        ds.setRemoveAbandoned(true);
        ds.setRemoveAbandonedTimeout(180);
        
        // parameter for auto reconnection
        ds.setTestWhileIdle(true);
        ds.setTestOnBorrow(false);
        ds.setTestOnReturn(false);
        ds.setValidationQuery("select 1 from ICARE_USER");
        ds.setTimeBetweenEvictionRunsMillis(180000);
        ds.setNumTestsPerEvictionRun(maxActive);
        return ds;
    }

    private void setHibernateDialect(String driver) {
        if(logger.isDebugEnabled()){
            logger.debug("Set hibernate.dialect: " + driver);
        }
        if (driver.equals("org.gjt.mm.mysql.Driver")) {
            System.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
        } else if (driver.equals("oracle.jdbc.driver.OracleDriver")) {
            System.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
        } else {
            System.setProperty("hibernate.dialect", "");
        }
    }
}
