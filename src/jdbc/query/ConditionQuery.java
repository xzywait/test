package jdbc.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class ConditionQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		Statement sql;
		ResultSet rs;
		ArrayList <StringBuffer> queryResult = null;
		try {
			con = DriverManager.getConnection("jdbc:odbc:lesson11");
			sql = con.createStatement();
			rs  = sql.executeQuery("SELECT NAME,BIRTHDAY,salary FROM employee WHERE SALARY > 3000 AND NAME LIKE '[Íõ]%'");
			System.out.println(rs.getRow());         // 0
		
			ResultSetMetaData rsmd = rs.getMetaData();
			int columeCount = rsmd.getColumnCount();
			queryResult = new ArrayList <StringBuffer>();
			while(rs.next()){                    
				StringBuffer sbuffer = new StringBuffer();
				for(int i =1;i<=columeCount;i++){
					sbuffer.append(rs.getString(i)+" ");
				}
				queryResult.add(sbuffer);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}          
		for(StringBuffer str:queryResult){
			System.out.println(str);
		}
	}

}
