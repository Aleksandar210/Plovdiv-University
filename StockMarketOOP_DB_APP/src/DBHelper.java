import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	private String connectionUrlSqlServer;
	
	public void DBHelper() {
		/*try {
			Connection connection = DriverManager.getConnection(connectionUrlSqlServer);
			System.out.println("Connected succsfuly.");
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		*/
		
		this.setConnectionString();
	}
	
	public String getConnectionString() {
		return this.connectionUrlSqlServer;
    }
	
	private void setConnectionString() {
		this.connectionUrlSqlServer =  "jdbc:sqlserver://localhost\\sqlexpress;databaseName=StockMarketDB;integratedSecurity=true";
	}
	
}
