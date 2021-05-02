import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper {

	private String connectionUrlSqlServer = "jdbc:sqlserver://localhost\\sqlexpress;databaseName=StockMarketDB;integratedSecurity=true";;
	private HashMap<String,ArrayList<String>> currentCountriesWithCities;
	public DBHelper() {
		/*try {
			Connection connection = DriverManager.getConnection(connectionUrlSqlServer);
			System.out.println("Connected succsfuly.");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		*/
		 currentCountriesWithCities = this.getCountriesWithCitiesFromDataBase();
	}
	
	// 0 three-names, 1- Country, 2- City, 3 date of Birth, 4-email, 5-user name, 6 - password
	public void registerNewUser(String[] suerDetails) {
		
	}
	
	private HashMap<String,ArrayList<String>> getCountriesWithCitiesFromDataBase() {
		HashMap<String,ArrayList<String>> countriesWithCities = null;
		try {
			Connection connection = DriverManager.getConnection(this.getConnectionString());
			
			Statement statementToGetCountries = connection.createStatement();
			ResultSet currentCountriesWithCities = statementToGetCountries.executeQuery("SELECT CountryName, CityName FROM Countries\r\n"
					+ "JOIN Cities ON Countries.ID = Cities.CountryID\r\n"
					+ "ORDER BY CountryName ASC,CityName ASC");
			
			countriesWithCities = new HashMap<String,ArrayList<String>>();
			
			while(currentCountriesWithCities.next()) {
				String countryName = currentCountriesWithCities.getString("CountryName");
				String cityName = currentCountriesWithCities.getString("CityName");
				if(!(countriesWithCities.containsKey(countryName))) {	
					countriesWithCities.put(countryName, new ArrayList<String>());
					countriesWithCities.get(countryName).add(cityName);
				}else {
					countriesWithCities.get(countryName).add(cityName);
				}
			}			
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return countriesWithCities;
	}
	
	public String getConnectionString() {
		return this.connectionUrlSqlServer;
    }
	
	private void setConnectionString() {
		this.connectionUrlSqlServer =  "jdbc:sqlserver://localhost\\sqlexpress;databaseName=StockMarketDB;integratedSecurity=true";
	}
	
	public HashMap<String,ArrayList<String>> getCountriesWithCities(){
		return this.currentCountriesWithCities;
	}
	
}
