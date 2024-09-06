/**
 * 
 */
package challengeCountriesOfTheWorld;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class StarterApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Read CSV and return details

		ArrayList<Country> countryDetails = readInCountriesFileAndMakeNeededChanges();

		// Print Country Details

		//printAllCountryDetailsToConsole(countryDetails);
		
		String searchKey = "Europe";
		
		findCountriesByRegionSearchKey(countryDetails, searchKey);
		
		// Show countries sorted on population on ascending order
		
		Collections.sort(countryDetails, new SortedOnPopulationAscending());
		
		printOnPopulationInAscendingOrder(countryDetails);
		
		Collections.sort(countryDetails, new SortedOnAlphabeticalOrder());
		
		printOnPopulationInAlphabeticalOrder(countryDetails);
	}

	
	/**
	 * This method prints country details - in alphabetical order
	 * 
	 * @param countryDetails
	 */
	public static void printOnPopulationInAlphabeticalOrder(ArrayList<Country> countryDetails) {
		System.out.println("Countries by population ascending");
		for (Country c : countryDetails) {
			System.out.println(c.getName());
		}
	}
	
	/**
	 * This method prints country details - in ascending order
	 * 
	 * @param countryDetails
	 */
	public static void printOnPopulationInAscendingOrder(ArrayList<Country> countryDetails) {
		System.out.println("Countries by population ascending");
		for (Country c : countryDetails) {
			System.out.println(c.getPopulation() + "\t\t\t" + c.getName());
		}
	}

	/**
	 * This method outputs to console all countries who's region matches the searchKey
	 * 
	 * @param countryDetails
	 * @param searchKey
	 */
	public static void findCountriesByRegionSearchKey(ArrayList<Country> countryDetails, String searchKey) {
		for (Country c : countryDetails) {
			if (c.getRegion().contains(searchKey)) {
				System.out.println(searchKey + " - " + c.getName());
			}
		}
	}

	/**
	 * This method prints all country details to console
	 * 
	 * @param countryDetails
	 */
	public static void printAllCountryDetailsToConsole(ArrayList<Country> countryDetails) {
		for (Country c : countryDetails) {

			System.out.println("Name             : " + c.getName());
			System.out.println("Region           : " + c.getRegion());
			System.out.println("Population       : " + c.getPopulation());
			System.out.println("Area             : " + c.getArea());
			System.out.printf("Density          : %.2f\n", c.getDensity());
			System.out.println();
		}
	}

	/**
	 * This method reads a csv file and creates an OOP country for each country -
	 * including name, region, population and area. It uses population and area to
	 * calculate the density of each country
	 */
	public static ArrayList<Country> readInCountriesFileAndMakeNeededChanges() {
		File file = new File("countries-1.csv");
		ArrayList<Country> countryDetails = new ArrayList<Country>();
		String line;

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			// Read first line of csv
			line = br.readLine();

			// System.out.println(line);

			line = br.readLine();

			while (line != null) {

				String[] details = line.split(",");

				String country;

				if (details[1].contains("EASTERN EUROPE") || details[1].contains("WESTERN EUROPE")) {
					details[1] = "Europe";
				}

				if (details[1].contains("SUB-SAHARAN AFRICA") || details[1].contains("NORTHERN AFRICA")) {
					details[1] = "Africa";
				}

				details[1] = details[1].substring(0, 1).toUpperCase() + details[1].substring(1).toLowerCase();

				Integer population = Integer.parseInt(details[2]);
				Integer area = Integer.parseInt(details[3]);

				countryDetails.add(new Country(details[0], details[1], population, area));

				line = br.readLine();

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return countryDetails;
	}

}
