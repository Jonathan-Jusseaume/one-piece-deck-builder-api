INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-18', '2024-10-25')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-18', 'en', '[ST-18] PURPLE MONKEY D. LUFFY'),
       ('ST-18', 'fr', '[ST-18] PURPLE MONKEY D. LUFFY')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST18-001', 1, 1, 3, 3000, NULL, 2000),
       ('ST18-002', 1, 2, 4, 2000, NULL, 1000),
       ('ST18-003', 1, 0, 5, 6000, NULL, 1000),
       ('ST18-004', 1, 4, 4, 6000, NULL, NULL),
       ('ST18-005', 1, 0, 7, 8000, NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('OP05-060', 'OP05-060_p3.png', 0, 'ST-18'),
       ('OP05-061', 'OP05-061_p1.png', 2, 'ST-18'),
       ('OP05-063', 'OP05-063_p1.png', 1, 'ST-18'),
       ('OP05-066', 'OP05-066_p1.png', 1, 'ST-18'),
       ('OP05-067', 'OP05-067_p3.png', 5, 'ST-18'),
       ('OP05-068', 'OP05-068_p1.png', 1, 'ST-18'),
       ('OP05-070', 'OP05-070_p1.png', 2, 'ST-18'),
       ('OP05-072', 'OP05-072_p1.png', 1, 'ST-18'),
       ('OP05-076', 'OP05-076_p1.png', 5, 'ST-18'),
       ('P-041', 'P-041_p5.png', 7, 'ST-18'),
       ('ST18-001', 'ST18-001.png', 1, 'ST-18'),
       ('ST18-002', 'ST18-002.png', 1, 'ST-18'),
       ('ST18-003', 'ST18-003.png', 1, 'ST-18'),
       ('ST18-004', 'ST18-004.png', 3, 'ST-18'),
       ('ST18-005', 'ST18-005.png', 3, 'ST-18')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (3, 'ST18-001'),
       (3, 'ST18-002'),
       (3, 'ST18-003'),
       (3, 'ST18-004'),
       (3, 'ST18-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (0, 'ST18-001'),
       (0, 'ST18-002'),
       (0, 'ST18-003'),
       (0, 'ST18-004'),
       (0, 'ST18-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST18-001', 'en', 'Uso-Hachi',
        '[On Play] If you have 8 or more DON!! cards on your field, rest up to 1 of your opponent''s Characters with a cost of 5 or less.'),
       ('ST18-001', 'fr', 'Uso-Hachi',
        '[On Play] If you have 8 or more DON!! cards on your field, rest up to 1 of your opponent''s Characters with a cost of 5 or less.'),
       ('ST18-002', 'en', 'O-Nami',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Play] If you have 8 or more DON!! cards on your field, trash 1 card from your hand and draw 2 cards.'),
       ('ST18-002', 'fr', 'O-Nami',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Play] If you have 8 or more DON!! cards on your field, trash 1 card from your hand and draw 2 cards.'),
       ('ST18-003', 'en', 'San-Gorou',
        '[When Attacking] [Once Per Turn] If you have 8 or more DON!! cards on your field, draw 1 card.'),
       ('ST18-003', 'fr', 'San-Gorou',
        '[When Attacking] [Once Per Turn] If you have 8 or more DON!! cards on your field, draw 1 card.'),
       ('ST18-004', 'en', 'Zoro-Juurou',
        '[On Play] Look at 5 cards from the top of your deck; reveal up to 1 purple {Straw Hat Crew} type card and add it to your hand. Then, place the rest at the bottom of your deck in any order.'),
       ('ST18-004', 'fr', 'Zoro-Juurou',
        '[On Play] Look at 5 cards from the top of your deck; reveal up to 1 purple {Straw Hat Crew} type card and add it to your hand. Then, place the rest at the bottom of your deck in any order.'),
       ('ST18-005', 'en', 'Luffy-Tarou',
        '[On Play] DON!! −1 (You may return the specified number of DON!! cards from your field to your DON!! deck.): Play up to 1 purple {Straw Hat Crew} type Character card with a cost of 5 or less from your hand.'),
       ('ST18-005', 'fr', 'Luffy-Tarou',
        '[On Play] DON!! −1 (You may return the specified number of DON!! cards from your field to your DON!! deck.): Play up to 1 purple {Straw Hat Crew} type Character card with a cost of 5 or less from your hand.')
ON CONFLICT DO NOTHING;
