package com.fsa.cms.JSFW.L.A103.services.security;

import com.fsa.cms.JSFW.L.A103.dto.MemberDTO;
import com.fsa.cms.JSFW.L.A103.dto.MemberRegisDTO;
import com.fsa.cms.JSFW.L.A103.entities.Member;
import com.fsa.cms.JSFW.L.A103.enums.Role;
import com.fsa.cms.JSFW.L.A103.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    public void addMember(MemberRegisDTO memberRegisDTO) {
    Member member = new Member();
        member.setUsername(memberRegisDTO.getMemberUsername());
 member.setPassword(passwordEncoder.encode(memberRegisDTO.getMemberPassword()));

 member.setEmail(memberRegisDTO.getMemberEmail());
member.setRole(Role.USER);
member.setCreatedDate(LocalDate.now());
memberRepository.save(member);
    }

    @Override
    public boolean existsByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Override
    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    @Override
    public void updateMember(MemberDTO memberDTO) {
//        member.setPassword(passwordEncoder.encode(member.getPassword()));
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Member existingMember = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        existingMember.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
        existingMember.setUpdatedDate(LocalDate.now());
        existingMember.setFirstname(memberDTO.getFirstname());
        existingMember.setLastname(memberDTO.getLastname());
        existingMember.setUsername(memberDTO.getUsername());
        existingMember.setEmail(memberDTO.getEmail());
        existingMember.setDescription(memberDTO.getDescription());
        existingMember.setPhone(memberDTO.getPhone());


        memberRepository.save(existingMember);
    }

    @Override
    public Member findByEmail(String email) {
         Optional<Member> member = memberRepository.findByEmail(email);
            return member.orElse(null);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> userOpt = memberRepository.findByEmail(email);
        if(userOpt.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }
        Member user = userOpt.get();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities(Collections.singletonList(user.getRole().name())));
    }

    private List<SimpleGrantedAuthority> grantedAuthorities(List<String> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
    }

}
