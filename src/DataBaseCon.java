import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hsqldb.Server;

public class DataBaseCon {

		public static Connection getConnection(){
			Connection connection = null;
			Statement stmt = null;
			ResultSet result = null;
	
		// making a connection
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
			
			
			if(connection!= null)
			{
				System.out.println("Connection created successfully");
			}else{
				System.out.println("Error");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
//			
//			// query from the db
		public static ResultSet getAllCandidates(){  
			Connection conn = getCoonection();
			
		try {
		        
		         
		      } catch (Exception e) {
		         e.printStackTrace(System.out);
		      }
		}
		      }

}