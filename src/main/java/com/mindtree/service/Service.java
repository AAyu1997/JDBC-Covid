package com.mindtree.service;

import java.util.ArrayList;
import java.util.Scanner;
import com.mindtree.dao.ReportDao;
import com.mindtree.dto.Corona;
import com.mindtree.exception.CityNotFoundException;
import com.mindtree.exception.StateNotFoundException;

public class Service {

	static Scanner sc = new Scanner(System.in);

	public static void addCoronaReportRecord() {

		boolean flag = true;

		do {

			System.out.println();

			System.out.print("Enter Date the day report has been done : ");
			String date = sc.nextLine();

			sc.nextLine();
			System.out.print("Enter State at which goverment conduct the report  : ");
			String state = sc.nextLine();

			sc.nextLine();
			System.out.print("Enter City at which goverment conduct the report  : ");
			String city = sc.nextLine();

			System.out.print("Number of Testing Done  : ");
			int numberOfTestingDone = sc.nextInt();

			System.out.print("Number of Positive Patient  : ");
			int numberOfPositivePatient = sc.nextInt();

			System.out.print("Number of DiedPatient  : ");
			int numberOfDiedPatient = sc.nextInt();

			Corona corona = new Corona(date, state, city, numberOfTestingDone, numberOfPositivePatient,
					numberOfDiedPatient);

			boolean flg = ReportDao.addRecord(corona);

			if (!flg)
				System.out.println("Report Added successfully");

			sc.nextLine();
			System.out.print("    U want to add more reocrds say Y/N : ");
			String strCity = sc.nextLine();

			if (strCity.equalsIgnoreCase("N"))
				flag = false;

		} while (flag);

	}

	public static void displayRecordsCityWiseWithTotalSum() throws CityNotFoundException  {

		System.out.print("Enter city Name: ");
		String city = sc.nextLine();
		
		int sum = ReportDao.getAllTheDataOfGivenCity(city);
		
		if(sum!=0) {
			
			System.out.println("Total number of Pasitive Patient in "+city+" are: " + sum);
			
		}
		
		else {
			
			throw new CityNotFoundException();
		}

	}

	public static void displayStateWiseRecords() throws StateNotFoundException {
		
		System.out.print("Enter state Name: ");
		String state = sc.nextLine();

		ArrayList<Corona> patientArrayList = ReportDao.getAllTheDataOfGivenState(state);

		if(patientArrayList!=null) {
			
			for (Corona corona : patientArrayList) {
				
				System.out.println(corona.getDate()+"  "+corona.getState()+"  "+corona.getCity()+"  "+corona.getNumberOfTestingDone()+"  "+corona.getNumberOfPositivePatient()+"  "+corona.getNumberOfDiedPatient());

			}

			
		}
		
		else {
			
			throw new StateNotFoundException();
		}


	}
	
}


