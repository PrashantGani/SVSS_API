package com.svss.app.svss.Service.Impl;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.svss.app.svss.DTO.LoginDTO;
import com.svss.app.svss.DTO.MemberDTO;
import com.svss.app.svss.Entity.Member;
import com.svss.app.svss.Reposotory.MemberRepo;
import com.svss.app.svss.Response.LoginMesage;
import com.svss.app.svss.Service.MemberService;
import com.svss.app.svss.email.EmailService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String addMember(MemberDTO memberDTO) {
    	boolean is_admin = memberDTO.getIs_admin();
    	if (is_admin) {
    		is_admin=false;
		}
    	String otp2 = memberDTO.getOtp();
    	String memberName = memberDTO.getMemberName();
    	String email = memberDTO.getEmail();
    	String number = memberDTO.getNumber();
    	String password = memberDTO.getPassword();
    	String encodedPassword = passwordEncoder.encode(password);
    	System.out.println("=============="+password);
    	// Get the current LocalDateTime
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define a DateTimeFormatter to format the LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Convert LocalDateTime to String
        String formattedDateTime = currentDateTime.format(formatter);
    	Member member = new Member();
    	member.setIs_admin(is_admin);
    	member.setMemberName(memberName);
    	member.setEmail(email);
    	member.setPassword(encodedPassword);
    	member.setNumber(number);
    	member.setCreated_at(formattedDateTime);
        member.setCreated_at(formattedDateTime);
        String otp = generateOtp();
        member.setOtp(otp);
        memberRepo.save(member);
        
        emailService.sendOtpEmail(email, otp);
        return " Member Added Successfully";
    }

    @Override
    public Map<Object, Object> loginMember(LoginDTO loginDTO) {
        String msg = "";
       
        
        Map<Object,Object> response = new HashMap<>();
        Optional<Member> byEmail = memberRepo.findByEmail(loginDTO.getEmail());
        Member member = byEmail.get();
        boolean is_admin = member.getIs_admin();
        boolean isOtpVerified = member.isOtpVerified();
//        String otp = member.geti
//        boolean verifyOtp = verifyOtp(otp);
        int memberId = member.getMemberId();
        response.put("memberId", memberId);
        if (member != null && isOtpVerified) {
            String password = loginDTO.getPassword();
           
           
            String encodedPassword = member.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Member> employee = memberRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    response.put("Status", "Login Success");
                    response.put("isAdmin", is_admin);
                	return response;
                } else {
                	response.put("Status", "Login Failed");
                    return response;
                }
            } else {
            	response.put("Status", "password Not Match");
                return response;
            }
        }else {
//            return new LoginMesage("Email not exits", false);
        	response.put("Status", "Email not exits");
            return response;
        }
    }
    
	@Override
	public List<Member> getAllMember() {
		List<Member> all = memberRepo.findAll();
		return all;
	}
//===============================================================
    
    @Autowired
    private EmailService emailService;

    public String generateOtp() {
        return String.valueOf(new Random().nextInt(999999));  // Generate 6-digit OTP
    }

    public Boolean sendOtp(String email) {
        Optional<Member> userOptional = memberRepo.findByEmail(email);
        if (userOptional.isPresent()) {
        	Member user = userOptional.get();
            String otp = generateOtp();
            user.setOtp(otp);
            user.setOtpVerified(false);
            memberRepo.save(user);
            emailService.sendOtpEmail(email, otp);
        }
		return true;
    }

    public boolean verifyOtp(String otp) {
        Optional<Member> userOptional = memberRepo.findByOtp(otp);
        if (userOptional.isPresent()) {
        	Member user = userOptional.get();
        	String otpfromdb = user.getOtp();
        	if (otp.equals(otpfromdb)) {
        		user.setOtpVerified(true);
                memberRepo.save(user);
                return true;
			}
            
        }
        return false;
    }

    public boolean updatePassword(String email, String newPassword,String confirmPassword) {
    	if (newPassword.equals(confirmPassword)) {
    		String encodedNewPassword = passwordEncoder.encode(newPassword);
//        	String encodedCofirmPassword = passwordEncoder.encode(confirmPassword);
//        	if (encodedNewPassword.equals(encodedCofirmPassword)) {
        		 Optional<Member> userOptional = memberRepo.findByEmail(email);
        	        if (userOptional.isPresent()) {
        	        	Member user = userOptional.get();
        	            if (user.isOtpVerified()) {
        	                user.setPassword(encodedNewPassword);  // Password should be hashed in real applications
        	                memberRepo.save(user);
        	                return true;
        	            }
        	        }
		}
        return false;
    }



//	@Override
//	public boolean changePassword(String currentPassword, String newPassword, String confirmNewPassword) {
//		if (newPassword.equals(confirmNewPassword)) {
//			String encodedCurrentPassword = passwordEncoder.encode(currentPassword);
//			String encodedNewPassword = passwordEncoder.encode(newPassword);
//			Optional<Member> userOptional = memberRepo.findByPassword(encodedCurrentPassword);
//			if (userOptional.isPresent()) {
//	        	Member user = userOptional.get();
////	            if (user.isOtpVerified()) {
//	                user.setPassword(encodedNewPassword);  // Password should be hashed in real applications
//	                memberRepo.save(user);
//	                return true;
////	            }
//	        }
//		}
//		return false;
//	}
}