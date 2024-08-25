package com.fsa.cms.JSFW.L.A103.services.security;

import com.fsa.cms.JSFW.L.A103.dto.MemberDTO;
import com.fsa.cms.JSFW.L.A103.dto.MemberRegisDTO;
import com.fsa.cms.JSFW.L.A103.entities.Member;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;


public interface MemberService  extends UserDetailsService {
    void addMember(MemberRegisDTO memberRegisDTO);
    boolean existsByEmail(String email);
    Member findByUsername(String username);
    void updateMember(MemberDTO memberDTO);
    Member findByEmail(String email);
}
