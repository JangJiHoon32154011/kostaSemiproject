package org.kosta.alien.model;

public class MemberVO {
	private String id;
	private String name;
	private String phone;
	private String password;
	private String email;
	private int coupon;
	// default : 0 1: 관리자
	private int status;

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String id, String name, String phone, String password, String email, int coupon, int status) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.password = password;
		this.email = email;
		this.coupon = coupon;
		this.status = status;
	}
	
	
	public MemberVO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public MemberVO(String id, String password, String name) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", phone=" + phone + ", password=" + password + ", email="
				+ email + ", coupon=" + coupon + ", status=" + status + "]";
	}

}
