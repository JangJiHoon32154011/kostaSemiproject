package org.kosta.alien.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;


public class MemberDAO {
	private static MemberDAO dao=new MemberDAO();
	private DataSource dataSource;
	private MemberDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static MemberDAO getInstance(){		
		return dao;
	}	
	public void closeAll(PreparedStatement pstmt,
			Connection con) throws SQLException{
		closeAll(null,pstmt,con);
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,
			Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	
	
	public MemberVO login(String id,String password) throws SQLException{
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con=dataSource.getConnection();
			String sql="select name,status from member where id=? and password=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()){
				vo=new MemberVO();
				vo.setId(id);
				vo.setName(rs.getString(1));
				vo.setStatus(rs.getInt(2));
			}
		}finally{
			closeAll(rs, pstmt,con);
		}
		return vo;
	}
	
	public void signUp(String id, String password, String name, String email) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		
		try { 
			con = dataSource.getConnection();
			String sql = "insert into member(id,password,name,email) values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}
	public int duplicateId(String id) throws SQLException {
		int count=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select count(id) as cnt ");
			sql.append(" from member ");
			sql.append(" where id = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt("cnt");
		} catch(Exception e) {
			System.out.println("아이디 중복 확인 실패 : " + e);
		} finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}
	public void updateStamp(String id, int num) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="update member set stamp=stamp+? where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	public int checkStamp(String id) throws SQLException{
		Connection con=null;
		int stamp=0;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="select stamp from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				stamp=rs.getInt(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		
		return stamp;
	}
	public void updateCoupon(String id, int stampNo) throws SQLException{
		int stamp=0;
		int coupon=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
				stamp=stampNo;
				coupon= stamp / 10;
				stamp= stamp % 10;
				String sql="update member set stamp=?,coupon=coupon+? where id=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, stamp);
				pstmt.setInt(2, coupon);
				pstmt.setString(3, id);
				pstmt.executeUpdate();
				
			}
		finally {
			closeAll(pstmt, con);
		}
	}
}








