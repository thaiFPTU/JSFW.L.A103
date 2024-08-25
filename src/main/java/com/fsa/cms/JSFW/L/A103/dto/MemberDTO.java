package com.fsa.cms.JSFW.L.A103.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberDTO {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String role;
    private String description;
    private String phone;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
