package com.svss.app.svss.DTO;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import com.svss.app.svss.Entity.Member;


public class TransactionsDTO {

    private int transactionId;
    private int memberId; 
	private Date date;
    private String particular;
    private BigDecimal amount;
    private Timestamp createdAt;
    private MemberDTO memberDetails;
    
    // Getters and Setters

    public int getMemberId() {
		return memberId;
	}



	public TransactionsDTO(int transactionId, int memberId, Date date, String particular, BigDecimal amount,
			Timestamp createdAt, MemberDTO memberDetails) {
		super();
		this.transactionId = transactionId;
		this.memberId = memberId;
		this.date = date;
		this.particular = particular;
		this.amount = amount;
		this.createdAt = createdAt;
		this.memberDetails = memberDetails;
	}



	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
    
    public MemberDTO getMemberDetails() {
		return memberDetails;
	}



	public void setMemberDetails(MemberDTO memberDetails) {
		this.memberDetails = memberDetails;
	}



	public int getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }







	public TransactionsDTO() {
		// TODO Auto-generated constructor stub
	}
    
}

