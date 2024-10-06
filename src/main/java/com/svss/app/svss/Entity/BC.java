package com.svss.app.svss.Entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
public class BC {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long BcId;
	@Column(name = "member_id", nullable = false)
    private int memberId; 
	private Date date;
    private String particular;
    private BigDecimal basicAmount;
    private BigDecimal bidAmount;
    private BigDecimal TotalAmount;
    private Timestamp createdAt;
    
    @Transient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member memberDetails;
    
    
    
	public BC(long bcId, int memberId, Date date, String particular, BigDecimal basicAmount, BigDecimal bidAmount,
			BigDecimal totalAmount, Timestamp createdAt, Member memberDetails) {
		super();
		BcId = bcId;
		this.memberId = memberId;
		this.date = date;
		this.particular = particular;
		this.basicAmount = basicAmount;
		this.bidAmount = bidAmount;
		TotalAmount = totalAmount;
		this.createdAt = createdAt;
		this.memberDetails = memberDetails;
	}
	
	
	
	public BC() {
		super();
		// TODO Auto-generated constructor stub
	}



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
