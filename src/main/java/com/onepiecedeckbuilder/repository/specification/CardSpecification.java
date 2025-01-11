package com.onepiecedeckbuilder.repository.specification;

import com.onepiecedeckbuilder.dto.Color;
import com.onepiecedeckbuilder.dto.Rarity;
import com.onepiecedeckbuilder.dto.Type;
import com.onepiecedeckbuilder.entity.*;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.SetJoin;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.Set;

@UtilityClass
public class CardSpecification {

    public static Specification<CardEntity> distinct() {
        return (root, query, cb) -> {
            query.distinct(true);
            return null;
        };
    }

    public static Specification<CardEntity> byKeyword(String keyword) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            SetJoin<CardEntity, CardDescriptionEntity> join = root.joinSet(CardEntity_.DESCRIPTIONS);
            Predicate predicate = null;
            for (String word : keyword.split(" ")) {
                Predicate predicateWord;
                if (word.length() > 1 && word.charAt(0) == '!') {
                    predicateWord =
                            criteriaBuilder.and(
                                    criteriaBuilder.or(
                                            criteriaBuilder.isNull(join.get(CardDescriptionEntity_.EFFECT))
                                            , criteriaBuilder.not(
                                                    criteriaBuilder.like(criteriaBuilder.lower(join.get(CardDescriptionEntity_.EFFECT)),
                                                            "%" + word.substring(1).toLowerCase() + "%")
                                            )
                                    ),
                                    criteriaBuilder.not(criteriaBuilder.like(criteriaBuilder.lower(join.get("name")),
                                            "%" + word.substring(1).toLowerCase() + "%")));
                } else {
                    predicateWord =
                            criteriaBuilder.or(
                                    criteriaBuilder.like(criteriaBuilder.lower(join.get(CardDescriptionEntity_.EFFECT)), "%" + word.toLowerCase() + "%"),
                                    criteriaBuilder.like(criteriaBuilder.lower(join.get(CardDescriptionEntity_.NAME)), "%" + word.toLowerCase() + "%"));
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

    public static Specification<CardEntity> byType(Set<Type> types) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .in(root.get(CardEntity_.TYPE))
                .value(types);
    }

    public static Specification<CardEntity> byColor(Set<Color> colors) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            Join<CardEntity, Color> colorsJoin = root.join(CardEntity_.COLORS);
            return colorsJoin.in(colors);
        });
    }

    public static Specification<CardEntity> byTagId(Set<Long> tagsId) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            SetJoin<CardEntity, TagEntity> join = root.joinSet(CardEntity_.TAGS);
            return join.get(TagEntity_.ID).in(tagsId);
        });
    }

    public static Specification<CardEntity> byRarity(Set<Rarity> rarities) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            SetJoin<CardEntity, CardImageEntity> join = root.joinSet(CardEntity_.IMAGES);
            return join.get("rarity").in(rarities);
        });
    }

    public static Specification<CardEntity> byCost(Set<Integer> costs) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.and(
                        criteriaBuilder.isNotNull(root.get(CardEntity_.COST)),
                        criteriaBuilder.in(root.get(CardEntity_.COST)).value(costs)));
    }


    public static Specification<CardEntity> byPower(Set<Integer> powers) {
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.and(
                        criteriaBuilder.isNotNull(root.get(CardEntity_.POWER)),
                        criteriaBuilder.in(root.get(CardEntity_.POWER)).value(powers)));
    }

    public static Specification<CardEntity> byProductId(Set<String> productsId) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            SetJoin<CardEntity, CardImageEntity> join = root.joinSet(CardEntity_.IMAGES);
            return join.get(CardImageEntity_.PRODUCT).get(ProductEntity_.ID).in(productsId);
        });
    }
}
