package com.svss.app.svss.Service.Impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svss.app.svss.DTO.LoanDTO;
import com.svss.app.svss.DTO.MemberDTO;
import com.svss.app.svss.DTO.TransactionsDTO;
import com.svss.app.svss.Entity.Loan;
import com.svss.app.svss.Entity.Member;
import com.svss.app.svss.Entity.Transaction;
import com.svss.app.svss.Reposotory.LoanRepo;
import com.svss.app.svss.Reposotory.MemberRepo;
import com.svss.app.svss.Reposotory.TransactionRepo;
import com.svss.app.svss.Response.LoginMesage;
import com.svss.app.svss.Service.LoanService;
import com.svss.app.svss.Service.TransactionService;
@Service
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	private TransactionRepo transactionRepo;
	
	@Autowired
	private MemberRepo memberRepo;
	
	@Override
	public Map<String,String> addTransaction(TransactionsDTO dto) {
		Map<String, String> response= new HashMap<>();
		Transaction transaction = new Transaction();
		transaction.setTransactionId(dto.getTransactionId());
		transaction.setMemberId(dto.getMemberId());
		transaction.setDate(dto.getDate());
		transaction.setParticular(dto.getParticular());
		transaction.setAmount(dto.getAmount());
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		transaction.setCreatedAt(currentTimestamp);
		transactionRepo.save(transaction);
		response.put("response", "Loan Created for the memebrId : "+dto.getMemberId());
		return response;
	}

	int memberId;
	
	@Override
	public List<TransactionsDTO> getAllTransaction() {
		List<Transaction> loan = transactionRepo.findAll();
		
//		for (Transaction transaction : loan) {
//			
//		}
//		for (int i = 0; i < loan.size(); i++) {
//			Member member = memberRepo.findById(loan.get(i).getMember());
//		}
//		Member member = memberRepo.findById();
		List<TransactionsDTO> dtoList = convertLoansToLoanDTOs(loan);
		return dtoList;
	}

	public List<TransactionsDTO> convertLoansToLoanDTOs(List<Transaction> transactions) {
	    List<TransactionsDTO> transactionDTOs = new ArrayList<>();
	    
	    for (Transaction transaction : transactions) {
	    	TransactionsDTO transactionDTO = new TransactionsDTO();
	    	transactionDTO.setTransactionId(transaction.getTransactionId());
	    	transactionDTO.setMemberId(transaction.getMemberId());
	    	 memberId = transaction.getMemberId();
	    	 Member member = memberRepo.findById(memberId).get();
	    	 MemberDTO convertMemberToDTO = convertMemberToDTO(member);
	    	transactionDTO.setDate(transaction.getDate());
	    	transactionDTO.setParticular(transaction.getParticular());
	    	transactionDTO.setAmount(transaction.getAmount());
	        transactionDTO.setCreatedAt(transaction.getCreatedAt());
	        transactionDTO.setMemberDetails(convertMemberToDTO);
	        
	        transactionDTOs.add(transactionDTO);
	    }
	    
	    return transactionDTOs;
	}

	@Override
	public List<TransactionsDTO> getAllTransactionByUserId(int memberId) {
		List<Transaction> byMemberId = transactionRepo.findByMemberId(memberId);
		System.out.println(byMemberId);
		Member member = memberRepo.findById(memberId).get();
		MemberDTO convertMemberToDTO = convertMemberToDTO(member);
		  List<TransactionsDTO> transactionDTOList = new ArrayList<>();
		  
	        for (int i = 0; i < byMemberId.size(); i++) {
	        	 TransactionsDTO dto = new TransactionsDTO();
		   		  dto.setTransactionId(byMemberId.get(i).getTransactionId());
		   		  dto.setMemberId(byMemberId.get(i).getMemberId());
		   		  dto.setDate(byMemberId.get(i).getDate());
		   		  dto.setParticular(byMemberId.get(i).getParticular());
		   		  dto.setAmount(byMemberId.get(i).getAmount());
		   		  dto.setCreatedAt(byMemberId.get(i).getCreatedAt());
		   		  dto.setMemberDetails(convertMemberToDTO);
		   		 transactionDTOList.add(dto);
			}
//	        for (Transaction transaction : byMemberId) {
//	            TransactionsDTO dto = new TransactionsDTO(
//	                transaction.getTransactionId(),
//	                transaction.getMemberId(),
//	                transaction.getDate(),
//	                transaction.getParticular(),
//	                transaction.getAmount(),
//	                transaction.getCreatedAt()
//	                transaction.getMemb
//	            );
//	            transactionDTOList.add(dto);
//	        }
//		  TransactionsDTO dto = new TransactionsDTO();
//		  dto.setTransactionId(byMemberId.get(memberId).getTransactionId());
//		  dto.setMemberId(byMemberId.get(memberId).getMemberId());
//		  dto.setDate(byMemberId.get(memberId).getDate());
//		  dto.setParticular(byMemberId.get(memberId).getParticular());
//		  dto.setAmount(byMemberId.get(memberId).getAmount());
//		  dto.setCreatedAt(byMemberId.get(memberId).getCreatedAt());
	        return transactionDTOList;
	}
	
	public MemberDTO convertMemberToDTO(Member member) {
	    MemberDTO memberDTO = new MemberDTO();
	    
	    memberDTO.setMemberId(member.getMemberId());
	    memberDTO.setMemberName(member.getMemberName());
	    memberDTO.setEmail(member.getEmail());
	    memberDTO.setPassword(member.getPassword());
	    memberDTO.setNumber(member.getNumber());
	    memberDTO.setIs_admin(member.getIs_admin());
	    memberDTO.setCreated_at(member.getCreated_at());
	    // Handle OTP fields if necessary
	    memberDTO.setOtp(member.getOtp());
	    memberDTO.setOtpVerified(member.isOtpVerified());
	    
	    return memberDTO;
	}
}