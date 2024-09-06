package challengeCountriesOfTheWorld;

import java.util.Comparator;

public class SortedOnPopulationAscending implements Comparator<Country> {

	@Override
	public int compare(Country o1, Country o2) {
		
		return (int) (o1.getPopulation() - o2.getPopulation());
	}

}
