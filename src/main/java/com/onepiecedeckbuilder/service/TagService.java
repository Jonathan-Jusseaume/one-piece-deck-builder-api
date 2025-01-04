package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Tag;
import com.onepiecedeckbuilder.mapper.TagMapper;
import com.onepiecedeckbuilder.repository.TagRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TagService {

    private final TagRepository tagRepository;

    private final TagMapper tagMapper;

    public List<Tag> list(String languageCode) {
        return tagRepository.findAll()
                .stream()
                .map(tagEntity -> new Tag(tagEntity, languageCode))
                .sorted(Comparator.comparing(Tag::getLabel))
                .toList();
    }

}
