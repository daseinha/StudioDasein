package com.tje.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import com.tje.jdbc.*;
import com.tje.repository.*;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;

	public Object memberListservice() {
		Connection conn = JDBCConnection.getConnection();
		Object result = dao.select(conn);
		JDBCCloser.close(conn);
		
		return result;
	}
	
	public Object memberInfoservice(String id) {
		Connection conn = JDBCConnection.getConnection();
		Object result = dao.select(conn, id);
		JDBCCloser.close(conn);
		
		return result;
	}
	
}









