package com.svss.app.svss.DTO;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import com.svss.app.svss.Entity.Member;

import jakarta.persistence.Column;

public class BcDTO {

	private long BcId;
    private int memberId; 
	private Date date;
    private String particular;
    private BigDecimal basicAmount;
    private BigDecimal bidAmount;
    private BigDecimal TotalAmount;
    private Timestamp createdAt;
    private Member memberDetails;
    
	public long getBcId() {
		return BcId;
	}
	public void setBcId(long bcId) {
		BcId = bcId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public BigDecimal getBasicAmount() {
		return basicAmount;
	}
	public void setBasicAmount(BigDecimal basicAmount) {
		this.basicAmount = basicAmount;
	}
	public BigDecimal getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(BigDecimal bidAmount) {
		this.bidAmount = bidAmount;
	}
	public BigDecimal getTotalAmount() {
		return TotalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		TotalAmount = totalAmount;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Member getMemberDetails() {
		return memberDetails;
	}
	public void setMemberDetails(Member memberDetails) {
		this.memberDetails = memberDetails;
	}
    
    
}
