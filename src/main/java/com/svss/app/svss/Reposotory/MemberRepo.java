package com.svss.app.svss.Reposotory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.svss.app.svss.Entity.Member;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface MemberRepo extends JpaRepository<Member,Integer>
{
      Optional<Member> findOneByEmailAndPassword(String email, String password);

      Optional<Member> findByEmail(String email);
      
      Optional<Member> findByOtp(String otp);

	Optional<Member> findByPassword(String currentPassword);
}