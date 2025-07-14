package com.onepiecedeckbuilder.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@JsonDeserialize
@NoArgsConstructor
@EqualsAndHashCode
@Schema(
    description = "Represents a tag with an identifier and a label, used to categorize cards."
)
public class Tag {

    @Schema(description = "Unique identifier for the tag", example = "1")
    private Long id;

    @Schema(description = "The label of the tag", example = "Straw Hat Crew")
    private String label;
}
