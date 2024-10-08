package com.onepiecedeckbuilder.dto;

import com.onepiecedeckbuilder.entity.UserEntity;
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
public class User {

    private String mail;

    private LocalDate creationDate;

    private String profilePicture;

    public User(UserEntity userEntity) {
        this.setMail(userEntity.getMail())
                .setCreationDate(LocalDate.ofInstant(userEntity.getJoinDate(), ZoneOffset.UTC))
                .setProfilePicture(userEntity.getProfilePicture());
    }

    public UserEntity toEntity() {
        return new UserEntity()
                .setJoinDate(creationDate.atStartOfDay().toInstant(ZoneOffset.UTC))
                .setMail(mail)
                .setProfilePicture(profilePicture);
    }
}
