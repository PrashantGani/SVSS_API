package com.svss.app.svss.DTO;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;

public class LoanDTO {

    private int loanId;
    private int memberId;
    private Date date;
    private String particular;
    private BigDecimal totalAmount;
    private BigDecimal intrestAmount;
    private BigDecimal loanAmount;
    private String status;
    private String remarks;
    private Timestamp createdAt;


    // Getters and Setters

    
    
    public Date getDate() {
        return date;
    }
    

	public int getLoanId() {
		return loanId;
	}


	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}


	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
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


	public String getStatus() {
        return status;
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
}

