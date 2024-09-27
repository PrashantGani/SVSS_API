package com.svss.app.svss.Service;

import java.util.List;

import com.svss.app.svss.DTO.PaymentDTO;

public interface PaymentService {
	
    String savePayment(PaymentDTO paymentDTO);

    List<PaymentDTO> getAllTransaction();

}
