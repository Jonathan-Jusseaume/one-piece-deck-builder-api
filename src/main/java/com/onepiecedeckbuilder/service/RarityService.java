package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Rarity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RarityService {

    public List<Rarity> list() {
        return List.of(Rarity.values());
    }
}
