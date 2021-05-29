package com.mindtree.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import com.mindtree.db.DbConnection;
import com.mindtree.dto.Corona;

public class ReportDao {

	public static boolean addRecord(Corona corona) {
		
		 boolean flag=true;
		 
         Connection conn=DbConnection.getConnection();

	        
	        try {
	            CallableStatement cs=conn.prepareCall("{ call insert_value(?,?,?,?,?,?)}");
	            cs.setString(1,corona.getState());
	            cs.setString(2,corona.getCity());
	            cs.setInt(3,corona.getNumberOfTestingDone());
	            cs.setInt(4,corona.getNumberOfPositivePatient());
	            cs.setInt(5,corona.getNumberOfDiedPatient());
	            cs.setString(6,corona.getDate());

	            
	            flag=cs.execute();
	        } 
	        catch (Exception e) {
	            
	            e.printStackTrace();
	        }
	        
	        finally {
				
	        	try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
			}
	        
	        return flag;
		
	}
	
	public static int getAllTheDataOfGivenCity(String city) {
		
		int sum=0;
		
		 boolean flag=true;
		 
         Connection conn=DbConnection.getConnection();

	        
	        try {
	            CallableStatement cs=conn.prepareCall("{ call get_city(?,?)}");

             cs.setString(1, city);
             cs.registerOutParameter(2,Types.INTEGER);
             cs.execute();
             sum=cs.getInt(2);
             
	        }
	        catch (Exception e) {
	        	
			}
	        
	        finally {
	        	
	        	try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		
		return sum;
	}
	
	
	public static ArrayList<Corona> getAllTheDataOfGivenState(String state) {
		
		String stat=null;
		
		ArrayList<Corona> patientArrayList=new ArrayList();
		
        Connection conn=DbConnection.getConnection();

        
        try {
         CallableStatement cs=conn.prepareCall("{ call get_state(?)}");
         cs.setString(1,state);
         
         ResultSet rs=cs.executeQuery();

         while(rs.next()) {
             
         	String date=rs.getString(6);
            stat=rs.getString(1);
            
            
            
             String city=rs.getString(2);
             int numberOfTestingDone=rs.getInt(3);
             int numberOfPositivePatient=rs.getInt(4);
             int numberOfDiedPatient=rs.getInt(5);
             
             Corona report=new Corona();
             
             report.setDate(date);
             report.setState(stat);
             report.setCity(city);
             report.setNumberOfTestingDone(numberOfTestingDone);
             report.setNumberOfPositivePatient(numberOfPositivePatient);
             report.setNumberOfDiedPatient(numberOfDiedPatient);
             
             patientArrayList.add(report);
                     
         }
         
     } 
     catch (Exception e) {
         
         e.printStackTrace();
     }
        
        finally {
        	
        	try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            
		
		if(state.equals(stat)) {
			
			return patientArrayList;
			
		}
		
		else {
			
			return null;
		}
		
		
	
	}
		
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	

	public static ArrayList<Corona> getAllTheDataOfGivenState(String state) {
		
		String stat=null;
		
		ArrayList<Corona> patientArrayList=new ArrayList();
		
		try {
            Connection conn=DbConnection.getConnection();
            
            String sql="select * from report where state=?";
            
            PreparedStatement ps=conn.prepareStatement(sql);
            
            ps.setString(1,state);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()) {
                
            	String date=rs.getString("date");
                stat=rs.getString("state");
                String city=rs.getString("city");
                int numberOfTestingDone=rs.getInt("numberOfTestingDone");
                int numberOfPositivePatient=rs.getInt("numberOfPositivePatient");
                int numberOfDiedPatient=rs.getInt("numberOfDiedPatient");
                
                Corona report=new Corona();
                
                report.setDate(date);
                report.setState(stat);
                report.setCity(city);
                report.setNumberOfTestingDone(numberOfTestingDone);
                report.setNumberOfPositivePatient(numberOfPositivePatient);
                report.setNumberOfDiedPatient(numberOfDiedPatient);
                
                patientArrayList.add(report);
                        
            }
            
        } 
        catch (Exception e) {
            
            e.printStackTrace();
        }
               
		
		if(state.equals(stat)) {
			
			return patientArrayList;
			
		}
		
		else {
			
			return null;
		}
		
		
	}
	
	               */
	
	
	
	
	
	/*

	public static ArrayList<Corona> getAllTheDataOfGivenCity(String city) {
		
		 String citi=null;
		
		ArrayList<Corona> patientArrayList=new ArrayList();
		
		try {
            Connection conn=DbConnection.getConnection();
            
            String sql="select numberOfPositivePatient,city from report where city=?";
            
            PreparedStatement ps=conn.prepareStatement(sql);
            
            ps.setString(1,city);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()) {
                
                int numberOfPositivePatient=rs.getInt("numberOfPositivePatient");
                citi=rs.getString("city");

                Corona report=new Corona();
                
                report.setNumberOfPositivePatient(numberOfPositivePatient);
                patientArrayList.add(report);
                        
            }
            
        } 
        catch (Exception e) {
            
            e.printStackTrace();
        }
               
		
		if(city.equals(citi)) {
			
			return patientArrayList;
			
		}
		
		else {
			
			return null;
		}
		
		
	}

	           */
	





