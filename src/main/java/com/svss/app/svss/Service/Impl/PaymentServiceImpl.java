package com.svss.app.svss.Service.Impl;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.svss.app.svss.DTO.PaymentDTO;
import com.svss.app.svss.DTO.TransactionsDTO;
import com.svss.app.svss.Entity.Payment;
import com.svss.app.svss.Entity.Transaction;
import com.svss.app.svss.Reposotory.MemberRepo;
import com.svss.app.svss.Reposotory.PaymentRepo;
import com.svss.app.svss.Service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

	@Override
	public String savePayment(PaymentDTO paymentDTO) {
		
		Payment payment = new Payment();
		payment.setPaymentId(paymentDTO.getPaymentId());
		payment.setLoanId(paymentDTO.getLoanId());
		payment.setPaymentDate(paymentDTO.getPaymentDate());
		payment.setAmount(paymentDTO.getAmount());
		payment.setPrincipalAmount(paymentDTO.getPrincipalAmount());
		payment.setInterestAmount(paymentDTO.getInterestAmount());
		payment.setPaymentType(paymentDTO.getPaymentType());
		payment.setRemarks(paymentDTO.getRemarks());
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		payment.setCreatedAt(currentTimestamp);
		paymentRepo.save(payment);
		return "Payment Added Successsfully ";
	}

	@Override
	public List<PaymentDTO> getAllTransaction() {
		List<Payment> paymentList = paymentRepo.findAll();
		List<PaymentDTO> listOfpayments = convertLoansToLoanDTOs(paymentList);
		return listOfpayments;
	}

	public List<PaymentDTO> convertLoansToLoanDTOs(List<Payment> payments) {
	    List<PaymentDTO> paymentDtos = new ArrayList<>();
	    
	    for (Payment payment : payments) {
	    	PaymentDTO paymentDto = new PaymentDTO();
	    	paymentDto.setPaymentId(payment.getPaymentId());
	    	paymentDto.setLoanId(payment.getLoanId());
	    	paymentDto.setPaymentDate(payment.getPaymentDate());
	    	paymentDto.setAmount(payment.getAmount());
	    	paymentDto.setPrincipalAmount(payment.getPrincipalAmount());
	    	paymentDto.setInterestAmount(payment.getInterestAmount());
	    	paymentDto.setPaymentType(payment.getPaymentType());
	    	paymentDto.setRemarks(payment.getRemarks());
	        
	    	paymentDtos.add(paymentDto);
	    }
	    
	    return paymentDtos;
	}
}