package com.svss.app.svss.Reposotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.svss.app.svss.DTO.TransactionsDTO;
import com.svss.app.svss.Entity.Transaction;

import jakarta.persistence.Tuple;

@EnableJpaRepositories
@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>{

//	List<TransactionsDTO> findByMemberId(int memberId);
//	@Query("SELECT t.transactionId AS transactionId, t.amount AS amount, t.date AS date, t.particular AS particular, t.createdAt AS createdAt " +
//		       "FROM Transaction t WHERE t.memberId = :memberId")
//	List<Transaction> findByMemberId(@Param("memberId") int memberId);
	
	 @Query("SELECT t FROM Transaction t WHERE t.memberId = :memberId")
	    List<Transaction> findByMemberId(@Param("memberId") int memberId);
}
