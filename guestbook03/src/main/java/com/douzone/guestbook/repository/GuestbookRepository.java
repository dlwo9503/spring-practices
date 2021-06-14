package com.douzone.guestbook.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.douzone.guestbook.vo.GuestbookVo;

@Repository
public class GuestbookRepository {
	public Boolean insert(GuestbookVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection(); // url, 아이디, 비번

			String sql = "insert into guestbook values (null, ?, ?, ?, now())";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName()); // 바인딩
			pstmt.setString(2, vo.getPassword()); // 바인딩
			pstmt.setString(3, vo.getMessage()); // 바인딩

			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Boolean delete(GuestbookVo vo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection(); // url, 아이디, 비번

			String sql = "delete from guestbook where no = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getNo()); // 바인딩
//			pstmt.setString(1, vo.getPassword()); // 바인딩

			int count = pstmt.executeUpdate();
			result = count == 1;

		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<GuestbookVo> findAll() {
		List<GuestbookVo> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			String sql = "select no, name, reg_date, message from guestbook";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String regDate = rs.getString(3);
				String message = rs.getString(4);
//
				GuestbookVo vo = new GuestbookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setRegDate(regDate);
				vo.setMessage(message);
				result.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public GuestbookVo findAll2(Long no2) {
		GuestbookVo vo = new GuestbookVo();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			String sql = "select no, password from guestbook where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no2);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				Long no = rs.getLong(1);
				String password = rs.getString(2);
//
				vo.setNo(no);
				vo.setPassword(password);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mysql://172.20.10.2:3307/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb"); // url, 아이디, 비번

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		}
		return conn;
	}
}
