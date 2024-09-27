package com.svss.app.svss.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="member")
public class Member {

    @Id
//    @Column(name="member_id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

//    @Column(name="member_name", length = 255)
    private String memberName;

//    @Column(name="email", length = 255)
    private String email;

//    @Column(name="password", length = 255)
    private String password;
    
//    @Column(name="number", length = 255)
    private String number;
    
//	@Column(name="is_admin", length = 255)
    private String is_admin;
    
//    @Column(name="created_at", length = 255)
    private String created_at;
    
    private String otp;
    
    private boolean otpVerified;
    
    
    
    
    public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public boolean isOtpVerified() {
		return otpVerified;
	}

	public void setOtpVerified(boolean otpVerified) {
		this.otpVerified = otpVerified;
	}

	public String getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}



	public int getMemberId() {
		return memberId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Member(int memberId, String memberName, String email, String password, String number, String is_admin,
			String created_at) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.email = email;
		this.password = password;
		this.number = number;
		this.is_admin = is_admin;
		this.created_at = created_at;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}



    
    
}
