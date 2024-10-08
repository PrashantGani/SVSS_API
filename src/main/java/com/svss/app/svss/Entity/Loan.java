package com.svss.app.svss.Entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.*;


@Entity
@Table(name = "loan") // Change to your table name if different
public class Loan {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int loanId; // Primary key

	    @Column(name = "member_id", nullable = false)
	    private int memberId; // Foreign key

	    @Column(nullable = false)
	    private Date date;

	    @Column(length = 255, nullable = false)
	    private String particular;

	    @Column(nullable = false)
	    private BigDecimal totalAmount;
	    
	    @Column(nullable = false)
	    private BigDecimal intrestAmount;
	    
	    @Column(nullable = false)
	    private BigDecimal loanAmount;

	    @Column(nullable = false)
	    private String status;

	    @Column(columnDefinition = "TEXT")
	    private String remarks;

	    @Column(name = "created_at", nullable = true, updatable = false)
	    private Timestamp createdAt;

    // Getters and Setters

    public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
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


    public String getStatus() {
        return status;
    }

    public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getIntrestAmount() {
		return intrestAmount;
	}

	public void setIntrestAmount(BigDecimal intrestAmount) {
		this.intrestAmount = intrestAmount;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
}

