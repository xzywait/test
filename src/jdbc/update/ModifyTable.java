package jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModifyTable {
	Connection con;
	Statement sql;
	ResultSet rs;
	String SQLSentence;

	public ModifyTable() {
		try {
			con = DriverManager.getConnection("jdbc:odbc:lesson11");
			sql = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setSQL(String sqlSentence) {
		SQLSentence = sqlSentence;
	}	
	
	public void modifyRecord() {
		try {
			sql.execute(SQLSentence);
			System.out.println("�����ɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printTable() {
		try {
			rs = sql.executeQuery("SELECT * FROM employee");
			ArrayList<StringBuffer> queryResult = new ArrayList<StringBuffer>();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columeCount = rsmd.getColumnCount();

			while (rs.next()) {
				StringBuffer sbuffer = new StringBuffer();
				for (int i = 1; i <= columeCount; i++) {
					sbuffer.append(rs.getString(i) + " ");
				}
				queryResult.add(sbuffer);
			}
			rs.close();
			for (StringBuffer str : queryResult) {
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class ModifyTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModifyTable modifyTable = new ModifyTable();
		System.out.println("*****ԭʼ����*****");
		modifyTable.printTable();

		modifyTable	.setSQL("UPDATE employee SET salary = 3602 WHERE name ='����'");
		System.out.print("��������salary  ");
		modifyTable.modifyRecord();
		modifyTable.printTable();
		
		modifyTable.setSQL("INSERT INTO employee VALUES('007','����','1988-12-20','3976')");
		System.out.print("���007  ");
		modifyTable.modifyRecord();		
		modifyTable.printTable();
		
		modifyTable.setSQL("DELETE FROM employee WHERE number = '007'");
		System.out.print("ɾ��007  ");
		modifyTable.modifyRecord();		
		modifyTable.printTable();
	}
}
