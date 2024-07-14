package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Attribute;
import com.onepiecedeckbuilder.repository.AttributeDao;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AttributeService {

    private final AttributeDao attributeDao;

    public List<Attribute> list(String languageCode) {
        return attributeDao.findAll()
                .stream()
                .map(attributeEntity -> new Attribute(attributeEntity, languageCode))
                .toList();
    }

}
