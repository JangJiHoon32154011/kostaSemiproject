package org.kosta.webstudy25.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class AnswerBoardDAO {
	private static AnswerBoardDAO dao=new AnswerBoardDAO();
	private DataSource dataSource;
	private AnswerBoardDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static AnswerBoardDAO getInstance(){		
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
	public void Answer(AnswerVO avo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="insert into answer(answer_no,ans_contents,question_no) values (answer_seq.nextval,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, avo.getAns_contents());
			pstmt.setString(2, avo.getQuestionNo());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	public ArrayList<AnswerVO> getAnswerList() throws SQLException{
		ArrayList<AnswerVO> list=new ArrayList<AnswerVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select answer_no, ans_contents, question_no");
			sql.append(" from answer order by answer_no desc");
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				AnswerVO avo=new AnswerVO();
				avo.setAnswerNo(rs.getString(1));
				avo.setAns_contents(rs.getString(2));
				avo.setQuestionNo(rs.getString(3));
				list.add(avo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	public AnswerVO getAnswerByNo(String answerNo) throws SQLException{
		AnswerVO avo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select ans_contents,question_no,hits,like_count ");
			sql.append("from answer where answer_no=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, answerNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				avo=new AnswerVO();
				avo.setAnswerNo(answerNo);
				avo.setAns_contents(rs.getString(1));
				avo.setQuestionNo(rs.getString(2));
				avo.setHits(rs.getInt(3));
				avo.setLike_count(rs.getInt(4));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return avo;
	}
}
