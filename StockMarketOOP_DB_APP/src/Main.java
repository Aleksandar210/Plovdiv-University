import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {	
public static void main(String[] args) {
	DBHelper dbHelper = new DBHelper();
	HashMap<String,ArrayList<String>> currentCountriesWithCities = dbHelper.getCountriesWithCitiesFromDataBase();
	//RegistrationFrame registerFrame = new RegistrationFrame(dbHelper);
	//LoginFrame login = new LoginFrame(dbHelper);
	RegistrationFrame frame = new RegistrationFrame(currentCountriesWithCities);	
	

	}
}
