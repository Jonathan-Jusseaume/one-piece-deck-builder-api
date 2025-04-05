package com.onepiecedeckbuilder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@Accessors(chain = true)
@SuperBuilder
@NoArgsConstructor
public class PaginationRequest {
    private Integer page;
    private Integer size;
    private String sort;
    private Sort.Direction direction;
}
