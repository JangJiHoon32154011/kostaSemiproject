package org.kosta.webstudy25.model;

public class AnswerVO {
	private String answerNo;
	private String questionNo;
	private String ans_contents;
	private int hits;
	private int like_count;

	public AnswerVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerVO(String answerNo, String questionNo, String ans_contents, int hits, int like_count) {
		super();
		this.answerNo = answerNo;
		this.questionNo = questionNo;
		this.ans_contents = ans_contents;
		this.hits = hits;
		this.like_count = like_count;
	}

	public AnswerVO(String questionNo, String ans_contents) {
		super();
		this.questionNo = questionNo;
		this.ans_contents = ans_contents;
	}

	public String getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(String answerNo) {
		this.answerNo = answerNo;
	}

	public String getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}

	public String getAns_contents() {
		return ans_contents;
	}

	public void setAns_contents(String ans_contents) {
		this.ans_contents = ans_contents;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	@Override
	public String toString() {
		return "AnswerVO [answerNo=" + answerNo + ", questionNo=" + questionNo + ", ans_contents=" + ans_contents
				+ ", hits=" + hits + ", like_count=" + like_count + "]";
	}

}
