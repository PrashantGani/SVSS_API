package com.svss.app.svss.Reposotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.svss.app.svss.Entity.Loan;

@EnableJpaRepositories
@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer>{

	@Query("SELECT l FROM Loan l WHERE l.memberId = :memberId")
	List<Loan> findByMemberId(@Param("memberId") int memberId);


}
