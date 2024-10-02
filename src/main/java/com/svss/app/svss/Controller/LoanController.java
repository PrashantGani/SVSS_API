package com.svss.app.svss.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.svss.app.svss.DTO.LoanDTO;
import com.svss.app.svss.Service.LoanService;

@RestController
@RequestMapping("api/v1")
public class LoanController {

    @Autowired
    private LoanService loanService;
    
//    http://localhost:8080/api/v1/addLoan
    @PostMapping(path = "/addLoan")
    public Map<String, String> saveEmployee(@RequestBody LoanDTO loanDTO)
    {
    	Map<String, String> message = loanService.addLoan(loanDTO);
        return message;
    }
    
//    http://localhost:8080/api/v1/getLoan
    @GetMapping(path = "/getLoan")
    public ResponseEntity<List<LoanDTO>> getAllLoan()
    {
    	List<LoanDTO> dtoList = loanService.getAllLoan();
        return ResponseEntity.ok(dtoList);
    }
//    http://localhost:8080/api/v1/getLoan
    @GetMapping(path = "/getLoanByMemberId")
    public ResponseEntity<List<LoanDTO>> getAllLoanByMemberId(@RequestParam int memberId)
    {
    	List<LoanDTO> dtoList = loanService.getAllLoanByMemberId(memberId);
    	return ResponseEntity.ok(dtoList);
    }
}
