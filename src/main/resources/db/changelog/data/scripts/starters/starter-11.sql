INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-11', '2023-11-10')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-11', 'en', '[ST-11] SIDE UTA'),
       ('ST-11', 'fr', '[ST-11] SIDE UTA')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST11-001', 0, 2, NULL, 5000, 5, NULL),
       ('ST11-002', 1, 2, 3, 4000, NULL, 1000),
       ('ST11-003', 3, NULL, 2, NULL, NULL, NULL),
       ('ST11-004', 3, NULL, 1, NULL, NULL, NULL),
       ('ST11-005', 3, NULL, 3, NULL, NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('OP02-028', 'OP02-028_p2.png', 1, 'ST-11'),
       ('OP02-033', 'OP02-033_p2.png', 1, 'ST-11'),
       ('OP02-034', 'OP02-034_p2.png', 2, 'ST-11'),
       ('OP02-035', 'OP02-035_p3.png', 1, 'ST-11'),
       ('OP02-037', 'OP02-037_p2.png', 2, 'ST-11'),
       ('OP02-039', 'OP02-039_p2.png', 1, 'ST-11'),
       ('OP02-040', 'OP02-040_p2.png', 5, 'ST-11'),
       ('OP02-041', 'OP02-041_p3.png', 5, 'ST-11'),
       ('OP02-043', 'OP02-043_p2.png', 1, 'ST-11'),
       ('OP02-045', 'OP02-045_p2.png', 1, 'ST-11'),
       ('ST11-001', 'ST11-001.png', 0, 'ST-11'),
       ('ST11-002', 'ST11-002.png', 3, 'ST-11'),
       ('ST11-003', 'ST11-003.png', 1, 'ST-11'),
       ('ST11-004', 'ST11-004.png', 3, 'ST-11'),
       ('ST11-005', 'ST11-005.png', 1, 'ST-11')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (1, 'ST11-001'),
       (1, 'ST11-002'),
       (1, 'ST11-003'),
       (1, 'ST11-004'),
       (1, 'ST11-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (28, 'ST11-001'),
       (28, 'ST11-002'),
       (111, 'ST11-003'),
       (28, 'ST11-003'),
       (111, 'ST11-004'),
       (28, 'ST11-004'),
       (111, 'ST11-005'),
       (28, 'ST11-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST11-001', 'en', 'Uta',
        '[DON!! x1] [When Attacking] [Once Per Turn] Reveal 1 card from the top of your deck and add up to 1 {FILM} type card to your hand. Then, place the rest at the bottom of your deck.'),
       ('ST11-001', 'fr', 'Uta',
        '[DON!! x1] [When Attacking] [Once Per Turn] Reveal 1 card from the top of your deck and add up to 1 {FILM} type card to your hand. Then, place the rest at the bottom of your deck.'),
       ('ST11-002', 'en', 'Uta',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [End of Your Turn] You may trash 1 Event from your hand: Set up to 1 of your {FILM} type Characters as active.'),
       ('ST11-002', 'fr', 'Uta',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [End of Your Turn] You may trash 1 Event from your hand: Set up to 1 of your {FILM} type Characters as active.'),
       ('ST11-003', 'en', 'Backlight',
        '[Main] If your Leader is [Uta], choose one: \n • Rest up to 1 of your opponent''s Characters with a cost of 5 or less. \n • K.O. up to 1 of your opponent''s rested Characters with a cost of 5 or less.'),
       ('ST11-003', 'fr', 'Backlight',
        '[Main] If your Leader is [Uta], choose one: \n • Rest up to 1 of your opponent''s Characters with a cost of 5 or less. \n • K.O. up to 1 of your opponent''s rested Characters with a cost of 5 or less.'),
       ('ST11-004', 'en', 'New Genesis',
        '[Main] If your Leader is [Uta], look at 3 cards from the top of your deck; reveal up to 1 {FILM} type card other than [New Genesis] and add it to your hand. Then, place the rest at the bottom of your deck in any order and set up to 1 of your DON!! cards as active.'),
       ('ST11-004', 'fr', 'New Genesis',
        '[Main] If your Leader is [Uta], look at 3 cards from the top of your deck; reveal up to 1 {FILM} type card other than [New Genesis] and add it to your hand. Then, place the rest at the bottom of your deck in any order and set up to 1 of your DON!! cards as active.'),
       ('ST11-005', 'en', 'I''m invincible',
        '[MAIN] SET up TO 1 OF your [Uta] Leader AS active. \n [TRIGGER] Up TO 1 OF your Leader OR CHARACTER cards gains +1000 power during this turn.'),
       ('ST11-005', 'fr', 'I''m invincible',
        '[Main] Set up to 1 of your [Uta] Leader as active. \n [Trigger] Up to 1 of your Leader or Character cards gains +1000 power during this turn.')
ON CONFLICT DO NOTHING;
