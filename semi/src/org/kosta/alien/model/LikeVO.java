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
	@Override
	public String toString() {
		return "LikeVO [id=" + id + ", answerNo=" + answerNo + "]";
	}
}
// mega coffee -> 1개 stamp 10개 -> 1 쿠촌 