import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	String connectionUrlSqlServer = "jdbc:sqlserver://localhost\\sqlexpress;databaseName=StockMarketDB;integratedSecurity=true";
	
	public void DBHelper() {
		try {
			Connection connection = DriverManager.getConnection(connectionUrlSqlServer);
			System.out.println("Connected succsfuly.");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
}
