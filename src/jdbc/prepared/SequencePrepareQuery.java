package jdbc.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class SequencePrepareQuery {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con; 
		PreparedStatement  sql;  
		ResultSet rs; 	
		ArrayList <StringBuffer> queryResult = new ArrayList <StringBuffer>();
		
		try {
			con = DriverManager.getConnection("jdbc:odbc:lesson11");
			sql = con.prepareStatement("INSERT INTO employee VALUES(?,?,'1990-5-2',?)");
			
			sql.setString(1, "118");
			sql.setString(2, "ÀÏÎÂ");
			sql.setDouble(3, 5560);
			
			sql.executeUpdate();
			
		
			sql = con.prepareStatement("SELECT * FROM employee");
			rs = sql.executeQuery();
			
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

			sql.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(StringBuffer str:queryResult){
			System.out.println(str);
		}

	}
}
