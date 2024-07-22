package com.example.authorizationserverservicespringboot.repository;

import com.example.authorizationserverservicespringboot.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
