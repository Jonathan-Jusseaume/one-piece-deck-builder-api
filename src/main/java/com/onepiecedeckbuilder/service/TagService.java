package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Tag;
import com.onepiecedeckbuilder.repository.TagRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> list(String languageCode) {
        return tagRepository.findAll()
                .stream()
                .map(tagEntity -> new Tag(tagEntity, languageCode))
                .sorted()
                .toList();
    }

}
