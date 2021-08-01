package com.pms.pmsapp.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;

public class DBCPDataSource {

	@Value("${spring.datasource.url}")
    private String url;

	private static String URL_STATIC;

    @Value("${spring.datasource.url}")
    public void setUrl(String url){
    	DBCPDataSource.URL_STATIC = url;
    }
    
    @Value("${spring.datasource.username}")
    private String username;

    private static String USERNAME_STATIC;

    @Value("${spring.datasource.username}")
    public void setUsername(String username){
    	DBCPDataSource.USERNAME_STATIC = username;
    }
    
    @Value("${spring.datasource.password}")
    private String password;

    private static String PASSWORD_STATIC;

    @Value("${spring.datasource.password}")
    public void setPassword(String password){
    	DBCPDataSource.PASSWORD_STATIC = password;
    }

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        ds.setUsername("PMS_APP");
        ds.setPassword("password");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }
    
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
    private DBCPDataSource(){ }
}