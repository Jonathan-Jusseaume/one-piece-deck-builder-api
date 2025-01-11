package com.onepiecedeckbuilder.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@EqualsAndHashCode
@Schema(description = "Represents a product with an identifier, release date, and label.")
public class Product {
    @Schema(description = "Unique identifier for the product", example = "OP01")
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @Schema(description = "Release date of the product", example = "2023-01-01")
    private LocalDate releaseDate;
    @Schema(description = "Label or name of the product", example = "[OP09] FOUR EMPERORS")
    private String label;
}
