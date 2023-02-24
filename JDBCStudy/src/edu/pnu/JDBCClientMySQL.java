package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCClientMySQL {

	public static void main(String[] args) throws Exception {
		//MySQL 접속을 위한 JDBC 드라이버 로드 << MySQL에 접속할 수 있는 코드를 담고 있는 라이브러리(api)
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//<연결>MySQL Database 연결 객체 생성
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "musthave", "tiger");
		
		//질의를 위한 객체 생성
		Statement st = con.createStatement(); // Statement 인터페이스를 상속받은 객체
		
		//<SQL 질의>
		ResultSet rs = st.executeQuery("select Name,Continent,Population,HeadOfState from country");
		
		//<질의 결과 Parsing>(데이터베이스에서 커서프로세싱CursorProcessing이라고 통칭함.) 커서가 맨처음에는 빈공간을 가르키고 있음.
		while(rs.next()) { //다음 결과 레코드로 이동
			
			for(int i = 1; i <= 4; i++) {
				if (i != 1) System.out.print(",");
				System.out.print(rs.getString(i)); // getInt, getDate 등등 메서드가 다 있음.
			}
			System.out.println();
		}
		
		// 생성된 객체 연결을 모두 해제
		rs.close();
		st.close();
		con.close();
	}

}
