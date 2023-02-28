package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCClientMySQL2 {

	public int printColumnName(ResultSet rs) throws Exception {
		ResultSetMetaData meta = rs.getMetaData();
		int count = meta.getColumnCount();
		
		StringBuilder sb = new StringBuilder("#");
		for (int i = 1 ; i <= count ; i++) {
			sb.append("," + meta.getColumnName(i));
		}
		System.out.println(sb);
		System.out.println("-".repeat(sb.length()));
		
		return count;
	}
	// 변수없이 sql문 날리고 끝낼때
	public void StudyStatement(Connection con) throws Exception {

		Statement st = con.createStatement(); // sql 질의를 위한 객체 생성
		ResultSet rs = st.executeQuery("select * from country limit 10"); // sql 질의 레코드 10개만

		int colCount = printColumnName(rs); // 질의 결과 출력
		int rowCount = 1;
		while(rs.next()) {
			for(int i = 1 ; i <= colCount ; i++) {
				if (i == 1)	System.out.print((rowCount++) + ",");
				else		System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
	// 뒤에 parameter가 들어가야 할 때 (where절이 들어갈 때)
	public void StudyPrepareStatement(Connection con) throws Exception {
		
		PreparedStatement st = con.prepareStatement("select * from country where code=?");

		st.setString(1, "KOR"); // ""를 찍어서 넣어줌.
		ResultSet rs = st.executeQuery();
		
		int colCount = printColumnName(rs);
		int rowCount = 1;
		while(rs.next()) {
			for(int i = 1 ; i <= colCount ; i++) {
				if (i == 1)	System.out.print((rowCount++) + ",");
				else		System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
	
	public void StudyStatement1(Connection con) throws Exception {
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select count(*) as 'Count' from countrylanguage where language = 'English'");
		
		int colCount = printColumnName(rs);
		int rowCount = 1;
		while(rs.next()) {
			for(int i = 1; i <= colCount; i++) {
				if (i == 1) System.out.print((rowCount++) + ",");
				else 		System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
	
	public void StudyStatement2(Connection con) throws Exception {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select CountryCode, language from countrylanguage where CountryCode = 'KOR'");
			
			int colCount = printColumnName(rs);
			int rowCount = 1;
			while(rs.next()) {
				for(int i = 1; i <= colCount; i++) {
					if (i == 1) System.out.print((rowCount++) + ",");
					else 		System.out.print(",");
					System.out.print(rs.getString(i));
				}
				System.out.println();
			}
			rs.close();
			st.close();
		}
	
	public void StudyStatement3(Connection con) throws Exception {
				
		PreparedStatement st = con.prepareStatement("select Region, Name "
													+ "from countrylanguage, country "
													+ "where countrylanguage.CountryCode=country.Code && language =? && isOfficial =?");

		st.setString(1, "English");
		st.setString(2, "T");
		ResultSet rs = st.executeQuery();
		
		int colCount = printColumnName(rs);
		int rowCount = 1;
		while(rs.next()) {
			for(int i = 1; i <= colCount; i++) {
				if (i == 1) System.out.print((rowCount++) + ",");
				else 		System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
	
	public void StudyStatement4(Connection con) throws Exception {
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select Region, count(*) from countrylanguage, country where countrylanguage.CountryCode=country.Code && language = 'English' group by Region");
		
		int colCount = printColumnName(rs);
		int rowCount = 1;
		while(rs.next()) {
			for(int i = 1; i <= colCount; i++) {
				if (i == 1) System.out.print((rowCount++) + ",");
				else 		System.out.print(",");
				System.out.print(rs.getString(i));
			}
			System.out.println();
		}
		rs.close();
		st.close();
	}
	
	public static void main(String[] args) throws Exception  {
		// 인스턴스 생성
		JDBCClientMySQL2 cli = new JDBCClientMySQL2();
		//mysql 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		//db와 연결된 Connection인터페이스를 상속한 객체 생성, DriverManager.getConnection으로 Connection con 만들기
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "musthave", "tiger");) {
			
			System.out.println("<=== StudyStatement ===>");
			cli.StudyStatement(con); // 
			System.out.println();

			System.out.println("<=== StudyPrepareStatement ===>");
			cli.StudyPrepareStatement(con);
			System.out.println();
			
			System.out.println("<=== StudyStatement1 ===>");
			cli.StudyStatement1(con); 
			System.out.println();
			
			System.out.println("<=== StudyStatement2 ===>");
			cli.StudyStatement2(con); 
			System.out.println();
			
			System.out.println("<=== StudyStatement3 ===>");
			cli.StudyStatement3(con); 
			System.out.println();
			
			System.out.println("<=== StudyStatement4 ===>");
			cli.StudyStatement4(con); 
			System.out.println();
		}		
	}
}
