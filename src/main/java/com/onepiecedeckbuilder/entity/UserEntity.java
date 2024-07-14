package com.onepiecedeckbuilder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "UT_USER", schema = "public")
public class UserEntity {

    @Id
    @Column(name = "MAIL", nullable = false)
    private String mail;

    @Column(name = "JOIN_DATE")
    private Instant joinDate;

    @Column(name = "PROFILE_PICTURE")
    private String profilePicture;

}
