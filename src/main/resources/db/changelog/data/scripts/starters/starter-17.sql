INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-17', '2024-10-25')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-17', 'en', '[ST-17] BLUE DONQUIXOTE DOFLAMINGO'),
       ('ST-17', 'fr', '[ST-17] BLUE DONQUIXOTE DOFLAMINGO')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST17-001', 1, 2, 4, 5000, NULL, 1000),
       ('ST17-002', 1, 4, 4, 5000, NULL, 1000),
       ('ST17-003', 1, 4, 1, 2000, NULL, 2000),
       ('ST17-004', 1, 2, 4, 6000, NULL, NULL),
       ('ST17-005', 1, 2, 2, 3000, NULL, 1000)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('OP01-060', 'OP01-060_p2.png', 0, 'ST-17'),
       ('OP01-073', 'OP01-073_p3.png', 5, 'ST-17'),
       ('OP01-086', 'OP01-086_p1.png', 5, 'ST-17'),
       ('OP02-054', 'OP02-054_p1.png', 1, 'ST-17'),
       ('OP02-057', 'OP02-057_p1.png', 2, 'ST-17'),
       ('P-030', 'P-030_p1.png', 7, 'ST-17'),
       ('ST03-002', 'ST03-002_p1.png', 1, 'ST-17'),
       ('ST03-004', 'ST03-004_p3.png', 1, 'ST-17'),
       ('ST03-005', 'ST03-005_p3.png', 1, 'ST-17'),
       ('ST03-008', 'ST03-008_p6.png', 1, 'ST-17'),
       ('ST17-001', 'ST17-001.png', 1, 'ST-17'),
       ('ST17-002', 'ST17-002.png', 3, 'ST-17'),
       ('ST17-003', 'ST17-003.png', 1, 'ST-17'),
       ('ST17-004', 'ST17-004.png', 3, 'ST-17'),
       ('ST17-005', 'ST17-005.png', 1, 'ST-17')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (2, 'ST17-001'),
       (2, 'ST17-002'),
       (2, 'ST17-003'),
       (2, 'ST17-004'),
       (2, 'ST17-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (15, 'ST17-001'),
       (16, 'ST17-001'),
       (15, 'ST17-002'),
       (11, 'ST17-002'),
       (15, 'ST17-003'),
       (21, 'ST17-003'),
       (15, 'ST17-004'),
       (23, 'ST17-004'),
       (15, 'ST17-005'),
       (24, 'ST17-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST17-001', 'en', 'Crocodile',
        '[On Play] Reveal 1 card from the top of your deck. If that card is a {The Seven Warlords of the Sea} type card, draw 2 cards and place 1 card from your hand at the top of your deck.'),
       ('ST17-001', 'fr', 'Crocodile',
        '[On Play] Reveal 1 card from the top of your deck. If that card is a {The Seven Warlords of the Sea} type card, draw 2 cards and place 1 card from your hand at the top of your deck.'),
       ('ST17-002', 'en', 'Trafalgar Law',
        '[On Play] You may return 1 of your Characters to the owner''s hand: If your Leader has the {The Seven Warlords of the Sea} type, return up to 1 Character with a cost of 4 or less to the owner''s hand.'),
       ('ST17-002', 'fr', 'Trafalgar Law',
        '[On Play] You may return 1 of your Characters to the owner''s hand: If your Leader has the {The Seven Warlords of the Sea} type, return up to 1 Character with a cost of 4 or less to the owner''s hand.'),
       ('ST17-003', 'en', 'Buggy',
        '[On Play] Look at 3 cards from the top of your deck and place them at the top of your deck in any order.'),
       ('ST17-003', 'fr', 'Buggy',
        '[On Play] Look at 3 cards from the top of your deck and place them at the top of your deck in any order.'),
       ('ST17-004', 'en', 'Boa Hancock',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Play] Look at 3 cards from the top of your deck and place them at the top or bottom of your deck in any order. Then, give up to 1 rested DON!! card to 1 of your {The Seven Warlords of the Sea} type Leader or Character cards.'),
       ('ST17-004', 'fr', 'Boa Hancock',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Play] Look at 3 cards from the top of your deck and place them at the top or bottom of your deck in any order. Then, give up to 1 rested DON!! card to 1 of your {The Seven Warlords of the Sea} type Leader or Character cards.'),
       ('ST17-005', 'en', 'Marshall.D.Teach',
        '[Activate: Main] [Once Per Turn] You may place 1 card from your hand at the top of your deck: Give up to 2 rested DON!! cards to your Leader or 1 of your Characters.'),
       ('ST17-005', 'fr', 'Marshall.D.Teach',
        '[Activate: Main] [Once Per Turn] You may place 1 card from your hand at the top of your deck: Give up to 2 rested DON!! cards to your Leader or 1 of your Characters.')
ON CONFLICT DO NOTHING;
