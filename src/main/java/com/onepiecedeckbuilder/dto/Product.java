package com.onepiecedeckbuilder.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.onepiecedeckbuilder.entity.ProductDescriptionEntity;
import com.onepiecedeckbuilder.entity.ProductEntity;
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
public class Product implements Comparable<Product> {

    private String id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate releaseDate;

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
