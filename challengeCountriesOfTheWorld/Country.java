/**
 * 
 */
package challengeCountriesOfTheWorld;

/**
 * @author - Daithi O hAnluain - 15621049
 */
public class Country {
	
	// Instance Variable
	
	private String name;
	private String region;
	private long population;
	private long area;
	private double density; // Constructor
	
	
	
	/**
	 * @param name
	 * @param region
	 * @param population
	 * @param area
	 */
	public Country(String name, String region, long population, long area) {
		this.name = name;
		this.region = region;
		this.population = population;
		this.area = area;
		this.setDensity((double) population / area);
	}
	// Getters and Setters
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the population
	 */
	public long getPopulation() {
		return population;
	}
	/**
	 * @param population the population to set
	 */
	public void setPopulation(long population) {
		this.population = population;
	}
	/**
	 * @return the area
	 */
	public long getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(long area) {
		this.area = area;
	}
	/**
	 * @return the density
	 */
	public double getDensity() {
		return density;
	}
	/**
	 * @param density the density to set
	 */
	public void setDensity(double density) {
		this.density = density;
	}
	
	// toString Method

	@Override
	public String toString() {
		return "Country [name=" + name + ", region=" + region + ", population=" + population + ", area=" + area
				+ ", density=" + density + "]";
	}
	
	
	
	
	
	
	

}
