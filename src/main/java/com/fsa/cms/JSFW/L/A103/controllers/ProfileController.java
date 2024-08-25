package com.fsa.cms.JSFW.L.A103.controllers;

import com.fsa.cms.JSFW.L.A103.dto.MemberDTO;
import com.fsa.cms.JSFW.L.A103.entities.Member;
import com.fsa.cms.JSFW.L.A103.services.security.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class ProfileController {
    private  final MemberService memberService;
    private final String BASE_PATH = "security/";

    @GetMapping("/showFormforUpdate")
    public String editProfile(Model model, Principal principal){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = memberService.findByEmail(email);
        model.addAttribute("memberUpdate", member);
        return BASE_PATH + "editprofile";
    }
    @PostMapping("/editprofile")
    public String editProfileSubmit(Model model, @Valid @ModelAttribute("member") MemberDTO memberDTO, BindingResult bindingResult) {
        memberDTO.setUpdatedDate(LocalDate.now());
        memberService.updateMember(memberDTO);
        return "redirect:/view";
    }
}
