package com.onepiecedeckbuilder.dto;

import java.util.Collection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Accessors(chain = true)
@SuperBuilder
@NoArgsConstructor
public class PagingResultWithFilters<T, F> {

    private F activeFilters;
    private Collection<T> content;
    private Integer totalPages;
    private long totalElements;
    private Integer size;
    private Integer page;
    private boolean empty;

    public PagingResultWithFilters(
        Collection<T> content,
        Integer totalPages,
        long totalElements,
        Integer size,
        Integer page,
        boolean empty,
        F activeFilters
    ) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.size = size;
        this.page = page;
        this.empty = empty;
        this.activeFilters = activeFilters;
    }
}
