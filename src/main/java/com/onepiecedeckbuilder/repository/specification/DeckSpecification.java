package com.onepiecedeckbuilder.repository.specification;

import com.onepiecedeckbuilder.entity.CardEntity;
import com.onepiecedeckbuilder.entity.ColorEntity;
import com.onepiecedeckbuilder.entity.DeckEntity;
import com.onepiecedeckbuilder.entity.UserEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.SetJoin;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;


import java.util.Set;

@UtilityClass
public class DeckSpecification {

    private static final String DESCRIPTION_FIELD = "description";

    public static Specification<DeckEntity> distinct() {
        return (root, query, cb) -> {
            query.distinct(true);
            return null;
        };
    }

    public static Specification<DeckEntity> byUserMail(String mail) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("user").get("mail"), mail));
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
                                            criteriaBuilder.isNull(root.get(DESCRIPTION_FIELD))
                                            , criteriaBuilder.not(
                                                    criteriaBuilder.like(criteriaBuilder.lower(root.get(DESCRIPTION_FIELD)),
                                                            "%" + word.substring(1).toLowerCase() + "%")
                                            )
                                    ),
                                    criteriaBuilder.not(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                                            "%" + word.substring(1).toLowerCase() + "%")));
                } else {
                    predicateWord =
                            criteriaBuilder.or(
                                    criteriaBuilder.like(criteriaBuilder.lower(root.get(DESCRIPTION_FIELD)), "%" + word.toLowerCase() + "%"),
                                    criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + word.toLowerCase() + "%"));
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

    public static Specification<DeckEntity> byColorId(Set<Long> colorsId) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            Join<DeckEntity, CardEntity> join = root.join("leader");
            SetJoin<CardEntity, ColorEntity> colorsJoin = join.joinSet("colors");
            return colorsJoin.get("id").in(colorsId);
        });
    }

    public static Specification<DeckEntity> byUserFavoriteDeck(String mail) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            SetJoin<DeckEntity, UserEntity> join = root.joinSet("usersFavorite");
            return join.get("mail").in(mail);
        });
    }
}
