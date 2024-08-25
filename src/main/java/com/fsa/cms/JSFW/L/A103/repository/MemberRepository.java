package com.fsa.cms.JSFW.L.A103.repository;

import com.fsa.cms.JSFW.L.A103.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email);
    Member findByUsername(String username);
}
