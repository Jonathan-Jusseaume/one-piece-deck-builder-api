package com.onepiecedeckbuilder.entity;

import com.onepiecedeckbuilder.entity.key.CardColorKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "UT_CARD_COLOR", schema = "public")
@IdClass(CardColorKey.class)
public class CardColorEntity {

    @Id
    @Column(name = "COLOR_ID", nullable = false)
    private Long colorId;

    @Id
    @Column(name = "CARD_ID", nullable = false)
    private String cardId;

}
