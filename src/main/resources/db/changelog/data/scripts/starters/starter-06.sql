INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-06', '2022-12-01')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-06', 'en', 'The Navy [ST-06]'),
       ('ST-06', 'fr', 'La Marine [ST-06]')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST06-001', 0, 2, NULL, 5000, 5, NULL),
       ('ST06-002', 1, 0, 1, 2000, NULL, 1000),
       ('ST06-003', 1, 4, 1, 3000, NULL, 1000),
       ('ST06-004', 1, 2, 5, 7000, NULL, NULL),
       ('ST06-005', 1, 3, 5, 6000, NULL, 1000),
       ('ST06-006', 1, 4, 3, 4000, NULL, 2000),
       ('ST06-007', 1, 3, 2, 2000, NULL, 1000),
       ('ST06-008', 1, 2, 3, 5000, NULL, NULL),
       ('ST06-009', 1, 0, 2, 4000, NULL, 1000),
       ('ST06-010', 1, 4, 2, 3000, NULL, 1000),
       ('ST06-011', 1, 4, 4, 6000, NULL, 1000),
       ('ST06-012', 1, 0, 5, 6000, NULL, NULL),
       ('ST06-013', 1, 4, 3, 5000, NULL, 1000),
       ('ST06-014', 3, NULL, 2, NULL, NULL, NULL),
       ('ST06-015', 3, NULL, 1, NULL, NULL, NULL),
       ('ST06-016', 3, NULL, 1, NULL, NULL, NULL),
       ('ST06-017', 2, NULL, 1, NULL, NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('ST06-001', 'ST06-001.png', 0, 'ST-06'),
       ('ST06-002', 'ST06-002.png', 1, 'ST-06'),
       ('ST06-003', 'ST06-003.png', 1, 'ST-06'),
       ('ST06-004', 'ST06-004.png', 3, 'ST-06'),
       ('ST06-005', 'ST06-005.png', 1, 'ST-06'),
       ('ST06-006', 'ST06-006.png', 1, 'ST-06'),
       ('ST06-007', 'ST06-007.png', 1, 'ST-06'),
       ('ST06-008', 'ST06-008.png', 1, 'ST-06'),
       ('ST06-009', 'ST06-009.png', 1, 'ST-06'),
       ('ST06-010', 'ST06-010.png', 1, 'ST-06'),
       ('ST06-011', 'ST06-011.png', 1, 'ST-06'),
       ('ST06-012', 'ST06-012.png', 3, 'ST-06'),
       ('ST06-013', 'ST06-013.png', 1, 'ST-06'),
       ('ST06-014', 'ST06-014.png', 1, 'ST-06'),
       ('ST06-015', 'ST06-015.png', 1, 'ST-06'),
       ('ST06-016', 'ST06-016.png', 1, 'ST-06'),
       ('ST06-017', 'ST06-017.png', 1, 'ST-06')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (4, 'ST06-001'),
       (4, 'ST06-002'),
       (4, 'ST06-003'),
       (4, 'ST06-004'),
       (4, 'ST06-005'),
       (4, 'ST06-006'),
       (4, 'ST06-007'),
       (4, 'ST06-008'),
       (4, 'ST06-009'),
       (4, 'ST06-010'),
       (4, 'ST06-011'),
       (4, 'ST06-012'),
       (4, 'ST06-013'),
       (4, 'ST06-014'),
       (4, 'ST06-015'),
       (4, 'ST06-016'),
       (4, 'ST06-017')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (8, 'ST06-001'),
       (8, 'ST06-002'),
       (8, 'ST06-003'),
       (8, 'ST06-004'),
       (8, 'ST06-005'),
       (8, 'ST06-006'),
       (8, 'ST06-007'),
       (8, 'ST06-008'),
       (8, 'ST06-009'),
       (8, 'ST06-010'),
       (8, 'ST06-011'),
       (8, 'ST06-012'),
       (8, 'ST06-013'),
       (8, 'ST06-014'),
       (8, 'ST06-015'),
       (8, 'ST06-016'),
       (8, 'ST06-017')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST06-001', 'en', 'Sakazuki',
        '[Activate: Main] [Once Per Turn] (3) (You may rest the specified number of DON!! cards in your cost area.) You may trash 1 card from your hand: K.O. up to 1 of your opponent''s Characters with a cost of 0.'),
       ('ST06-001', 'fr', 'Sakazuki',
        '[Activate: Main] [Once Per Turn] (3) (You may rest the specified number of DON!! cards in your cost area.) You may trash 1 card from your hand: K.O. up to 1 of your opponent''s Characters with a cost of 0.'),
       ('ST06-002', 'en', 'Koby',
        '[On Play] You may trash 1 card from your hand: K.O. up to 1 of your opponent''s Characters with a cost of 0.'),
       ('ST06-002', 'fr', 'Koby',
        '[On Play] You may trash 1 card from your hand: K.O. up to 1 of your opponent''s Characters with a cost of 0.'),
       ('ST06-003', 'en', 'Jango', NULL),
       ('ST06-003', 'fr', 'Jango', NULL),
       ('ST06-004', 'en', 'Smoker',
        'This Character cannot be K.O.''d by effects. \n [DON!! x1] If there is a Character with a cost of 0, this Character gains [Double Attack]. \n (This card deals 2 damage.)'),
       ('ST06-004', 'fr', 'Smoker',
        'This Character cannot be K.O.''d by effects. \n [DON!! x1] If there is a Character with a cost of 0, this Character gains [Double Attack]. \n (This card deals 2 damage.)'),
       ('ST06-005', 'en', 'Sengoku',
        '[When Attacking] Give up to 1 of your opponent''s Characters −4 cost during this turn.'),
       ('ST06-005', 'fr', 'Sengoku',
        '[When Attacking] Give up to 1 of your opponent''s Characters −4 cost during this turn.'),
       ('ST06-006', 'en', 'Tashigi',
        '[Activate: Main] You may rest this Character: Give up to 1 of your opponent''s Characters −2 cost during this turn.'),
       ('ST06-006', 'fr', 'Tashigi',
        '[Activate: Main] You may rest this Character: Give up to 1 of your opponent''s Characters −2 cost during this turn.'),
       ('ST06-007', 'en', 'Tsuru',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)'),
       ('ST06-007', 'fr', 'Tsuru',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.)'),
       ('ST06-008', 'en', 'Hina',
        '[On Play] Give up to 1 of your opponent''s Characters −4 cost during this turn.'),
       ('ST06-008', 'fr', 'Hina',
        '[On Play] Give up to 1 of your opponent''s Characters −4 cost during this turn.'),
       ('ST06-009', 'en', 'Fullbody', NULL),
       ('ST06-009', 'fr', 'Fullbody', NULL),
       ('ST06-010', 'en', 'Helmeppo',
        '[On Play] Give up to 1 of your opponent''s Characters −3 cost during this turn.'),
       ('ST06-010', 'fr', 'Hermep',
        '[On Play] Give up to 1 of your opponent''s Characters −3 cost during this turn.'),
       ('ST06-011', 'en', 'Momonga', NULL),
       ('ST06-011', 'fr', 'Momonga', NULL),
       ('ST06-012', 'en', 'Monkey D. Garp',
        '[Activate: Main] You may trash 1 card from your hand and rest this Character: K.O. up to 1 of your opponent''s Characters with a cost of 4 or less.'),
       ('ST06-012', 'fr', 'Monkey D. Garp',
        '[Activate: Main] You may trash 1 card from your hand and rest this Character: K.O. up to 1 of your opponent''s Characters with a cost of 4 or less.'),
       ('ST06-013', 'en', 'T-Bone', NULL),
       ('ST06-013', 'fr', 'T-Bone', NULL),
       ('ST06-014', 'en', 'Shockwave',
        '[Counter] Up to 1 of your Leader or Character cards gains +4000 power during this battle. Then, K.O. up to 1 of your opponent''s active Characters with a cost of 3 or less. \n [Trigger] K.O. up to 1 of your opponent''s Characters with a cost of 4 or less.'),
       ('ST06-014', 'fr', 'Shockwave',
        '[Counter] Up to 1 of your Leader or Character cards gains +4000 power during this battle. Then, K.O. up to 1 of your opponent''s active Characters with a cost of 3 or less. \n [Trigger] K.O. up to 1 of your opponent''s Characters with a cost of 4 or less.'),
       ('ST06-015', 'en', 'Great Eruption',
        '[Main] Draw 1 card. Then, give up to 1 of your opponent''s Characters −2 cost during this turn. \n [Trigger] Your opponent chooses 1 card from their hand and trashes it.'),
       ('ST06-015', 'fr', 'Great Eruption',
        '[Main] Draw 1 card. Then, give up to 1 of your opponent''s Characters −2 cost during this turn. \n [Trigger] Your opponent chooses 1 card from their hand and trashes it.'),
       ('ST06-016', 'en', 'White Out',
        '[Counter] Up to 1 of your Leader or Character cards gains +2000 power during this battle. \n [Trigger] Draw 1 card and none of your Characters can be K.O.''d during this turn.'),
       ('ST06-016', 'fr', 'White Out',
        '[Counter] Up to 1 of your Leader or Character cards gains +2000 power during this battle. \n [Trigger] Draw 1 card and none of your Characters can be K.O.''d during this turn.'),
       ('ST06-017', 'en', 'Navy HQ',
        '[On Play] Give up to 1 of your opponent''s Characters −1 cost during this turn. \n [Activate: Main] You may rest this Stage: If your Leader has the {Navy} type, give up to 1 of your opponent''s Characters −1 cost during this turn.'),
       ('ST06-017', 'fr', 'Navy HQ',
        '[On Play] Give up to 1 of your opponent''s Characters −1 cost during this turn. \n [Activate: Main] You may rest this Stage: If your Leader has the {Navy} type, give up to 1 of your opponent''s Characters −1 cost during this turn.')
ON CONFLICT DO NOTHING;
