package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Color;
import com.onepiecedeckbuilder.repository.ColorDao;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ColorService {

    private final ColorDao colorDao;

    public List<Color> list(String languageCode) {
        return colorDao.findAll()
                .stream()
                .map(colorEntity -> new Color(colorEntity, languageCode))
                .toList();
    }

}
