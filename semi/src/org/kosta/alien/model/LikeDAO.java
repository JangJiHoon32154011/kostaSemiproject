package org.kosta.alien.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class LikeDAO {
	private static LikeDAO dao=new LikeDAO();
	private DataSource dataSource;
	private LikeDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static LikeDAO getInstance(){		
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
	public void likeInsert(String id, int answerNo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="insert into ANSWER_LIKE(id,answer_no) values(?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, answerNo);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	public void likeDelete(String id, int answerNo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="delete from ANSWER_LIKE where id=? and answer_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, answerNo);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public LikeVO likeStatus(String id, String answerNo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		LikeVO lvo=null;
		try {
			con=dataSource.getConnection();
			String sql="select id,answer_no from answer_like where id=? and answer_no=? ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, answerNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				lvo=new LikeVO();
				lvo.setId(rs.getString(1));
				lvo.setAnswerNo(rs.getString(2));
			}
		}finally {
			closeAll(pstmt, con);
		}
		return lvo;
	}
	
	public void addLike(String id, String answerNo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="update answer set like_count=like_count+1 where answer_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, answerNo);
			
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public void subLike(String id, String answerNo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="update answer set like_count=like_count-1 where answer_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, answerNo);
			//pstmt.setString(2, id);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	public int checkLikeCount(int answerNo) throws SQLException{
		int count=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			String sql="select like_count from answer where answer_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, answerNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}
}
