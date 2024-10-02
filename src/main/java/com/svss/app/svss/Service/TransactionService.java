package com.svss.app.svss.Service;

import java.util.List;
import java.util.Map;

import com.svss.app.svss.DTO.TransactionsDTO;

public interface TransactionService {

	public Map<String,String> addTransaction(TransactionsDTO dto);

	public List<TransactionsDTO> getAllTransaction();

	public List<TransactionsDTO> getAllTransactionByUserId(int memberId);

	
}
