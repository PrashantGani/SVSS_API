package com.svss.app.svss.Service;

import java.util.List;
import java.util.Map;

import com.svss.app.svss.DTO.BcDTO;
import com.svss.app.svss.DTO.LoanDTO;

public interface BcService {

	Map<String, String> addBc(BcDTO bcDTO);

	List<BcDTO> getAllBc();

	List<BcDTO> getAllBcByMemberId(int memberId);

}
