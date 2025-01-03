package com.example.ecommerce.api.repository;

import com.example.ecommerce.api.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}
