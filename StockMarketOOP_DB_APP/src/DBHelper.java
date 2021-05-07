import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper {

	private String connectionUrlSqlServer = "jdbc:sqlserver://localhost\\sqlexpress;databaseName=StockMarketDB;integratedSecurity=true";
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
	
	private int getMonthNumber(String monthString) {
		
		switch(monthString) {
		case "Jan": return 1;
		case "feb":return 2;	
		case "Mar":return 3;	
		case "Apr":return 4;
		case "May":return 5;
		case "Jun":return 6;
		case "July":return 7;
		case "Aug":return 8;
		case "Sep":return 9;
		case "Oct":return 10;
		case "Nov":return 11;
		case "Dec":return 12;
		default:return 1;
		}
		
	}
	
	// 0 three-names, 1- Country, 2- City, 3 date of Birth, 4-email, 5-user name, 6 - password
	public void registerNewUser(String[] userDetails) {
		try {
			Connection connection = DriverManager.getConnection(this.getConnectionString());
			
			 Statement statementToGetCityID = connection.createStatement();
				ResultSet currentCityIDResult = statementToGetCityID.executeQuery("SELECT ID FROM Cities\r\n"
						+ "WHERE CityName LIKE '"+userDetails[2]+"'");
				
			 currentCityIDResult.next();
			 int cityID = currentCityIDResult.getInt("ID");
			 
			 PreparedStatement preparedStatementUserDetails = connection.prepareStatement("EXEC dbo.uspInsertUser"
			 		+ " @FirstName =?,"
			 		+ "@MiddleName =?,"
			 		+ "@LastName=?,"
			 		+ "@Age=?,"
			 		+ "@Username=?,"
			 		+ "@EmailAddress =?,"
			 		+ "@PasswordString=?,"
			 		+ "@CityID=?,"
			 		+ "@DateOfBirth=?"); 
			 
					 
			 
			 String[] datePartsFromUserDetails = userDetails[3].split("-");
			 LocalDate today = LocalDate.now();                     
			 LocalDate birthday = LocalDate.of(Integer.parseInt(datePartsFromUserDetails[0])
					 ,this.getMonthNumber(datePartsFromUserDetails[1]),
					 Integer.parseInt(datePartsFromUserDetails[2]));
			 
			 Period p = Period.between(birthday, today);
			 
			 String[] userThreeNames = userDetails[0].split(" ");
			 preparedStatementUserDetails.setString(1, userThreeNames[0]);
			 preparedStatementUserDetails.setString(2, userThreeNames[1]);
			 preparedStatementUserDetails.setString(3, userThreeNames[2]);
			 
			 preparedStatementUserDetails.setInt(4, p.getYears());
			 
			 preparedStatementUserDetails.setString(5, userDetails[5]);
			 preparedStatementUserDetails.setString(6, userDetails[4]);
			 preparedStatementUserDetails.setString(7, userDetails[6]);
			 preparedStatementUserDetails.setInt(8, cityID);
			 preparedStatementUserDetails.setString(9, userDetails[3]);
			
			 int rowAddedUserDetails = preparedStatementUserDetails.executeUpdate();			 
			 
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
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
	
	public boolean checkLoginUser(String usernameEmail, String password) {
		try {
			Connection connection = DriverManager.getConnection(this.getConnectionString());
			
			String sqlStatement ="";
			if(usernameEmail.contains("@")) {
				sqlStatement = "SEECT ID FROM Users WHERE EmailAddress LIKE (?) AND";
			}else {
				sqlStatement = "EXEC   dbo.uspCheckLoginUserWithUsername  @Username = ?,@Password =?";
			}
			
			 PreparedStatement statementToCheckLoging = connection.prepareStatement(sqlStatement);
			 statementToCheckLoging.setString(1, usernameEmail);
			 statementToCheckLoging.setString(2, password);
			 
				ResultSet currentLoginCheckBool = statementToCheckLoging.executeQuery();
				
			 if(currentLoginCheckBool.next()) {
				 return true;
			 }
			 		 
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		
		return false;
		
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
