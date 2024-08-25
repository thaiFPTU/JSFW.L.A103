package com.fsa.cms.JSFW.L.A103.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContentDTO {
    @NotBlank(message = "Title must not be blank")
    private String title;
    private String brief;
    private String contentWriter;
    private Long authorId;

}
