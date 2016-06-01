package jdbc.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class SequenceQuery {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Connection con; 
		Statement  sql;  
		ResultSet rs; 	
		ArrayList <StringBuffer> queryResult = new ArrayList <StringBuffer>();
		
		try {
			con = DriverManager.getConnection("jdbc:odbc:lesson11");
			sql = con.createStatement();
			rs = sql.executeQuery("SELECT * FROM employee");
//			System.out.println(rs.getRow());
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int colume = rsmd.getColumnCount();
			while(rs.next()){
				StringBuffer s_buffer = new StringBuffer("");
				for(int i =1;i<= colume;i++){
					s_buffer.append(rs.getString(i)+ " ");
				}
				queryResult.add(s_buffer);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(StringBuffer str:queryResult){
			System.out.println(str);
		}
	}
}
