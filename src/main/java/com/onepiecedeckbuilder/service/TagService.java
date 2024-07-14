package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Tag;
import com.onepiecedeckbuilder.repository.TagDao;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TagService {

    private final TagDao tagDao;

    public List<Tag> list(String languageCode) {
        return tagDao.findAll()
                .stream()
                .map(tagEntity -> new Tag(tagEntity, languageCode))
                .sorted()
                .toList();
    }

}
