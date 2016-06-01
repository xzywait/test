package jdbc.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class RamdomQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con; // 建立和数据库的连接
		Statement  sql;  // 用于执行静态 SQL 语句并生成SQL处理结果
		ResultSet rs; 
		ResultSetMetaData rsmd;
		ArrayList <StringBuffer> queryResult = new ArrayList <StringBuffer>();
		try {
			con = DriverManager.getConnection("jdbc:odbc:lesson11");
			sql = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,ResultSet.CONCUR_READ_ONLY);
			rs = sql.executeQuery("SELECT * FROM employee");

			rsmd = rs.getMetaData();
			int colume = rsmd.getColumnCount();
			
			rs.last();
			int rows = rs.getRow();
			int index = (int)(Math.random()* rows + 1);
			rs.absolute(index);
			StringBuffer s_buffer = new StringBuffer("");
			for(int i=1;i<= colume;i++){
				s_buffer.append(rs.getString(i)+" ");
			}
			System.out.println(s_buffer);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}