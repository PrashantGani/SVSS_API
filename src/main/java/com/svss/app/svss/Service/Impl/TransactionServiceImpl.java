package com.svss.app.svss.Service.Impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svss.app.svss.DTO.LoanDTO;
import com.svss.app.svss.DTO.TransactionsDTO;
import com.svss.app.svss.Entity.Loan;
import com.svss.app.svss.Entity.Transaction;
import com.svss.app.svss.Reposotory.LoanRepo;
import com.svss.app.svss.Reposotory.TransactionRepo;
import com.svss.app.svss.Response.LoginMesage;
import com.svss.app.svss.Service.LoanService;
import com.svss.app.svss.Service.TransactionService;
@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepo transactionRepo;
	
	@Override
	public String addTransaction(TransactionsDTO dto) {
		Transaction transaction = new Transaction();
		transaction.setTransactionId(dto.getTransactionId());
		transaction.setMemberId(dto.getMemberId());
		transaction.setDate(dto.getDate());
		transaction.setParticular(dto.getParticular());
		transaction.setAmount(dto.getAmount());
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		transaction.setCreatedAt(currentTimestamp);
		transactionRepo.save(transaction);
		return "Loan Created for the memebrId : "+dto.getMemberId();
	}

	@Override
	public List<TransactionsDTO> getAllTransaction() {
		List<Transaction> loan = transactionRepo.findAll();
		List<TransactionsDTO> dtoList = convertLoansToLoanDTOs(loan);
		return dtoList;
	}

	public List<TransactionsDTO> convertLoansToLoanDTOs(List<Transaction> transactions) {
	    List<TransactionsDTO> transactionDTOs = new ArrayList<>();
	    
	    for (Transaction transaction : transactions) {
	    	TransactionsDTO transactionDTO = new TransactionsDTO();
	    	transactionDTO.setTransactionId(transaction.getTransactionId());
	    	transactionDTO.setMemberId(transaction.getMemberId());
	    	transactionDTO.setDate(transaction.getDate());
	    	transactionDTO.setParticular(transaction.getParticular());
	    	transactionDTO.setAmount(transaction.getAmount());
	        transactionDTO.setCreatedAt(transaction.getCreatedAt());
	        
	        transactionDTOs.add(transactionDTO);
	    }
	    
	    return transactionDTOs;
	}

	@Override
	public List<TransactionsDTO> getAllTransactionByUserId(int memberId) {
		List<Transaction> byMemberId = transactionRepo.findByMemberId(memberId);
		System.out.println(byMemberId);
		
		  List<TransactionsDTO> transactionDTOList = new ArrayList<>();
	        
	        for (Transaction transaction : byMemberId) {
	            TransactionsDTO dto = new TransactionsDTO(
	                transaction.getTransactionId(),
	                transaction.getMemberId(),
	                transaction.getDate(),
	                transaction.getParticular(),
	                transaction.getAmount(),
	                transaction.getCreatedAt()
	            );
	            transactionDTOList.add(dto);
	        }
	        
	        return transactionDTOList;
	}
	
	
}