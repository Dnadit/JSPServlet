package edu.mission;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class JDBCDatabase {

	Connection con;
	
	public JDBCDatabase(String driverName) throws ClassNotFoundException {
		Class.forName(driverName);
	}
	
	public abstract void StudyStatement(int type) throws Exception;
	
	void StudyStatement2() throws Exception {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select num,title,content,id from board");
		
		while(rs.next() ) {
//			System.out.println(rs.getString(1)+","+
//								rs.getString(2)+","+
//								rs.getString(3)+","+
//								rs.getString(4));

			System.out.println(rs.getString("num")+","+
								rs.getString("title")+","+
								rs.getString("content")+","+
								rs.getString("id"));
		}
		
		rs.close();
		st.close();
	}

	void StudyStatement1() {
	}
}
