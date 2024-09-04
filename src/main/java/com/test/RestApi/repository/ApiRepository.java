package com.test.RestApi.repository;

import com.test.RestApi.entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRepository extends JpaRepository<Api, Long> {

}
