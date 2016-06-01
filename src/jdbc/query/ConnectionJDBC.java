package jdbc.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionJDBC {
	
	public static void main(String[] args) {
		Connection con; // 建立和数据库的连接
		Statement  sql;  // 用于执行静态 SQL 语句并生成SQL处理结果
		try {
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			System.out.println("驱动加载成功！");
			con = DriverManager.getConnection("jdbc:odbc:lesson11");
			System.out.println("数据库连接成功！");
			sql = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
