package com.axiom.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.axiom.api.entity.Mobile;


@Repository
public interface MobilesRepository extends MongoRepository<Mobile, Long> {

}
