package com.svss.app.svss.DTO;

import java.util.List;

import com.svss.app.svss.Entity.Transaction;

public class MemberDTO {

    private int memberId;
    private String memberName;
    private String email;
    private String password;
    private String number;
    private String is_admin;
    private String created_at;
    private String otp;
    private boolean otpVerified;
    private List<Transaction> transactionsDetails; 
    
	public List<Transaction> getTransactionsDetails() {
		return transactionsDetails;
	}

	public void setTransactionsDetails(List<Transaction> transactionsDetails) {
		this.transactionsDetails = transactionsDetails;
	}

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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
    
    
    
} 