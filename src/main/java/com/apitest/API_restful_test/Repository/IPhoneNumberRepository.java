package com.apitest.API_restful_test.Repository;

import com.apitest.API_restful_test.Entity.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
}