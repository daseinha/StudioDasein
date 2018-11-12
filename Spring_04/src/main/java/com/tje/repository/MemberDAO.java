package com.tje.repository;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

import com.tje.jdbc.JDBCCloser;
import com.tje.model.*;

@Repository
public class MemberDAO {
	
	public Member getModelObject(ResultSet rs) throws SQLException {
		Member result = new Member();
		
		result.setId(rs.getString(1));
		result.setPw(rs.getString(2));
		result.setName(rs.getString(3));
		
		return result;
	}
	
	public ArrayList<Member> select(Connection conn) {
		ArrayList<Member> result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from member";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<>();
			while( rs.next() ) {
				Member obj = getModelObject(rs);
				result.add(obj);
			}
			
		} catch (SQLException e) {
			result = null;
			e.printStackTrace();
		}
		
		JDBCCloser.close(rs);
		JDBCCloser.close(pstmt);
		
		return result;
	}
	
	public Member select(Connection conn, String id) {
		Member result = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select * from member where id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();			
			
			if( rs.next() )
				result = getModelObject(rs);		
			
		} catch (SQLException e) {
			result = null;
			e.printStackTrace();
		}
		
		JDBCCloser.close(rs);
		JDBCCloser.close(pstmt);
		
		return result;
	}
}














