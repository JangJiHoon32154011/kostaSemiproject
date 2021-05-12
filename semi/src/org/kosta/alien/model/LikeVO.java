package org.kosta.alien.model;

public class LikeVO {
	private String id;
	private String answerNo;
	public LikeVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LikeVO(String id, String answerNo) {
		super();
		this.id = id;
		this.answerNo = answerNo;
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
	@Override
	public String toString() {
		return "LikeVO [id=" + id + ", answerNo=" + answerNo + "]";
	}
}
