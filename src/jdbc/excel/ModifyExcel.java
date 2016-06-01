package jdbc.excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModifyExcel {
	Connection con;
	Statement sql;
	ResultSet rs;
	String SQLSentence;
	
	public ModifyExcel() {
		try {
			con = DriverManager.getConnection("jdbc:odbc:lesson12"); // 连接"products.xls"
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
			System.out.println("操作成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printTable() {
		try {
			rs = sql.executeQuery("SELECT * FROM message");       // 设置修改Excel文件中的 message表      
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
			sql.close();
			con.close();
			for (StringBuffer str : queryResult) {
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModifyExcel modifyExcel = new ModifyExcel();
		modifyExcel.setSQL("UPDATE message SET 品名 = '长虹电视' WHERE 货号 = 'c324'");
		modifyExcel.modifyRecord();
		modifyExcel.printTable();
	}
}
