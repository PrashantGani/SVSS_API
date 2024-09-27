package com.svss.app.svss.Service;

import java.util.List;

import com.svss.app.svss.DTO.LoanDTO;

public interface LoanService {

	public String addLoan(LoanDTO loanDTO);

	public List<LoanDTO> getAllLoan();

	
}
