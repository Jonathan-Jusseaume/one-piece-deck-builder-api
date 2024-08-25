package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Attribute;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttributeService {

    public List<Attribute> list() {
        return List.of(Attribute.values());
    }

}
