package org.kosta.alien.model;

public class AnswerVO {
	private String id;
	private String questionNo;
	private String answerNo;
	private String answerContent;
	private String answerDate;
	private int hits;	
	private int likeCount;
	public AnswerVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnswerVO(String id, String questionNo, String answerNo, String answerContent, String answerDate, int hits,
			int likeCount) {
		super();
		this.id = id;
		this.questionNo = questionNo;
		this.answerNo = answerNo;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
		this.hits = hits;
		this.likeCount = likeCount;
	}
	
	public AnswerVO(String id, String questionNo, String answerContent) {
		super();
		this.id = id;
		this.questionNo = questionNo;
		this.answerContent = answerContent;
	}
	
	
	public AnswerVO(String questionNo, String answerDate) {
		super();
		this.questionNo = questionNo;
		this.answerDate = answerDate;
	}
	
	
	public AnswerVO(String id, String questionNo, String answerNo, String answerContent) {
		super();
		this.id = id;
		this.questionNo = questionNo;
		this.answerNo = answerNo;
		this.answerContent = answerContent;
	}
	public AnswerVO(String id, String questionNo, String answerNo, String answerContent, String answerDate) {
		super();
		this.id = id;
		this.questionNo = questionNo;
		this.answerNo = answerNo;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}
	public String getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(String answerNo) {
		this.answerNo = answerNo;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	@Override
	public String toString() {
		return "JAnswerVO [id=" + id + ", questionNo=" + questionNo + ", answerNo=" + answerNo + ", answerContent="
				+ answerContent + ", answerDate=" + answerDate + ", hits=" + hits + ", likeCount=" + likeCount + "]";
	} 
	
	
}
