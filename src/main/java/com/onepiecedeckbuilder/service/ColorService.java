package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Color;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService {

    public List<Color> list() {
        return Arrays.asList(Color.values());
    }

}
