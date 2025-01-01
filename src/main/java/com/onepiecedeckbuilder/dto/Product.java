package com.onepiecedeckbuilder.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.onepiecedeckbuilder.entity.ProductDescriptionEntity;
import com.onepiecedeckbuilder.entity.ProductEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.ZoneOffset;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@EqualsAndHashCode
@Schema(description = "Represents a product with an identifier, release date, and label.")
public class Product implements Comparable<Product> {
    @Schema(description = "Unique identifier for the product", example = "OP01")
    private String id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @Schema(description = "Release date of the product", example = "2023-01-01")
    private LocalDate releaseDate;
    @Schema(description = "Label or name of the product", example = "[OP09] FOUR EMPERORS")
    private String label;

    public Product(ProductEntity productEntity, String languageCode) {
        this.id = productEntity.getId();
        this.releaseDate = LocalDate.ofInstant(productEntity.getReleaseDate(), ZoneOffset.UTC);
        for (ProductDescriptionEntity description : productEntity.getDescriptions()) {
            if (description.getLanguageCode().equals(languageCode)) {
                this.label = description.getName();
                break;
            }
        }
    }

    @Override
    public int compareTo(Product o) {
        return this.label.compareTo(o.getLabel());
    }
}
