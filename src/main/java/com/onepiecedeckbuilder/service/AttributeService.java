package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Attribute;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttributeService {

    public List<Attribute> list() {
        return List.of(Attribute.values());
    }
}
