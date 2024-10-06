package com.svss.app.svss.Service.Impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svss.app.svss.DTO.BcDTO;
import com.svss.app.svss.Entity.BC;
import com.svss.app.svss.Entity.Member;
import com.svss.app.svss.Reposotory.Bcdao;
import com.svss.app.svss.Reposotory.MemberRepo;
import com.svss.app.svss.Service.BcService;

@Service
public class BcServiceImpl implements BcService{

	@Autowired
	private Bcdao bcDao;
	@Autowired
	private MemberRepo memberRepo;
	@Override
	public Map<String, String> addBc(BcDTO bcDTO) {
		BC bcEntity = convertToEntity(bcDTO);
		BC bc = bcDao.save(bcEntity);
		Map<String, String> response =  new HashMap<>();
		response.put("message", "BC Given Successfully");
		return response;
	}

	@Override
	public List<BcDTO> getAllBc() {
		List<BC> allBc = bcDao.findAll();
		List<BcDTO> convertToDto = convertToDto(allBc);
		return convertToDto;
	}

	@Override
	public List<BcDTO> getAllBcByMemberId(int memberId) {
		List<BC> dtoList = bcDao.findByMemberId(memberId);
		Member member = memberRepo.findById(memberId).get();
		 List<BcDTO> bcDTOList = new ArrayList<>();
		  
	        for (int i = 0; i < dtoList.size(); i++) {
	        	BcDTO bcDTO = new BcDTO();
	        	bcDTO.setBcId(dtoList.get(i).getBcId());
		    	bcDTO.setDate(dtoList.get(i).getDate());
		    	bcDTO.setParticular(dtoList.get(i).getParticular());
		    	bcDTO.setBidAmount(dtoList.get(i).getBidAmount());
		    	bcDTO.setBasicAmount(dtoList.get(i).getBasicAmount());
		    	bcDTO.setTotalAmount(dtoList.get(i).getTotalAmount());
		    	bcDTO.setCreatedAt(dtoList.get(i).getCreatedAt());
		    	bcDTO.setMemberDetails(member);
		    	bcDTOList.add(bcDTO);
			}
		return bcDTOList;
	}
	
	public BC convertToEntity(BcDTO bcDTO) {
	    BC bc = new BC();
	    bc.setBcId(bcDTO.getBcId());
	    bc.setMemberId(bcDTO.getMemberId());
	    bc.setDate(bcDTO.getDate());
	    bc.setParticular(bcDTO.getParticular());
	    BigDecimal basicAmount = bcDTO.getBasicAmount();
	    bc.setBasicAmount(basicAmount);
	    BigDecimal bidAmount = bcDTO.getBidAmount();
	    bc.setBidAmount(bidAmount);
	    
	    BigDecimal totalAmount = basicAmount.subtract(bidAmount);
	    bc.setTotalAmount(totalAmount);
	    Timestamp currentTimestamp = Timestamp.from(Instant.now());
	    bc.setCreatedAt(currentTimestamp);
//	    bc.setMemberDetails(bcDTO.getMemberDetails());
	    return bc;
	}

	public List<BcDTO> convertToDto(List<BC> bcList) {
		
		 List<BcDTO> BsDTOs = new ArrayList<>();
	    BcDTO bcDTO = new BcDTO();
	    for (BC perBc : bcList) {
	    	int memberId = perBc.getMemberId();
	    	Member member = memberRepo.findById(memberId).get();
	    	bcDTO.setBcId(perBc.getBcId());
	    	bcDTO.setDate(perBc.getDate());
	    	bcDTO.setParticular(perBc.getParticular());
	    	bcDTO.setBidAmount(perBc.getBidAmount());
	    	bcDTO.setBasicAmount(perBc.getBasicAmount());
	    	bcDTO.setTotalAmount(perBc.getTotalAmount());
	    	Timestamp currentTimestamp = Timestamp.from(Instant.now());
	    	bcDTO.setCreatedAt(currentTimestamp);
	    	bcDTO.setMemberDetails(member);
	    	BsDTOs.add(bcDTO);
	    }
		return BsDTOs;
	}


}
