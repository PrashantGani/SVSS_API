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
import com.svss.app.svss.DTO.BcDTO;
import com.svss.app.svss.Service.BcService;

@RestController
@RequestMapping("api/v1")
public class BcController {

    @Autowired
    private BcService bcService;
    
//    http://localhost:8080/api/v1/addBc
    @PostMapping(path = "/addBc")
    public Map<String, String> saveEmployee(@RequestBody BcDTO bcDTO)
    {
    	Map<String, String> message = bcService.addBc(bcDTO);
        return message;
    }
    
//    http://localhost:8080/api/v1/getBc
    @GetMapping(path = "/getBc")
    public ResponseEntity<List<BcDTO>> getAllBc()
    {
    	List<BcDTO> dtoList = bcService.getAllBc();
        return ResponseEntity.ok(dtoList);
    }
//    http://localhost:8080/api/v1/getBcByMemberId
    @GetMapping(path = "/getBcByMemberId")
    public ResponseEntity<List<BcDTO>> getAllBcByMemberId(@RequestParam int memberId)
    {
    	List<BcDTO> dtoList = bcService.getAllBcByMemberId(memberId);
    	return ResponseEntity.ok(dtoList);
    }
}
