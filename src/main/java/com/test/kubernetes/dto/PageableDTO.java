package com.test.kubernetes.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageableDTO<T> {
    private List<T> data;
    private int currentPage;
    private int totalPages;
    private int totalElements;
    private boolean hasNext;
    private boolean hasPrevious;
    @JsonProperty("isFirst")
    private boolean isFirst;
    @JsonProperty("isLast")
    private boolean isLast;

    public PageableDTO(Page<T> page) {
        this.data = page.getContent();
        this.currentPage = page.getNumber() + 1;
        this.totalPages = page.getTotalPages();
        this.totalElements = (int) page.getTotalElements();
        this.hasNext = page.hasNext();
        this.hasPrevious = page.hasPrevious();
        this.isFirst = page.isFirst();
        this.isLast = page.isLast();
    }
}
