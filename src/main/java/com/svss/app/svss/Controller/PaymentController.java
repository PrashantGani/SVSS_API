package com.svss.app.svss.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.svss.app.svss.DTO.LoanDTO;
import com.svss.app.svss.DTO.PaymentDTO;
import com.svss.app.svss.Service.LoanService;
import com.svss.app.svss.Service.PaymentService;

@RestController
@RequestMapping("api/v1")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    
//    http://localhost:8080/api/v1/addPayment
    @PostMapping(path = "/addPayment")
    public String saveEmployee(@RequestBody PaymentDTO paymentDTO)
    {
        String message = paymentService.savePayment(paymentDTO);
        return message;
    }
    
//    http://localhost:8080/api/v1/getPaymet
    @GetMapping(path = "/getPaymet")
    public ResponseEntity<List<PaymentDTO>> getAllLoan()
    {
    	List<PaymentDTO> dtoList = paymentService.getAllTransaction();
        return ResponseEntity.ok(dtoList);
    }
}
