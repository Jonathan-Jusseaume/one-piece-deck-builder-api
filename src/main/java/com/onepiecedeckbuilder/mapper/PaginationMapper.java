package com.onepiecedeckbuilder.mapper;

import com.onepiecedeckbuilder.dto.PaginationRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class PaginationMapper {

    public Pageable getPageable(PaginationRequest request) {
        return PageRequest.of(
                request.getPage(),
                request.getSize(),
                request.getDirection(),
                request.getSort().split(",")
        );
    }

}
