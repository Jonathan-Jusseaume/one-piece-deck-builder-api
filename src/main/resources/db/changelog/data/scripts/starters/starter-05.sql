INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-05', '2022-12-01')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-05', 'en', 'ONE PIECE FILM edition [ST-05]'),
       ('ST-05', 'fr', 'ONE PIECE FILM edition [ST-05]')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST05-001', 0, 4, NULL, 5000, 5, NULL),
       ('ST05-002', 1, 2, 4, 5000, NULL, NULL),
       ('ST05-003', 1, 2, 2, 3000, NULL, NULL),
       ('ST05-004', 1, 2, 4, 5000, NULL, 1000),
       ('ST05-005', 1, 3, 2, 3000, NULL, 1000),
       ('ST05-006', 1, 2, 5, 6000, NULL, NULL),
       ('ST05-007', 1, 3, 1, 3000, NULL, 1000),
       ('ST05-008', 1, 4, 6, 7000, NULL, 1000),
       ('ST05-009', 1, 0, 2, 3000, NULL, 1000),
       ('ST05-010', 1, 0, 7, 8000, NULL, NULL),
       ('ST05-011', 1, 2, 8, 10000, NULL, NULL),
       ('ST05-012', 1, 2, 3, 5000, NULL, 1000),
       ('ST05-013', 1, 2, 4, 6000, NULL, 1000),
       ('ST05-014', 1, 3, 1, NULL, NULL, 2000),
       ('ST05-015', 1, 3, 2, 4000, NULL, 1000),
       ('ST05-016', 3, NULL, 3, NULL, NULL, NULL),
       ('ST05-017', 3, NULL, 2, NULL, NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('ST05-001', 'ST05-001.png', 0, 'ST-05'),
       ('ST05-002', 'ST05-002.png', 1, 'ST-05'),
       ('ST05-003', 'ST05-003.png', 1, 'ST-05'),
       ('ST05-004', 'ST05-004.png', 1, 'ST-05'),
       ('ST05-005', 'ST05-005.png', 1, 'ST-05'),
       ('ST05-006', 'ST05-006.png', 1, 'ST-05'),
       ('ST05-007', 'ST05-007.png', 1, 'ST-05'),
       ('ST05-008', 'ST05-008.png', 1, 'ST-05'),
       ('ST05-009', 'ST05-009.png', 1, 'ST-05'),
       ('ST05-010', 'ST05-010.png', 1, 'ST-05'),
       ('ST05-011', 'ST05-011.png', 1, 'ST-05'),
       ('ST05-012', 'ST05-012.png', 3, 'ST-05'),
       ('ST05-013', 'ST05-013.png', 3, 'ST-05'),
       ('ST05-014', 'ST05-014.png', 1, 'ST-05'),
       ('ST05-015', 'ST05-015.png', 1, 'ST-05'),
       ('ST05-016', 'ST05-016.png', 1, 'ST-05'),
       ('ST05-017', 'ST05-017.png', 1, 'ST-05')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (3, 'ST05-001'),
       (3, 'ST05-002'),
       (3, 'ST05-003'),
       (3, 'ST05-004'),
       (3, 'ST05-005'),
       (3, 'ST05-006'),
       (3, 'ST05-007'),
       (3, 'ST05-008'),
       (3, 'ST05-009'),
       (3, 'ST05-010'),
       (3, 'ST05-011'),
       (3, 'ST05-012'),
       (3, 'ST05-013'),
       (3, 'ST05-014'),
       (3, 'ST05-015'),
       (3, 'ST05-016'),
       (3, 'ST05-017')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (28, 'ST05-001'),
       (25, 'ST05-001'),
       (34, 'ST05-001'),
       (28, 'ST05-002'),
       (29, 'ST05-002'),
       (28, 'ST05-003'),
       (30, 'ST05-003'),
       (28, 'ST05-004'),
       (28, 'ST05-005'),
       (31, 'ST05-005'),
       (28, 'ST05-006'),
       (31, 'ST05-006'),
       (28, 'ST05-007'),
       (28, 'ST05-008'),
       (32, 'ST05-008'),
       (28, 'ST05-009'),
       (2, 'ST05-009'),
       (32, 'ST05-009'),
       (28, 'ST05-010'),
       (29, 'ST05-010'),
       (28, 'ST05-011'),
       (30, 'ST05-011'),
       (28, 'ST05-012'),
       (31, 'ST05-012'),
       (28, 'ST05-013'),
       (29, 'ST05-013'),
       (28, 'ST05-014'),
       (30, 'ST05-014'),
       (28, 'ST05-015'),
       (33, 'ST05-015'),
       (32, 'ST05-015'),
       (28, 'ST05-016'),
       (32, 'ST05-016'),
       (28, 'ST05-017'),
       (30, 'ST05-017')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST05-001', 'en', 'Shanks',
        '[Activate: Main] [Once Per Turn] DON!! −3 (You may return the specified number of DON!! cards from your field to your DON!! deck.): All of your {FILM} type Characters gain +2000 power during this turn.'),
       ('ST05-001', 'fr', 'Shanks',
        '[Activate: Main] [Once Per Turn] DON!! −3 (You may return the specified number of DON!! cards from your field to your DON!! deck.): All of your {FILM} type Characters gain +2000 power during this turn.'),
       ('ST05-002', 'en', 'Ain',
        '[On Play] Add up to 1 DON!! card from your DON!! deck and rest it.'),
       ('ST05-002', 'fr', 'Ain',
        '[On Play] Add up to 1 DON!! card from your DON!! deck and rest it.'),
       ('ST05-003', 'en', 'Ann',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)'),
       ('ST05-003', 'fr', 'Ann',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)'),
       ('ST05-004', 'en', 'Uta',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Block] DON!! −1 (You may return the specified number of DON!! cards from your field to your DON!! deck.): Rest up to 1 of your opponent''s Characters with a cost of 5 or less.'),
       ('ST05-004', 'fr', 'Uta',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Block] DON!! −1 (You may return the specified number of DON!! cards from your field to your DON!! deck.): Rest up to 1 of your opponent''s Characters with a cost of 5 or less.'),
       ('ST05-005', 'en', 'Carina',
        '[Activate: Main] [Once Per Turn] Rest this Character. You may trash 1 {FILM} type card from your hand: If your opponent has more DON!! cards on their field than you, add 2 DON!! cards from your DON!! deck and rest them.'),
       ('ST05-005', 'fr', 'Carina',
        '[Activate: Main] [Once Per Turn] Rest this Character. You may trash 1 {FILM} type card from your hand: If your opponent has more DON!! cards on their field than you, add 2 DON!! cards from your DON!! deck and rest them.'),
       ('ST05-006', 'en', 'Gild Tesoro',
        '[When Attacking] DON!! −2 (You may return the specified number of DON!! cards from your field to your DON!! deck.): Draw 2 cards.'),
       ('ST05-006', 'fr', 'Gild Tesoro',
        '[When Attacking] DON!! −2 (You may return the specified number of DON!! cards from your field to your DON!! deck.): Draw 2 cards.'),
       ('ST05-007', 'en', 'Gordon', NULL),
       ('ST05-007', 'fr', 'Gordon', NULL),
       ('ST05-008', 'en', 'Shiki',
        'If you have 8 or more DON!! cards on your field, this Character cannot be K.O.''d in battle.'),
       ('ST05-008', 'fr', 'Shiki',
        'If you have 8 or more DON!! cards on your field, this Character cannot be K.O.''d in battle.'),
       ('ST05-009', 'en', 'Scarlet', '[Trigger] Play this card'),
       ('ST05-009', 'fr', 'Scarlet', '[Trigger] Play this card'),
       ('ST05-010', 'en', 'Z',
        'When this Character battles <Strike> attribute Characters, this Character gains +3000 power during this turn. \n [Activate: Main] [Once Per Turn] DON!! −1 (You may return the specified number of DON!! cards from your field to your DON!! deck.): This Character gains +2000 power during this turn.'),
       ('ST05-010', 'fr', 'Z',
        'When this Character battles <Strike> attribute Characters, this Character gains +3000 power during this turn. \n [Activate: Main] [Once Per Turn] DON!! −1 (You may return the specified number of DON!! cards from your field to your DON!! deck.): This Character gains +2000 power during this turn.'),
       ('ST05-011', 'en', 'Douglas Bullet',
        '[Activate: Main] [Once Per Turn] DON!! −4 (You may return the specified number of DON!! cards from your field to your DON!! deck.): Rest up to 2 of your opponent''s Characters with a cost of 6 or less. Then, this Character gains [Double Attack] during this turn. \n (This card deals 2 damage.)'),
       ('ST05-011', 'fr', 'Douglas Bullet',
        '[Activate: Main] [Once Per Turn] DON!! −4 (You may return the specified number of DON!! cards from your field to your DON!! deck.): Rest up to 2 of your opponent''s Characters with a cost of 6 or less. Then, this Character gains [Double Attack] during this turn. \n (This card deals 2 damage.)'),
       ('ST05-012', 'en', 'Baccarat', NULL),
       ('ST05-012', 'fr', 'Baccarat', NULL),
       ('ST05-013', 'en', 'Bins', NULL),
       ('ST05-013', 'fr', 'Bins', NULL),
       ('ST05-014', 'en', 'Buena Festa',
        '[On Play] Look at 5 cards from the top of your deck; reveal up to 1 {FILM} type card other than [Buena Festa] and add it to your hand. Then, place the rest at the bottom of your deck in any order.'),
       ('ST05-014', 'fr', 'Buena Festa',
        '[On Play] Look at 5 cards from the top of your deck; reveal up to 1 {FILM} type card other than [Buena Festa] and add it to your hand. Then, place the rest at the bottom of your deck in any order.'),
       ('ST05-015', 'en', 'Dr. Indigo', NULL),
       ('ST05-015', 'fr', 'Dr. Indigo', NULL),
       ('ST05-016', 'en', 'Lion''s Threat Imperial Earth Bind',
        '[Main] DON!! −2 (You may return the specified number of DON!! cards from your field to your DON!! deck.): K.O. up to 1 of your opponent''s Characters with a cost of 5 or less. \n [Trigger] Add up to 1 DON!! card from your DON!! deck and set it as active.'),
       ('ST05-016', 'fr', 'Lion''s Threat Imperial Earth Bind',
        '[Main] DON!! −2 (You may return the specified number of DON!! cards from your field to your DON!! deck.): K.O. up to 1 of your opponent''s Characters with a cost of 5 or less. \n [Trigger] Add up to 1 DON!! card from your DON!! deck and set it as active.'),
       ('ST05-017', 'en', 'Union Armada',
        '[Counter] Up to 1 of your {FILM} type Leader or Character cards gains +4000 power during this battle. If that card is a Character, that Character cannot be K.O.''d during this turn. \n [Trigger] Add up to 1 DON!! card from your DON!! deck and set it as active.'),
       ('ST05-017', 'fr', 'Union Armada',
        '[Counter] Up to 1 of your {FILM} type Leader or Character cards gains +4000 power during this battle. If that card is a Character, that Character cannot be K.O.''d during this turn. \n [Trigger] Add up to 1 DON!! card from your DON!! deck and set it as active.')
ON CONFLICT DO NOTHING;