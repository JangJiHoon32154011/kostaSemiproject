package org.kosta.alien.model;

public class HintVO {
	private String questionNo;
	private String contents;

	public HintVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HintVO(String questionNo, String contents) {
		super();
		this.questionNo = questionNo;
		this.contents = contents;
	}

	public String getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "HintVO [questionNo=" + questionNo + ", contents=" + contents + "]";
	}

}
