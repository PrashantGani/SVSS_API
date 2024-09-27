package com.svss.app.svss.Entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.*;


@Entity
public class Transaction {
	
 	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId; // Primary key

    @Column(name = "member_id", nullable = false)
    private int memberId; // Foreign key

    @Column(nullable = false)
    private Date date;

    @Column(length = 255, nullable = false)
    private String particular;

    @Column(nullable = false)
    private BigDecimal amount;


    @Column(name = "created_at", nullable = true, updatable = false)
    private Timestamp createdAt;

    // Getters and Setters

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


	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
}

