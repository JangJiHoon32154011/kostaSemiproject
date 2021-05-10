package org.kosta.alien.model;

public class MemberAnswerVO {
	private String id;
	private String answerNo;
	private String date;
	private String answer_contents;
	public MemberAnswerVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberAnswerVO(String id, String answerNo, String date, String answer_contents) {
		super();
		this.id = id;
		this.answerNo = answerNo;
		this.date = date;
		this.answer_contents = answer_contents;
	}
	

	public MemberAnswerVO(String id, String answerNo, String answer_contents) {
		super();
		this.id = id;
		this.answerNo = answerNo;
		this.answer_contents = answer_contents;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(String answerNo) {
		this.answerNo = answerNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAnswer_contents() {
		return answer_contents;
	}
	public void setAnswer_contents(String answer_contents) {
		this.answer_contents = answer_contents;
	}
	@Override
	public String toString() {
		return "MemberAnswerVO [id=" + id + ", answerNo=" + answerNo + ", date=" + date + ", answer_contents="
				+ answer_contents + "]";
	}
	
}
