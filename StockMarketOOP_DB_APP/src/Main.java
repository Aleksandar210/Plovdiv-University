import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {	
public static void main(String[] args) {
	DBHelper dbHelper = new DBHelper();
	//RegistrationFrame registerFrame = new RegistrationFrame(dbHelper);
	//LoginFrame login = new LoginFrame(dbHelper);
	//RegistrationFrame frame = new RegistrationFrame();
	
	HashMap<String,ArrayList<String>> currentTestMap = dbHelper.getCountriesWithCitiesFromDataBase();
	for(Map.Entry<String,ArrayList<String>> entry: currentTestMap.entrySet()) {
		System.out.println(entry.getKey()+System.lineSeparator());
		for(String towns:entry.getValue()) {
			System.out.println(towns);
		}
		System.out.println(System.lineSeparator());
	}
}
}