package com.svss.app.svss.Service;

import java.util.List;

import com.svss.app.svss.DTO.LoanDTO;
import com.svss.app.svss.DTO.TransactionsDTO;

public interface TransactionService {

	public String addTransaction(TransactionsDTO dto);

	public List<TransactionsDTO> getAllTransaction();

	public List<TransactionsDTO> getAllTransactionByUserId(int memberId);

	
}
