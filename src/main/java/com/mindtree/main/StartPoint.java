package com.mindtree.main;

import java.util.Scanner;

import com.mindtree.exception.CityNotFoundException;
import com.mindtree.exception.StateNotFoundException;
import com.mindtree.service.Service;

public class StartPoint {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		byte isValidOption=0;
		
		do {
			
			displayMenu();
			
			isValidOption=sc.nextByte();
			
			switch(isValidOption) {
			
			  case 1:Service.addCoronaReportRecord(); 
				     break;
		      
			  case 2:try {
					   Service.displayRecordsCityWiseWithTotalSum();
				    } 
			        catch (CityNotFoundException e) {
					     e.printStackTrace();
				    }
       			    break;  
				    
			  case 3: try {
					   Service.displayStateWiseRecords();
				     } 
			         catch (StateNotFoundException e) {
					     e.printStackTrace();
				     }
				     break;
		        
			}
			
		}while(isValidOption<4&&isValidOption>0);
		
	}
	

	private static void displayMenu() {
		System.out.println("===========================================================================================================");
		
		System.out.println("1: Add record into Dtatabase");
		System.out.println("2: Display all records for a specific city and sum of numberOfTestingDone , numberOfPositivePatient numberOfDiedPatient");
		System.out.println("3: Display State Wise report");
		System.out.println("4: Exit");
			
		System.out.println("\nEnter your choice between 1 t0 4: ");
		System.out.println("=============================================================================================================");
		
		
	}

}
