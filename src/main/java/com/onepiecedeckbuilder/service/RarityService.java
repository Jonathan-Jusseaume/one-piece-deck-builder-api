package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Rarity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RarityService {

    public List<Rarity> list() {
        return List.of(Rarity.values());
    }

}
