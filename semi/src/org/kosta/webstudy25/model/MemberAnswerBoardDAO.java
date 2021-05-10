package org.kosta.webstudy25.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class MemberAnswerBoardDAO {
	private static MemberAnswerBoardDAO dao=new MemberAnswerBoardDAO();
	private DataSource dataSource;
	private MemberAnswerBoardDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static MemberAnswerBoardDAO getInstance(){		
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
	
	public void MemberAnswer(MemberAnswerVO mavo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dataSource.getConnection();
			String sql="insert into member_answer(id,answer_no,answer_contents,ans_date) values(?,?,?, TO_CHAR(sysdate,'YYYY-MM-DD'))";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, mavo.getId());
			pstmt.setString(2, mavo.getAnswerNo());
			pstmt.setString(3, mavo.getAnswer_contents());
			pstmt.executeUpdate();
			
		}finally {
			closeAll(pstmt, con);
		}
	}
	public ArrayList<MemberAnswerVO> getMyAnswerList(MemberVO mvo) throws SQLException{
	      ArrayList<MemberAnswerVO> list=new ArrayList<MemberAnswerVO>();
	      Connection con=null;
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      try {
	         con=dataSource.getConnection();
	         StringBuilder sql=new StringBuilder();
	         sql.append("select ma.id, ma.answer_no, ma.answer_contents, ma.ans_date ");
	         sql.append("from member_answer ma, member m ");
	         sql.append("where ma.id=m.id and ma.id=?");
	         sql.append("order by ma.answer_no desc");
	         pstmt=con.prepareStatement(sql.toString());
	         pstmt.setString(1, mvo.getId());
	         rs=pstmt.executeQuery();
	         if(rs.next()) {
	         MemberAnswerVO mao=new MemberAnswerVO();
	         mao.setId(rs.getString(1));
	         mao.setAnswerNo(rs.getString(2));
	         mao.setAnswer_contents(rs.getString(3));
	         mao.setDate(rs.getString(4));
	         list.add(mao);
	         }
	         }finally {
	         closeAll(rs, pstmt, con);
	      }
	      return list;
	   }
	//-- id, answer_no, answer_contents, ans_date
		public MemberAnswerVO getPostingByNo(String MemberAnswerNo) throws SQLException{
			MemberAnswerVO mavo=null;
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				con=dataSource.getConnection();
				StringBuilder sql=new StringBuilder();
				sql.append("select id, answer_no,answer_contents,to_char(ans_date,'yyyy.mm.dd') as ans_date ");
				sql.append("from member_answer ");
				sql.append("where answer_no=?");
				pstmt=con.prepareStatement(sql.toString());
				pstmt.setString(1, MemberAnswerNo);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					mavo=new MemberAnswerVO();
					mavo.setId(rs.getString(1));
					mavo.setAnswerNo(MemberAnswerNo);
					mavo.setAnswer_contents(rs.getString(3));
					mavo.setDate(rs.getString(4));
				}
			}finally {
				closeAll(rs, pstmt, con);
			}
			return mavo;
		}
		public void deleteAnswer(int no) throws SQLException {
			Connection con=null;
			PreparedStatement pstmt=null;
			try {
				con=dataSource.getConnection();
				String sql="delete from member_answer where answer_no=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
			}finally {
				closeAll(pstmt, con);
			}
			
		}
	
}
