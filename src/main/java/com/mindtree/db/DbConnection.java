package com.mindtree.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection implements DbProperties {
	
	static Connection conn;

    private DbConnection() {
        
        
    }
    
    public static Connection getConnection() {
        
        if(conn==null) {
            
            try {
                
                Class.forName(DRIVERNAME);
                
                conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            } 
            catch (Exception e) {
            }
        }
        
        return conn;
    }
}



