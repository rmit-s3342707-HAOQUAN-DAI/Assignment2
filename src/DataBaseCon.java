import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.hsqldb.Server;

/** 
* DataBase connections/create table/readdata//
* 
* @author HAOQUAN DAI
* 
* @version 1.0 
*/ 
public class DataBaseCon {

	static ArrayList<String[]> lineList = new ArrayList<>();
	private static Connection con;
	private static boolean hasAthleteData = false;
	private static boolean hasResultData = false;
	
		public static ResultSet  getData() throws SQLException, ClassNotFoundException{
			getConnection();
			
			Statement state = con.createStatement();
			ResultSet res = state.executeQuery(sql);
			
			return res;
		}
		
	
		// making a connection
		private static void getConnection() throws ClassNotFoundException, SQLException{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:ozlympicAthletes.db");
			initaliseAthleteTable();
		}
		
		private static void initaliseAthleteTable()throws SQLException{
			if(!hasAthleteData){
				hasAthleteData = true;
				Statement state = con.createStatement();
				ResultSet res = state.executeQuery("SELECT name From sqlite_master WHERE type='table' AND name='athlete'");
				
				if(res.next()){
					System.out.println("initialize data");
					Statement state2 = con.createStatement();
					state2.execute()
					readTXTDataTB();
				}
				
				
			}
			
		}
		
		public static void readTXTDataTB() throws SQLException, IOException{
			System.out.println("running method");
			con.prepareStatement("DELETE FROM athlete").execute();
			
			try{
				BufferedReader br = new BufferedReader(new FileReader("participants.txt"));
				String line;
				while ((line = br.readLine()) !=null){
					String a[] = line.split(",");
					//con.prepareStatement(INSERT INTO)
				}
				br.close();
			}catch(FileNotFoundException e){
				System.out.println("reading error");
				e.printStackTrace();
			}catch(IOException e){
				System.out.println("error on initialize database");
				e.printStackTrace();
			}
			
			
			
		}
		
		private static void readDBToArrayList() throws SQLException, ClassNotFoundException{
			ResultSet rs = getData();
			while(rs.next()){
				String[] a = new String[5];
				a[0] = rs.getString("aID");
				a[1] = rs.getString("aType");
				a[2] = rs.getString("aName");
				a[3] = rs.getString("aAge");
				a[4] = rs.getString("aState");
				
				lineList.add(a);
			}
		}
		
		public static ArrayList<String[]> getLineList()throws SQLException, ClassNotFoundException{
			lineList.clear();
			readDBToArrayList();
			return lineList;
		}
		
		

}