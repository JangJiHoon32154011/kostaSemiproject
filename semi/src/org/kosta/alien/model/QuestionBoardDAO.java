package org.kosta.alien.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class QuestionBoardDAO {
	private static QuestionBoardDAO dao = new QuestionBoardDAO();
	private DataSource dataSource;

	private QuestionBoardDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}

	public static QuestionBoardDAO getInstance() {
		return dao;
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		closeAll(null, pstmt, con);
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public int getTotalPostCount() throws SQLException {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select count(*) from question";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}

	public ArrayList<QuestionVO> getPostingList() throws SQLException {
		ArrayList<QuestionVO> list = new ArrayList<QuestionVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select question_no, title from question order by question_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new QuestionVO(rs.getString(1), rs.getString(2)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public ArrayList<QuestionVO> getSEList() throws SQLException {
		ArrayList<QuestionVO> list = new ArrayList<QuestionVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select question_no, title from question where category= 'se' order by question_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new QuestionVO(rs.getString(1), rs.getString(2)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public ArrayList<QuestionVO> getJdbcList() throws SQLException {
		ArrayList<QuestionVO> list = new ArrayList<QuestionVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select question_no, title from question where category= 'jdbc' order by question_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new QuestionVO(rs.getString(1), rs.getString(2)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public ArrayList<QuestionVO> getWebList() throws SQLException {
		ArrayList<QuestionVO> list = new ArrayList<QuestionVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select question_no, title from question where category= 'web' order by question_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new QuestionVO(rs.getString(1), rs.getString(2)));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	// 이거 question으로 바꾸는게 어때???
	/***
	 * 번호에 따른 문제 받아오기
	 * @param questionNo
	 * @return
	 * @throws SQLException
	 */
	public QuestionVO getPostingByNo(String questionNo) throws SQLException {
		QuestionVO qvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select title, contents from question where question_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, questionNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qvo = new QuestionVO();
				qvo.setQuestionNo(questionNo);
				qvo.setTitle(rs.getString(1));
				qvo.setContents(rs.getString(2));

			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return qvo;
	}

	public void AddQuestion(QuestionVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into question(question_no, title, contents, category) ");
			sql.append("values(question_seq.nextval,?,?,?)");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());
			pstmt.setString(3, vo.getCategory());
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	public QuestionVO getQuestionByQuestionNo(int qno) throws SQLException {
		QuestionVO qvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String sql = "select question_no,title, contents from question where question_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qvo = new QuestionVO();
				qvo.setQuestionNo(rs.getString(1));
				qvo.setTitle(rs.getString(2));
				qvo.setContents(rs.getString(3));
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return qvo;
	}

	public void updateQuestion(QuestionVO qvo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "update question set contents=? where question_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getContents());
			pstmt.setInt(2, Integer.parseInt(qvo.getQuestionNo()));
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}

	}

	public void deleteQuestion(int qno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			String sql = "delete from question where question_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qno);
			pstmt.executeUpdate();
		} finally {
			closeAll(pstmt, con);
		}
	}

	/**
	 * category별 총 문제수를 반환합니다.
	 * 
	 * @param category
	 * @return
	 * @throws SQLException
	 */
	public int getTotalPostCount(String category) throws SQLException {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT count(*) FROM question WHERE category = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, category);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}

	public ArrayList<QuestionVO> getQuestionList(String category, PagingBean pagingBean) throws SQLException {
		ArrayList<QuestionVO> list = new ArrayList<QuestionVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT B.question_no,B.title ");
			sql.append("FROM (  ");
			sql.append("SELECT row_number() over(ORDER BY question_no DESC) as rnum,  ");
			sql.append("question_no,title ");
			sql.append("FROM question  ");
			sql.append("WHERE category = ? ");
			sql.append(") B ");
			sql.append("WHERE  rnum BETWEEN ? AND ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, category);
			pstmt.setInt(2, pagingBean.getStartRowNumber());
			pstmt.setInt(3, pagingBean.getEndRowNumber());
			rs = pstmt.executeQuery();
			// 목록에서 게시물 content는 필요없으므로 null로 setting
			// select no,title,time_posted,hits,id,name
			while (rs.next()) {
				QuestionVO qvo = new QuestionVO();
				qvo.setQuestionNo(rs.getString(1));
				qvo.setTitle(rs.getString(2));
				list.add(qvo);
			}
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
	
	//힌트보기
		public HintVO getHintByQuestionNo(String questionNo) throws SQLException{
			HintVO hvo=null;
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
				   con=dataSource.getConnection();
				   String sql="select hint_content from hint where question_no=?";
				   pstmt=con.prepareStatement(sql);
				   pstmt.setString(1, questionNo);
				   rs=pstmt.executeQuery();
				   if(rs.next()) {
					   hvo=new HintVO();
					   hvo.setContents(rs.getString(1));
				   }
			   }finally {
				   closeAll(rs, pstmt, con);
			   }
			   return hvo;
			
		}
	
		//문제 검색
		public ArrayList<QuestionVO> searchQuestion(String word) throws SQLException {
			ArrayList<QuestionVO> list=new ArrayList<QuestionVO>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			try { 
				con = dataSource.getConnection();
				StringBuilder sql = new StringBuilder();
				sql.append("select question_no,title from question ");
				sql.append("where title like '%' || ? || '%'");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, word);
				rs =pstmt.executeQuery();
				while(rs.next()) {
					list.add(new QuestionVO(rs.getString(1),rs.getString(2)));
				}
			} finally {
				closeAll(rs,pstmt, con);
			}
			return list;
		}	
		
}
