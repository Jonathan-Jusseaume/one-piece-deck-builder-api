package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Type;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TypeService {

    public List<Type> list() {
        return List.of(Type.values());
    }
}
