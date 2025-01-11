package com.onepiecedeckbuilder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@SuperBuilder
public class User {
    private String mail;
    private LocalDate creationDate;
    private String profilePicture;
}
