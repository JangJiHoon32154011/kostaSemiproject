package org.kosta.alien.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class AnswerDAO{
	private static AnswerDAO dao=new AnswerDAO();
	private DataSource dataSource;
	private AnswerDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static AnswerDAO getInstance(){		
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
			StringBuilder sql=new StringBuilder();
			sql.append("insert into answer(id,question_no,answer_no,answer_content,answer_date) ");
			sql.append("values(?,?,answer_seq.nextval,?,sysdate)");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, avo.getId());
			pstmt.setString(2, avo.getQuestionNo());
			pstmt.setString(3, avo.getAnswerContent());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	public ArrayList<AnswerVO> getMyAnswerList(String id) throws SQLException{
		ArrayList<AnswerVO> list=new ArrayList<AnswerVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select question_no, answer_date from answer");
			sql.append(" where id=? order by answer_no");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				AnswerVO avo=new AnswerVO();
				avo.setQuestionNo(rs.getString(1));
				avo.setAnswerDate(rs.getString(2));
				list.add(avo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	public ArrayList<AnswerVO> getAllAnswerList(int qno) throws SQLException{
		ArrayList<AnswerVO> list=new ArrayList<AnswerVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select a.question_no, a.id, a.answer_date, a.answer_content,a.answer_no ");
			sql.append("from answer a, member m, question q " );
			sql.append("where a.id=m.id and q.question_no=? and a.question_no=? ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, qno);
			pstmt.setInt(2, qno);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				//이 메세지 나올때는 ps.setString() 하는 부분이 제대로 되어있는지 살펴본다. method 매개인자 개수와 ps.setString 할때 숫자가 틀렸을때 혹은 변수가 틀릴때 나는 에러이다
				AnswerVO avo=new AnswerVO();
				avo.setQuestionNo(rs.getString(1));
				avo.setId(rs.getString(2));
				avo.setAnswerDate(rs.getString(3));
				avo.setAnswerContent(rs.getString(4));
				avo.setAnswerNo(rs.getString(5));
				list.add(avo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	public AnswerVO getMyDetailAnswer(String id, int qno) throws SQLException{
		AnswerVO avo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder  sql=new StringBuilder();
			sql.append("select id, question_no, answer_no, answer_content, answer_date");
			sql.append(" from answer where id=? and question_no=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setInt(2, qno);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				avo=new AnswerVO();
				avo.setId(rs.getString(1));
				avo.setQuestionNo(rs.getString(2));
				avo.setAnswerNo(rs.getString(3));
				avo.setAnswerContent(rs.getString(4));
				avo.setAnswerDate(rs.getString(5));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return avo;
	}
	
	public void deleteMyAnswer(int ano) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="delete from answer where answer_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, ano);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public AnswerVO getAnswerByAnswerNo(int ano) throws SQLException{
		AnswerVO avo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select id, answer_no, question_no, answer_content, answer_date");
			sql.append(" from answer where answer_no=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, ano);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				avo=new AnswerVO();
				avo.setId(rs.getString(1));
				avo.setAnswerNo(rs.getString(2));
				avo.setQuestionNo(rs.getString(3));
				avo.setAnswerContent(rs.getString(4));
				avo.setAnswerDate(rs.getString(5));
				
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return avo;
	}
	
	public void updateAnswer(AnswerVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="update answer set answer_content=? where  id= ? and question_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getAnswerContent());
			pstmt.setString(2, vo.getId());
			pstmt.setInt(3, Integer.parseInt(vo.getQuestionNo()));
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	public boolean getUpdateCheck(String id,int qno) throws SQLException {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		try {
			con=dataSource.getConnection();
			String sql="select count(*) from answer where question_no=? and id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, qno);
			rs=pstmt.executeQuery();
			if(rs.next()&&rs.getInt(1)>0) {
				flag=true;
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return flag;
	}
	
}
