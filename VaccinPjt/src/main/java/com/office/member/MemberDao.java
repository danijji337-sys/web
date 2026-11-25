package com.office.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import com.office.DataBaseInfo;

public class MemberDao implements DataBaseInfo{
	
	public boolean isMember(String admin_id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "select "
					+      "count(*) cnt"
					+    "from"
					+ 	   "tbl_admin"
					+    "where"
					+ 	   "admin_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, admin_id);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				result = rs.getInt("cnt");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (rs != null) rs.close();
				
				if (pstmt != null) pstmt.close();
				
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
		}
		
		return result > 0 ? true : false;
	}

	public int insertNewMember(MemberDto memberDto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "insert into "
						+ "tbl_admin(admin_id, admin_pw, admin_mail, admin_phone) "
						+ "values(?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberDto.getAdmin_id());
			pstmt.setString(2, memberDto.getAdmin_pw());
			pstmt.setString(3, memberDto.getAdmin_mail());
			pstmt.setString(4, memberDto.getAdmin_phone());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				
				if (pstmt != null) pstmt.close();
				
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
		}
		
		return result; // -1	0	1
	}

	public MemberDto selectMemberByAdminId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberDto> memberDtos = new Vector<MemberDto>();
		
		try {
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			String sql = "select "
					+      "* "
					+    "from "
					+ 	   "tbl_admin "
					+    "where "
					+ 	   "admin_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int admin_no = rs.getInt("admin_no");
				String admin_id = rs.getString("admin_id");
				String admin_pw = rs.getString("admin_pw");
				String admin_mail = rs.getString("admin_mail");
				String admin_phone = rs.getString("admin_phone");
				String admin_reg_date = rs.getString("admin_reg_date");
				String admin_mod_date = rs.getString("admin_mod_date");
				
				MemberDto dto = new MemberDto(admin_no, admin_id, admin_pw,
						admin_mail, admin_phone, admin_reg_date, admin_mod_date);
				
				memberDtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				
				if (rs != null) rs.close();
				
				if (pstmt != null) pstmt.close();
				
				if (conn != null) conn.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
		}
		
		return memberDtos.size() > 0 ? memberDtos.get(0) : null;
	}

}
