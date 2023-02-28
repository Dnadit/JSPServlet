package edu.mission;

import java.sql.DriverManager;

public class JDBCDatabaseH2 extends JDBCDatabase {
	
	public JDBCDatabaseH2(String url, String usr, String pwd) throws Exception {
		super("org.h2.Driver");
		con = DriverManager.getConnection(url, usr, pwd);
	}

	@Override
	public void StudyStatement(int type) throws Exception {

		System.out.println("StudyStatement:" + type);
		if (type == 1)	StudyStatement1();	// board
		else			StudyStatement2();	// memeber
	}
}
