package com.netcore.minimum;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.netcore.bean.StatewiseVaccList;

public class DetailsProcessor {

	public static final String DIR_PATH = "..\\WebContent\\WEB-INF\\resources\\covid_vaccine_statewise.csv";

	public static int total_vacc_for_state = 0;
	public static String queryState = "";

	public DetailsProcessor() {
		// TODO Auto-generated constructor stub
		System.out.println("DetailsProcessor Constructor created");
		readCsv();
	}

	public static void main(String[] args) throws FileNotFoundException {
		String line = "";
		String splitBy = ",";
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(DIR_PATH));

			List<StatewiseVaccList> stateList = new ArrayList<>();
			String headers = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] statewiseCsv = line.split(splitBy);
				// use comma as separator
//	          System.out.println("Sno=" + employee[1] + ", Date=" + employee[2] + ", Time=" + employee[3] + ", State/UT= " + employee[4] +
//	        		  "ConfirmedIndianNational=" + employee[1] + "ConfirmedForeignNational=" + employee[1] + "Cured=" + employee[1] 
//	        				  + "Deaths=" + employee[1] + "Confirmed=" + employee[1] + "]");

				// create car object to store values
				StatewiseVaccList statewiseObj = new StatewiseVaccList();
				if (statewiseCsv.length == 18) {
					// add values from csv to car object
					statewiseObj.setUpdated_on(statewiseCsv[0]);
					statewiseObj.setState(statewiseCsv[1]);
					
					if (statewiseCsv[2].length() == 0)statewiseObj.setTotal_doses_administered(0);
					else statewiseObj.setTotal_doses_administered(Double.valueOf(statewiseCsv[2]).intValue()); // convert to
																											// int
					if (statewiseCsv[3].length() == 0)statewiseObj.setTotal_sessions_conducted(0);
					else statewiseObj.setTotal_sessions_conducted(Double.valueOf(statewiseCsv[3]).intValue());
					
					if (statewiseCsv[4].length() == 0)statewiseObj.setTotal_sites(0);
					else statewiseObj.setTotal_sites(Double.valueOf(statewiseCsv[4]).intValue());
					
					if (statewiseCsv[5].length() == 0)statewiseObj.setFirst_dose_administered(0);
					else statewiseObj.setFirst_dose_administered(Double.valueOf(statewiseCsv[5]).intValue());
					
					if (statewiseCsv[6].length() == 0)statewiseObj.setSecond_dose_administered(0);
					else statewiseObj.setSecond_dose_administered(Double.valueOf(statewiseCsv[6]).intValue());
					
					if (statewiseCsv[7].length() == 0)statewiseObj.setMale_individuals_vaccinated(0);
					else statewiseObj.setMale_individuals_vaccinated(Double.valueOf(statewiseCsv[7]).intValue());
					
					if (statewiseCsv[8].length() == 0)statewiseObj.setFemale_individuals_vaccinated(0);
					else statewiseObj.setFemale_individuals_vaccinated(Double.valueOf(statewiseCsv[8]).intValue());
					
					if (statewiseCsv[9].length() == 0)statewiseObj.setTransgender_individuals_vaccinated(0);
					else statewiseObj.setTransgender_individuals_vaccinated(Double.valueOf(statewiseCsv[9]).intValue());
					
					if (statewiseCsv[10].length() == 0)statewiseObj.setTotal_covaxin_administered(0);
					else statewiseObj.setTotal_covaxin_administered(Double.valueOf(statewiseCsv[10]).intValue());
					
					if (statewiseCsv[11].length() == 0)statewiseObj.setTotal_covishield_administered(0);
					else statewiseObj.setTotal_covishield_administered(Double.valueOf(statewiseCsv[11]).intValue());
					
					if (statewiseCsv[12].length() == 0)statewiseObj.setTotal_sputnik_v_administered(0);
					else statewiseObj.setTotal_sputnik_v_administered(Double.valueOf(statewiseCsv[12]).intValue());
					
					if (statewiseCsv[13].length() == 0)statewiseObj.setAefi(0);
					else statewiseObj.setAefi(Double.valueOf(statewiseCsv[13]).intValue());
					
					if (statewiseCsv[14].length() == 0)statewiseObj.setBelow_45_years(0);
					else statewiseObj.setBelow_45_years(Double.valueOf(statewiseCsv[14]).intValue());
					
					if (statewiseCsv[15].length() == 0)statewiseObj.setBetween_45_60_years(0);
					else statewiseObj.setBetween_45_60_years(Double.valueOf(statewiseCsv[15]).intValue());
					
					if (statewiseCsv[16].length() == 0)statewiseObj.setAbove_60_years(0);
					else statewiseObj.setAbove_60_years(Double.valueOf(statewiseCsv[16]).intValue());
					
					if (statewiseCsv[17].length() == 0)statewiseObj.setTotal_individuals_vaccinated(0);
					else statewiseObj.setTotal_individuals_vaccinated(Double.valueOf(statewiseCsv[17]).intValue());

					// adding stateList objects to a list
					stateList.add(statewiseObj);
				}
			}
			//String queryState = "Assam";
			String queryState = "Bihar";
			total_vacc_for_state = getStateTotal_individuals_vaccinated(stateList, queryState);
			System.out.println(total_vacc_for_state);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private static int getStateTotal_individuals_vaccinated(List<StatewiseVaccList> stateList, String queryState) {
		// TODO Auto-generated method stub
		int result = 0;
		ArrayList<Integer> total_vacc_list_per_state = new ArrayList<>();
		for (StatewiseVaccList statewiseVaccList : stateList) {
			if (statewiseVaccList.getState().equals(queryState)) {
				total_vacc_list_per_state.add(statewiseVaccList.getTotal_individuals_vaccinated());
				// result = statewiseVaccList.getTotal_individuals_vaccinated();
			}
		}
		// System.out.println(total_vacc_list_per_state);
		return total_vacc_list_per_state.get(0);
	}

	public static void readCsv() {
		String line = "";
		String splitBy = ",";
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(DIR_PATH));

			List<StatewiseVaccList> stateList = new ArrayList<>();
			String headers = br.readLine();
			while ((line = br.readLine()) != null) {
				String[] statewiseCsv = line.split(splitBy);
				// use comma as separator
//	          System.out.println("Sno=" + employee[1] + ", Date=" + employee[2] + ", Time=" + employee[3] + ", State/UT= " + employee[4] +
//	        		  "ConfirmedIndianNational=" + employee[1] + "ConfirmedForeignNational=" + employee[1] + "Cured=" + employee[1] 
//	        				  + "Deaths=" + employee[1] + "Confirmed=" + employee[1] + "]");

				// create car object to store values
				StatewiseVaccList statewiseObj = new StatewiseVaccList();
				if (statewiseCsv.length == 18) {
					// add values from csv to car object
					statewiseObj.setUpdated_on(statewiseCsv[0]);
					statewiseObj.setState(statewiseCsv[1]);

					if (statewiseCsv[2].length() == 0)
						statewiseObj.setTotal_doses_administered(0);
					else
						statewiseObj.setTotal_doses_administered(Double.valueOf(statewiseCsv[2]).intValue()); // convert
																												// to
																												// int
					if (statewiseCsv[3].length() == 0)
						statewiseObj.setTotal_sessions_conducted(0);
					else
						statewiseObj.setTotal_sessions_conducted(Double.valueOf(statewiseCsv[3]).intValue());

					if (statewiseCsv[4].length() == 0)
						statewiseObj.setTotal_sites(0);
					else
						statewiseObj.setTotal_sites(Double.valueOf(statewiseCsv[4]).intValue());

					if (statewiseCsv[5].length() == 0)
						statewiseObj.setFirst_dose_administered(0);
					else
						statewiseObj.setFirst_dose_administered(Double.valueOf(statewiseCsv[5]).intValue());

					if (statewiseCsv[6].length() == 0)
						statewiseObj.setSecond_dose_administered(0);
					else
						statewiseObj.setSecond_dose_administered(Double.valueOf(statewiseCsv[6]).intValue());

					if (statewiseCsv[7].length() == 0)
						statewiseObj.setMale_individuals_vaccinated(0);
					else
						statewiseObj.setMale_individuals_vaccinated(Double.valueOf(statewiseCsv[7]).intValue());

					if (statewiseCsv[8].length() == 0)
						statewiseObj.setFemale_individuals_vaccinated(0);
					else
						statewiseObj.setFemale_individuals_vaccinated(Double.valueOf(statewiseCsv[8]).intValue());

					if (statewiseCsv[9].length() == 0)
						statewiseObj.setTransgender_individuals_vaccinated(0);
					else
						statewiseObj.setTransgender_individuals_vaccinated(Double.valueOf(statewiseCsv[9]).intValue());

					if (statewiseCsv[10].length() == 0)
						statewiseObj.setTotal_covaxin_administered(0);
					else
						statewiseObj.setTotal_covaxin_administered(Double.valueOf(statewiseCsv[10]).intValue());

					if (statewiseCsv[11].length() == 0)
						statewiseObj.setTotal_covishield_administered(0);
					else
						statewiseObj.setTotal_covishield_administered(Double.valueOf(statewiseCsv[11]).intValue());

					if (statewiseCsv[12].length() == 0)
						statewiseObj.setTotal_sputnik_v_administered(0);
					else
						statewiseObj.setTotal_sputnik_v_administered(Double.valueOf(statewiseCsv[12]).intValue());

					if (statewiseCsv[13].length() == 0)
						statewiseObj.setAefi(0);
					else
						statewiseObj.setAefi(Double.valueOf(statewiseCsv[13]).intValue());

					if (statewiseCsv[14].length() == 0)
						statewiseObj.setBelow_45_years(0);
					else
						statewiseObj.setBelow_45_years(Double.valueOf(statewiseCsv[14]).intValue());

					if (statewiseCsv[15].length() == 0)
						statewiseObj.setBetween_45_60_years(0);
					else
						statewiseObj.setBetween_45_60_years(Double.valueOf(statewiseCsv[15]).intValue());

					if (statewiseCsv[16].length() == 0)
						statewiseObj.setAbove_60_years(0);
					else
						statewiseObj.setAbove_60_years(Double.valueOf(statewiseCsv[16]).intValue());

					if (statewiseCsv[17].length() == 0)
						statewiseObj.setTotal_individuals_vaccinated(0);
					else
						statewiseObj.setTotal_individuals_vaccinated(Double.valueOf(statewiseCsv[17]).intValue());

					// adding stateList objects to a list
					stateList.add(statewiseObj);
				}
			}
//			String queryState = "Assam";
			String queryState = "Bihar";
			total_vacc_for_state = getStateTotal_individuals_vaccinated(stateList, queryState);
			System.out.println(total_vacc_for_state);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
