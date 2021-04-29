import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {	
public static void main(String[] args) {
	String connectionUrlSqlServer = "jdbc:sqlserver://localhost\\sqlexpress;databaseName=StockMarketDB;integratedSecurity=true";
	
	try {
		Connection connection = DriverManager.getConnection(connectionUrlSqlServer);
		System.out.println("Connected succsfuly.");
	}catch(SQLException e){
		System.out.println(e.getMessage());
	}
}
}