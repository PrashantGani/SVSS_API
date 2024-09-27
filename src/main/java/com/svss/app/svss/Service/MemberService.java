package com.svss.app.svss.Service;

import java.util.List;
import java.util.Map;

import com.svss.app.svss.DTO.LoginDTO;
import com.svss.app.svss.DTO.MemberDTO;
import com.svss.app.svss.Entity.Member;
import com.svss.app.svss.Response.LoginMesage;

public interface MemberService {
	
    String addMember(MemberDTO employeeDTO);

    Map<Object, Object>  loginMember(LoginDTO loginDTO);

	Boolean sendOtp(String email);

	boolean verifyOtp(String otp);

	boolean updatePassword(String email, String newPassword,String confirmPassword);

	List<Member> getAllMember();

//	boolean changePassword(String currentPassword, String newPassword, String confirmNewPassword);

}
