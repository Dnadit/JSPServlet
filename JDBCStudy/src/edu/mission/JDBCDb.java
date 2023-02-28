package edu.mission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class JDBCDb {
	
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
}
