package org.kosta.alien.model;

public class QuestionVO {
	private String questionNo;
	private String title;
	private String id;
	private String contents;
	private String category;
	private int hits;
	private int answerCount;
	public QuestionVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionVO(String questionNo, String title, String id, String contents, String category, int hits,
			int answerCount) {
		super();
		this.questionNo = questionNo;
		this.title = title;
		this.id = id;
		this.contents = contents;
		this.category = category;
		this.hits = hits;
		this.answerCount = answerCount;
	}
	
	public QuestionVO(String questionNo, String title) {
		super();
		this.questionNo = questionNo;
		this.title = title;
	}
	
	public QuestionVO(String questionNo, String title, String contents) {
		super();
		this.questionNo = questionNo;
		this.title = title;
		this.contents = contents;
	}
	
	
	
	public QuestionVO(String title, String id, String contents, String category) {
		super();
		this.title = title;
		this.id = id;
		this.contents = contents;
		this.category = category;
	}
	public String getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
	@Override
	public String toString() {
		return "QuestionVO [questionNo=" + questionNo + ", title=" + title + ", id=" + id + ", contents=" + contents
				+ ", category=" + category + ", hits=" + hits + ", answerCount=" + answerCount + "]";
	}
		
	
}
