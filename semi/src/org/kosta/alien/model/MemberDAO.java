package org.kosta.alien.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public void updateMember(String id, String name, String password, String email) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "update member set name=?,password=?,email=? where id=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
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

	/***
	 * 비밀번호를 찾아줍니다.
	 * @param id
	 * @param name
	 * @param mail
	 * @return
	 * @throws SQLException
	 */
	public String findPassword(String id, String name, String mail) throws SQLException {
		String password=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dataSource.getConnection();
			String sql="SELECT password FROM member WHERE id=? AND name=? AND EMAIL=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, mail);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				password=rs.getString(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return password;
	}

	public void deleteMember(String id) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="delete from answer_like where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			pstmt=con.prepareStatement("delete from answer");
		}finally {
			closeAll(pstmt, con);
		}
	}
	//(String id, String name, String phone, String password, String email, int stamp, int coupon,
	// 
	public ArrayList<MemberVO> getMemberIdList() throws SQLException {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select id, name, status from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new MemberVO(rs.getString(1), rs.getString(2), rs.getInt(3) ));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	public MemberVO getMemberDetail(String id) throws SQLException{
		MemberVO mvo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="select id, name, stamp, coupon from member where id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				mvo=new MemberVO();
				mvo.setId(rs.getString(1));
				mvo.setName(rs.getString(2));
				mvo.setStamp(rs.getInt(3));
				mvo.setCoupon(rs.getInt(4));
				
				
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return mvo;
	}
}








