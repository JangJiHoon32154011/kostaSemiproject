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
	public LikeVO likeStatus(String id, String answerNo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		LikeVO lvo=null;
		try {
			con=dataSource.getConnection();
			String sql="select id,answer_no from answer_like where id=? and answer_no=? ";
			pstmt=con.prepareStatement(sql);
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
			//String sql="update"
		}finally {
			closeAll(pstmt, con);
		}
	}
/*
 *      Connection con = null;
      PreparedStatement ps = null;
      String sql = null;
      System.out.println(isLike);
      if(Integer.parseInt(isLike) == 0) {
         this.updateLikes(con, mbCode, gdCode);
         sql = "UPDATE GOODS SET GD_LIKE = GD_LIKE + 1 WHERE GD_CODE = ?";
      } else {
         this.deleteLikes(con, mbCode, gdCode);
         sql = "UPDATE GOODS SET GD_LIKE = GD_LIKE - 1 WHERE GD_CODE = ?";
      }
      int result = 0;
      try {
         con = DbUtil.getConnection();
         ps = con.prepareStatement(sql);
         ps.setString(1, gdCode);
         result = ps.executeUpdate();
      } finally {
         DbUtil.dbClose(ps, con);
      }
      return result;

 * 
 */
}
