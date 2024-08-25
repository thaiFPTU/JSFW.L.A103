package com.fsa.cms.JSFW.L.A103.services.content;

import com.fsa.cms.JSFW.L.A103.dto.ContentDTO;
import com.fsa.cms.JSFW.L.A103.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContentService  {

    List<Content> findAll();

Content saveContent(Content content);

Optional<Content> findById(Long id);

void deleteById(Long id);


}
