package com.fsa.cms.JSFW.L.A103.controllers;

import com.fsa.cms.JSFW.L.A103.entities.Content;
import com.fsa.cms.JSFW.L.A103.entities.Member;
import com.fsa.cms.JSFW.L.A103.repository.MemberRepository;
import com.fsa.cms.JSFW.L.A103.services.content.ContentService;
import com.fsa.cms.JSFW.L.A103.services.security.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/content")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;
    private final MemberRepository memberRepository;
    private final String BASE_PATH = "content/";

    @GetMapping("/view")
    public String getAllContent(Model model) {
        List<Content> contents = contentService.findAll();
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Member> member = memberRepository.findByEmail(email);
        long memberID = member.get().getId();
        model.addAttribute("memberid", memberID);
        model.addAttribute("contents", contents);
        return BASE_PATH + "view"; // view name
    }

    @GetMapping("/add")
    public String newContent(Model model) {

        Content anewContent = new Content();
        model.addAttribute("content", anewContent);
        return BASE_PATH + "add"; // view name
    }
    @PostMapping("/contentNew")
public String saveContent(@ModelAttribute Content content, BindingResult result,Model model){

        contentService.saveContent(content);
         return "redirect:/view";
    }

@GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("contentID") Long id, Model model) {
        Content exccontent = contentService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid content Id:" + id));
        model.addAttribute("content", exccontent);
        return BASE_PATH + "add";
    }
    @GetMapping("/deleteContent")
    public String deleteContent(@RequestParam("contentID") Long id) {
        contentService.deleteById(id);
        return "redirect:/view";
    }
}
