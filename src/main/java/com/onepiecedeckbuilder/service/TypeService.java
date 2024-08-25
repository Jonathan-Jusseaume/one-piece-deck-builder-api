package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService {

    public List<Type> list() {
        return List.of(Type.values());
    }

}
