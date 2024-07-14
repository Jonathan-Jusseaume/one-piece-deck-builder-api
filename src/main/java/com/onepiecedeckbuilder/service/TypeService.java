package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Type;
import com.onepiecedeckbuilder.repository.TypeDao;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TypeService {

    private final TypeDao typeDao;

    public List<Type> list(String languageCode) {
        return typeDao.findAll()
                .stream()
                .map(typeEntity -> new Type(typeEntity, languageCode))
                .toList();
    }

}