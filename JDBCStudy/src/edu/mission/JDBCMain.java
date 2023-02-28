package edu.mission;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMain extends JDBCMySQL {

	public static void main(String[] args) throws Exception {
		// 인스턴스 생성
		JDBCDb cli = new JDBCDb();				
		//mysql 드라이버 로드
		Class.forName(driver);
		//db와 연결된 Connection인터페이스를 상속한 객체 생성, DriverManager.getConnection으로 Connection con 만들기
		try (Connection con = DriverManager.getConnection(url, id, pw);) {
			
			System.out.println("<=== StudyPrepareStatement ===>");
			cli.StudyPrepareStatement(con);
			System.out.println();

			System.out.println("<=== StudyPrepareStatement1 ===>");
			cli.StudyPrepareStatement1(con);
			System.out.println();
		}
		
	}
}
				

