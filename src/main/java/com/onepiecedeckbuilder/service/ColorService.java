package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Color;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorService {

    public List<Color> list() {
        return Arrays.asList(Color.values());
    }
}
