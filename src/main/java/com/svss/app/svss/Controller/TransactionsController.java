package com.svss.app.svss.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.svss.app.svss.DTO.TransactionsDTO;
import com.svss.app.svss.Service.TransactionService;

@RestController
@RequestMapping("api/v1")
public class TransactionsController {

    @Autowired
    private TransactionService transactionService;
    
//    http://localhost:8080/api/v1/addTransaction
    @PostMapping(path = "/addTransaction")
    public String saveTrasaction(@RequestBody TransactionsDTO transactionDto)
    {
        String message = transactionService.addTransaction(transactionDto);
        return message;
    }
    
//    http://localhost:8080/api/v1/getTransaction
    @GetMapping(path = "/getTransaction")
    public ResponseEntity<List<TransactionsDTO>> getAllTransaction()
    {
    	List<TransactionsDTO> dtoList = transactionService.getAllTransaction();
        return ResponseEntity.ok(dtoList);
    }
    @GetMapping(path = "/getTransactionByMemberId")
    public ResponseEntity<List<TransactionsDTO>> getAllTransactionByUserId(@RequestParam int memberId)
    {
    	List<TransactionsDTO> dtoList = transactionService.getAllTransactionByUserId(memberId);
    	return ResponseEntity.ok(dtoList);
    }
}
