package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCClientH2toMySQL {

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
	public void StudyPrepareStatement(Connection c) throws Exception {
		
		PreparedStatement st = c.prepareStatement("select * from board");
				
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
	
	public void StudyPrepareStatement1(Connection c) throws Exception {
			
			PreparedStatement st = c.prepareStatement("select * from member");
						
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

	public static void main(String[] args) throws Exception  {
		// 인스턴스 생성
		JDBCClientH2toMySQL cli = new JDBCClientH2toMySQL();
		//mysql 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		//db와 연결된 Connection인터페이스를 상속한 객체 생성, DriverManager.getConnection으로 Connection con 만들기
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/musthave", "musthave", "tiger");) {
			
			System.out.println("<=== StudyPrepareStatement ===>");
			cli.StudyPrepareStatement(con); // 
			System.out.println();

			System.out.println("<=== StudyPrepareStatement1 ===>");
			cli.StudyPrepareStatement1(con);
			System.out.println();
		}		
	}
}
