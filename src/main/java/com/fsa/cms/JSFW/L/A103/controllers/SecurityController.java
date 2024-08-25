package com.fsa.cms.JSFW.L.A103.controllers;

import com.fsa.cms.JSFW.L.A103.dto.MemberRegisDTO;
import com.fsa.cms.JSFW.L.A103.entities.Member;
import com.fsa.cms.JSFW.L.A103.services.security.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class SecurityController {
    private  final MemberService memberService;
    private final String BASE_PATH = "security/";
    @GetMapping("/login")
    public String login() {
        return BASE_PATH +  "login";
    }

    @GetMapping("/register")
   public String showRegistrationForm(Model model){
        MemberRegisDTO memberRegisDTO = new MemberRegisDTO();
        model.addAttribute("memberRegisDTO", memberRegisDTO);
        return BASE_PATH + "register";
    }
    @PostMapping("/register")
    public String registerSubmit(Model model, @Valid @ModelAttribute("memberRegisDTO") MemberRegisDTO memberRegisDTO, BindingResult bindingResult) {

        if(memberService.existsByEmail(memberRegisDTO.getMemberEmail())){
            bindingResult.addError(new FieldError("memberRegisDTO", "memberUsername", "User already exists"));
        }

        if(bindingResult.hasErrors()){
            model.addAttribute("memberRegisDTO", memberRegisDTO);
            return BASE_PATH + "register";
        }
        memberService.addMember(memberRegisDTO);
        return "redirect:/login";
    }

}
