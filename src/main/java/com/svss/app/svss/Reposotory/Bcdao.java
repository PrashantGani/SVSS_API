package com.svss.app.svss.Reposotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.svss.app.svss.DTO.BcDTO;
import com.svss.app.svss.Entity.BC;
import com.svss.app.svss.Entity.Transaction;
@Repository
public interface Bcdao extends JpaRepository<BC, Long>{

	 @Query("SELECT b FROM BC b WHERE b.memberId = :memberId")
	    List<BC> findByMemberId(@Param("memberId") int memberId);
}
