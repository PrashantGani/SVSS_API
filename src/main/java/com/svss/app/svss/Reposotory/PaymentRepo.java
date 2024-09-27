package com.svss.app.svss.Reposotory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.svss.app.svss.Entity.Member;
import com.svss.app.svss.Entity.Payment;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer>
{
	
}