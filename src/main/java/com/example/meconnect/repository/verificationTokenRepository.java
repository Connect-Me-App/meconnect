package com.example.meconnect.repository;

import com.example.meconnect.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface verificationTokenRepository extends JpaRepository<VerificationToken,Long> {

    VerificationToken save(VerificationToken verificationToken);
    VerificationToken  findByToken(String token);

    long deleteByToken(String token);
}
