package com.apitest.API_restful_test.repository;

import com.apitest.API_restful_test.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepository extends JpaRepository<Token, Long> {
}
