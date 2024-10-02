package com.svss.app.svss.Service;

import java.util.List;
import java.util.Map;

import com.svss.app.svss.DTO.LoanDTO;

public interface LoanService {

	public Map<String, String> addLoan(LoanDTO loanDTO);

	public List<LoanDTO> getAllLoan();

	public List<LoanDTO> getAllLoanByMemberId(int memberId);

	
}
