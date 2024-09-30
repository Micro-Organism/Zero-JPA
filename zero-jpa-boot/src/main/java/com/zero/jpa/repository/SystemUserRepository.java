package com.zero.jpa.repository;

import com.zero.jpa.domain.entity.SystemUserEntity;
import org.springframework.data.repository.CrudRepository;

public interface SystemUserRepository extends CrudRepository<SystemUserEntity, String> {

}