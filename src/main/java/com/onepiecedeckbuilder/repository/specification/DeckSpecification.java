package com.onepiecedeckbuilder.repository.specification;

import com.onepiecedeckbuilder.dto.Color;
import com.onepiecedeckbuilder.entity.*;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.SetJoin;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;


import java.util.Set;

@UtilityClass
public class DeckSpecification {

    public static Specification<DeckEntity> distinct() {
        return (root, query, cb) -> {
            query.distinct(true);
            return null;
        };
    }

    public static Specification<DeckEntity> byUserMail(String mail) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get(DeckEntity_.USER).get(UserEntity_.MAIL), mail));
    }

    public static Specification<DeckEntity> byKeyword(String keyword) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = null;
            for (String word : keyword.split(" ")) {
                Predicate predicateWord;
                if (word.length() > 1 && word.charAt(0) == '!') {
                    predicateWord =
                            criteriaBuilder.and(
                                    criteriaBuilder.or(
                                            criteriaBuilder.isNull(root.get(DeckEntity_.DESCRIPTION))
                                            , criteriaBuilder.not(
                                                    criteriaBuilder.like(criteriaBuilder.lower(root.get(DeckEntity_.DESCRIPTION)),
                                                            "%" + word.substring(1).toLowerCase() + "%")
                                            )
                                    ),
                                    criteriaBuilder.not(criteriaBuilder.like(criteriaBuilder.lower(root.get(DeckEntity_.NAME)),
                                            "%" + word.substring(1).toLowerCase() + "%")));
                } else {
                    predicateWord =
                            criteriaBuilder.or(
                                    criteriaBuilder.like(criteriaBuilder.lower(root.get(DeckEntity_.DESCRIPTION)), "%" + word.toLowerCase() + "%"),
                                    criteriaBuilder.like(criteriaBuilder.lower(root.get(DeckEntity_.NAME)), "%" + word.toLowerCase() + "%"));
                }

                if (predicate != null) {
                    predicate = criteriaBuilder.and(predicate, predicateWord);
                } else {
                    predicate = predicateWord;
                }
            }
            return predicate;
        });
    }

    public static Specification<DeckEntity> byColor(Set<Color> colors) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            Join<DeckEntity, CardEntity> leaderJoin = root.join(DeckEntity_.LEADER);
            Join<CardEntity, Color> colorsJoin = leaderJoin.join(CardEntity_.COLORS);
            return colorsJoin.in(colors);
        });
    }

    public static Specification<DeckEntity> byUserFavoriteDeck(String mail) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            SetJoin<DeckEntity, UserEntity> join = root.joinSet(DeckEntity_.USERS_FAVORITE);
            return join.get(UserEntity_.MAIL).in(mail);
        });
    }
}
