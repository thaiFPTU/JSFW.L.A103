package com.fsa.cms.JSFW.L.A103.services.content;

import com.fsa.cms.JSFW.L.A103.dto.ContentDTO;
import com.fsa.cms.JSFW.L.A103.entities.Content;
import com.fsa.cms.JSFW.L.A103.entities.Member;
import com.fsa.cms.JSFW.L.A103.repository.ContentRepository;
import com.fsa.cms.JSFW.L.A103.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService{

    private final ContentRepository contentRepository;
    private final MemberRepository memberRepository;

    @Override
    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    @Override
    public Content saveContent(Content content) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Member> member = memberRepository.findByEmail(email);
        Member member1 = member.orElseThrow(() -> new RuntimeException("Member not found"));
        content.setMember(member1);
return contentRepository.save(content);
    }

    @Override
    public Optional<Content> findById(Long id) {
        return contentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
contentRepository.deleteById(id);
    }
}
