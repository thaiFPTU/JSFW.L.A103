package com.fsa.cms.JSFW.L.A103.validation;

import com.fsa.cms.JSFW.L.A103.dto.MemberRegisDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, MemberRegisDTO> {


    @Override
    public boolean isValid(MemberRegisDTO value, ConstraintValidatorContext context) {
        return value.getMemberPassword().equals(value.getConfirmPassword());
    }

}
