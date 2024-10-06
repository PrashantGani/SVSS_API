package com.svss.app.svss.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.svss.app.svss.DTO.LoginDTO;
import com.svss.app.svss.DTO.MemberDTO;
import com.svss.app.svss.Entity.Member;
import com.svss.app.svss.Response.LoginMesage;
import com.svss.app.svss.Service.MemberService;

@RestController
@RequestMapping("api/v1")
public class MemberController {
	
    @Autowired
    private MemberService memberService;
    
//    http://localhost:8080/api/v1/register
    @PostMapping(path = "/register")
    public String saveEmployee(@RequestBody MemberDTO memberDTO)
    {
        String message = memberService.addMember(memberDTO);
        return message;
    }
    
    @PostMapping(path = "/login")
    public ResponseEntity<Map<Object,Object>> loginUser(@RequestBody LoginDTO loginDTO)
    {
    	Map<Object, Object> loginMember = memberService.loginMember(loginDTO);
    	return ResponseEntity.ok(loginMember);
    }
    
    @GetMapping("/getAllMembers")
    public ResponseEntity<List<Member>> getAllUsers(){
    	List<Member> memberList = memberService.getAllMember();
    	return ResponseEntity.ok(memberList);
    }
    
    
    
//    =================================
    
    @PostMapping("/forgot")
    public Map<String, String> forgotPassword(@RequestParam String email) {
    	Map<String, String> response = new HashMap<>();
    	Boolean sendOtp = memberService.sendOtp(email);
  	  
      if (sendOtp) {
      	response.put("message", "OTP Sent successfully.");
          return response;
      } else {
      	response.put("message", "Error while sending OTP");
          return response;
      }
    }

    @PostMapping("/verify")
    public Map<String, Boolean> verifyOtp(@RequestParam String otp) {
    	Map<String, Boolean> response = new HashMap<>();
        if (memberService.verifyOtp(otp)) {
        	response.put("message", true);
            return response;
        } else {
        	response.put("message", false);
            return response;
        }
    }

    @PostMapping("/reset")
    public Map<String, String> resetPassword(@RequestParam String email, @RequestParam String newPassword,@RequestParam String confirmPassword) {
    	Map<String, String> response = new HashMap<>();
    	System.out.println("================"+email     +newPassword+     confirmPassword+"==================");
        if (memberService.updatePassword(email, newPassword,confirmPassword)) {
        	response.put("message", "Password updated successfully.");
            return response;
        } else {
        	response.put("message","Password reset failed Dueto to Mismatch password");
            return response;
        }
    }
}	
	
