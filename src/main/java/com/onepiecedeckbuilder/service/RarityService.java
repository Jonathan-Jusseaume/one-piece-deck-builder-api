package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Rarity;
import com.onepiecedeckbuilder.repository.RarityDao;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RarityService {

    private final RarityDao rarityDao;

    public List<Rarity> list() {
        return rarityDao.findAll()
                .stream()
                .map(Rarity::new)
                .sorted()
                .toList();
    }

}
