package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Attribute;
import com.onepiecedeckbuilder.repository.AttributeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AttributeService {

    private final AttributeRepository attributeRepository;

    public List<Attribute> list(String languageCode) {
        return attributeRepository.findAll()
                .stream()
                .map(attributeEntity -> new Attribute(attributeEntity, languageCode))
                .toList();
    }

}
