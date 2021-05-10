package org.kosta.webstudy25.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class JAnswerDAO{
	private static JAnswerDAO dao=new JAnswerDAO();
	private DataSource dataSource;
	private JAnswerDAO(){
		dataSource=DataSourceManager.getInstance().getDataSource();
	}
	public static JAnswerDAO getInstance(){		
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
	public void Answer(JAnswerVO javo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("insert into jang_answer(id,question_no,answer_no,answer_content,answer_date) ");
			sql.append("values(?,?,janswer_seq.nextval,?,sysdate)");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, javo.getId());
			pstmt.setString(2, javo.getQuestionNo());
			pstmt.setString(3, javo.getAnswerContent());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	public ArrayList<JAnswerVO> getMyAnswerList(String id) throws SQLException{
		ArrayList<JAnswerVO> list=new ArrayList<JAnswerVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select question_no, answer_date from jang_answer");
			sql.append(" where id=? order by answer_no");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				JAnswerVO javo=new JAnswerVO();
				javo.setQuestionNo(rs.getString(1));
				javo.setAnswerDate(rs.getString(2));
				list.add(javo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	public ArrayList<JAnswerVO> getAllAnswerList(int qno) throws SQLException{
		ArrayList<JAnswerVO> list=new ArrayList<JAnswerVO>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select ja.question_no, ja.id, ja.answer_date, q.title, q.contents ");
			sql.append("from jang_answer ja, member m, question q " );
			sql.append("where ja.id=m.id and q.question_no=? and ja.question_no=? ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, qno);
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	public JAnswerVO getMyDetailAnswer(String id, int qno) throws SQLException{
		JAnswerVO javo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder  sql=new StringBuilder();
			sql.append("select id, question_no, answer_no, answer_content, answer_date");
			sql.append(" from jang_answer where id=? and question_no=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setInt(2, qno);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				javo=new JAnswerVO();
				javo.setId(rs.getString(1));
				javo.setQuestionNo(rs.getString(2));
				javo.setAnswerNo(rs.getString(3));
				javo.setAnswerContent(rs.getString(4));
				javo.setAnswerDate(rs.getString(5));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return javo;
	}
	
	public void deleteMyAnswer(int ano) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="delete from jang_answer where answer_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, ano);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public JAnswerVO getAnswerByAnswerNo(int ano) throws SQLException{
		JAnswerVO javo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select id, answer_no, question_no, answer_content, answer_date");
			sql.append(" from jang_answer where answer_no=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, ano);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				javo=new JAnswerVO();
				javo.setId(rs.getString(1));
				javo.setAnswerNo(rs.getString(2));
				javo.setQuestionNo(rs.getString(3));
				javo.setAnswerContent(rs.getString(4));
				javo.setAnswerDate(rs.getString(5));
				
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return javo;
	}
	
	public void updateAnswer(JAnswerVO vo) throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="update jang_answer set answer_content=? where  id= ? and question_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getAnswerContent());
			pstmt.setString(2, vo.getId());
			pstmt.setInt(3, Integer.parseInt(vo.getQuestionNo()));
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
}
