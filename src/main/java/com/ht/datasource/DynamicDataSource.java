package com.ht.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{

    @Override  
    protected Object determineCurrentLookupKey() {  
    	System.out.println("datasource="+DataSourceContextHolder.getDataSourceType());
        return DataSourceContextHolder.getDataSourceType();  
    }  

}
