package com.svss.app.svss.Service.Impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svss.app.svss.DTO.LoanDTO;
import com.svss.app.svss.Entity.Loan;
import com.svss.app.svss.Reposotory.LoanRepo;
import com.svss.app.svss.Response.LoginMesage;
import com.svss.app.svss.Service.LoanService;
@Service
public class LoanServiceimpl implements LoanService{

	@Autowired
	private LoanRepo loanRepo;
	
	@Override
	public Map<String, String> addLoan(LoanDTO loanDTO) {
		Loan loan = new Loan();
		Map<String, String> response = new HashMap<>();
		loan.setLoanId(loanDTO.getLoanId());
		loan.setMemberId(loanDTO.getMemberId());
		loan.setDate(loanDTO.getDate());
		loan.setParticular(loanDTO.getParticular());
		loan.setAmount(loanDTO.getAmount());
		loan.setStatus(loanDTO.getStatus());
		loan.setRemarks(loanDTO.getRemarks());
		 Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		loan.setCreatedAt(currentTimestamp);
		loanRepo.save(loan);
		response.put("response", "Loan Created Successfully for the memebrId : "+loanDTO.getMemberId());
		return response;
	}

	@Override
	public List<LoanDTO> getAllLoan() {
		List<Loan> loan = loanRepo.findAll();
		LoanDTO loanDTO =  new LoanDTO();
		List<LoanDTO> dtoList = convertLoansToLoanDTOs(loan);
		return dtoList;
	}

	public List<LoanDTO> convertLoansToLoanDTOs(List<Loan> loans) {
	    List<LoanDTO> loanDTOs = new ArrayList<>();
	    
	    for (Loan loan : loans) {
	        LoanDTO loanDTO = new LoanDTO();
	        loanDTO.setLoanId(loan.getLoanId());
	        loanDTO.setMemberId(loan.getMemberId());
	        loanDTO.setDate(loan.getDate());
	        loanDTO.setParticular(loan.getParticular());
	        loanDTO.setAmount(loan.getAmount());
	        loanDTO.setStatus(loan.getStatus());
	        loanDTO.setRemarks(loan.getRemarks());
	        loanDTO.setCreatedAt(loan.getCreatedAt());
	        
	        loanDTOs.add(loanDTO);
	    }
	    
	    return loanDTOs;
}

	@Override
	public List<LoanDTO> getAllLoanByMemberId(int memberId) {
		List<Loan> loans = loanRepo.findByMemberId(memberId);
		 List<LoanDTO> loanDTOs = new ArrayList<>();
		   for (Loan loan : loans) {
		        LoanDTO loanDTO = new LoanDTO();
		        loanDTO.setLoanId(loan.getLoanId());
		        loanDTO.setMemberId(loan.getMemberId());
		        loanDTO.setDate(loan.getDate());
		        loanDTO.setParticular(loan.getParticular());
		        loanDTO.setAmount(loan.getAmount());
		        loanDTO.setStatus(loan.getStatus());
		        loanDTO.setRemarks(loan.getRemarks());
		        loanDTO.setCreatedAt(loan.getCreatedAt());
		        
		        loanDTOs.add(loanDTO);
		    }
		return loanDTOs;
	}
}