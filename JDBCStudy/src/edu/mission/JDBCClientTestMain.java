package edu.mission;

public class JDBCClientTestMain {

	public static void main(String[] args) throws Exception {

		JDBCDatabase jd1 = new JDBCDatabaseH2("jdbc:h2:tcp://localhost/~/musthave", "sa", "");

		jd1.StudyStatement(1);
		jd1.StudyStatement(2);
		
//		JDBCDatabase jd2 = new JDBCDatabaseMySQL();
//
//		jd2.StudyStatement(1);
//		jd2.StudyStatement(2);
		
	}

}
