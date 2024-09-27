package com.svss.app.svss.Reposotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.svss.app.svss.Entity.Loan;

@EnableJpaRepositories
@Repository
public interface LoanRepo extends JpaRepository<Loan, Integer>{

}
