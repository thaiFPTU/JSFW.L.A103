package com.fsa.cms.JSFW.L.A103.dto;

import com.fsa.cms.JSFW.L.A103.validation.PasswordMatch;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatch
public class MemberRegisDTO {

    @NotBlank(message = "Email must not be blank")
    private String memberEmail;
    @NotBlank(message = "Username must not be blank")
    private String memberUsername;
    @NotBlank(message = "Password must not be blank")
    private String memberPassword;

    private String confirmPassword;

}
