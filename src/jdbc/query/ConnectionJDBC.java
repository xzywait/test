package jdbc.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionJDBC {
	
	public static void main(String[] args) {
		Connection con; // ���������ݿ������
		Statement  sql;  // ����ִ�о�̬ SQL ��䲢����SQL������
		try {
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			System.out.println("�������سɹ���");
			con = DriverManager.getConnection("jdbc:odbc:lesson11");
			System.out.println("���ݿ����ӳɹ���");
			sql = con.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
