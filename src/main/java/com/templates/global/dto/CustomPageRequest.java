package com.templates.global.dto;

import jakarta.validation.constraints.*;
import org.springframework.data.domain.*;


public record CustomPageRequest(
    @Min(0) int page,
    @Min(1) @Max(100) int size
) {

    public PageRequest toPageRequest() {
        return PageRequest.of(page, size);
    }
}