INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-08', '2023-07-28')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-08', 'en', '[ST-08] Monkey D. Luffy'),
       ('ST-08', 'fr', '[ST-08] Monkey D. Luffy')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST08-001', 0, 0, NULL, 5000, 5, NULL),
       ('ST08-002', 1, 2, 2, 3000, NULL, NULL),
       ('ST08-003', 1, 3, 2, 4000, NULL, 1000),
       ('ST08-004', 1, 0, 4, 1000, NULL, 1000),
       ('ST08-005', 1, 4, 9, 10000, NULL, NULL),
       ('ST08-006', 1, 3, 4, NULL, NULL, 1000),
       ('ST08-007', 1, 4, 3, 1000, NULL, 1000),
       ('ST08-008', 1, 4, 1, 2000, NULL, 1000),
       ('ST08-009', 1, 3, 2, NULL, NULL, 2000),
       ('ST08-010', 1, 0, 5, 7000, NULL, 1000),
       ('ST08-011', 1, 0, 3, 5000, NULL, 1000),
       ('ST08-012', 1, 0, 4, 6000, NULL, 1000),
       ('ST08-013', 1, 0, 5, 6000, NULL, NULL),
       ('ST08-014', 3, NULL, 2, NULL, NULL, NULL),
       ('ST08-015', 3, NULL, 3, NULL, NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('ST08-001', 'ST08-001.png', 0, 'ST-08'),
       ('ST08-002', 'ST08-002.png', 3, 'ST-08'),
       ('ST08-003', 'ST08-003.png', 1, 'ST-08'),
       ('ST08-004', 'ST08-004.png', 1, 'ST-08'),
       ('ST08-005', 'ST08-005.png', 3, 'ST-08'),
       ('ST08-006', 'ST08-006.png', 1, 'ST-08'),
       ('ST08-007', 'ST08-007.png', 1, 'ST-08'),
       ('ST08-008', 'ST08-008.png', 1, 'ST-08'),
       ('ST08-009', 'ST08-009.png', 1, 'ST-08'),
       ('ST08-010', 'ST08-010.png', 1, 'ST-08'),
       ('ST08-011', 'ST08-011.png', 1, 'ST-08'),
       ('ST08-012', 'ST08-012.png', 1, 'ST-08'),
       ('ST08-013', 'ST08-013.png', 1, 'ST-08'),
       ('ST08-014', 'ST08-014.png', 1, 'ST-08'),
       ('ST08-015', 'ST08-015.png', 1, 'ST-08')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (4, 'ST08-001'),
       (4, 'ST08-002'),
       (4, 'ST08-003'),
       (4, 'ST08-004'),
       (4, 'ST08-005'),
       (4, 'ST08-006'),
       (4, 'ST08-007'),
       (4, 'ST08-008'),
       (4, 'ST08-009'),
       (4, 'ST08-010'),
       (4, 'ST08-011'),
       (4, 'ST08-012'),
       (4, 'ST08-013'),
       (4, 'ST08-014'),
       (4, 'ST08-015')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (0, 'ST08-001'),
       (28, 'ST08-002'),
       (76, 'ST08-003'),
       (8, 'ST08-004'),
       (34, 'ST08-005'),
       (70, 'ST08-006'),
       (3, 'ST08-007'),
       (60, 'ST08-008'),
       (52, 'ST08-009'),
       (8, 'ST08-010'),
       (0, 'ST08-011'),
       (2, 'ST08-012'),
       (57, 'ST08-013'),
       (0, 'ST08-014'),
       (0, 'ST08-015')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST08-001', 'en', 'Monkey.D.Luffy',
        '[Your Turn] When a Character is K.O.''d, give up to 1 rested DON!! card to this Leader.'),
       ('ST08-001', 'fr', 'Monkey.D.Luffy',
        '[Your Turn] When a Character is K.O.''d, give up to 1 rested DON!! card to this Leader.'),
       ('ST08-002', 'en', 'Uta',
        'This Character cannot be K.O.''d in battle by Leaders. \n [Activate: Main] You may rest this Character: Give up to 1 of your opponent''s Characters −2 cost during this turn.'),
       ('ST08-002', 'fr', 'Uta',
        'This Character cannot be K.O.''d in battle by Leaders. \n [Activate: Main] You may rest this Character: Give up to 1 of your opponent''s Characters −2 cost during this turn.'),
       ('ST08-003', 'en', 'Gaimon', NULL),
       ('ST08-003', 'fr', 'Gaimon', NULL),
       ('ST08-004', 'en', 'Koby',
        '[Activate: Main] You may rest this Character: K.O. up to 1 of your opponent''s Characters with a cost of 2 or less.'),
       ('ST08-004', 'fr', 'Koby',
        '[Activate: Main] You may rest this Character: K.O. up to 1 of your opponent''s Characters with a cost of 2 or less.'),
       ('ST08-005', 'en', 'Shanks',
        '[On Play] You may trash 1 card from your hand: K.O. all Characters with a cost of 1 or less.'),
       ('ST08-005', 'fr', 'Shanks',
        '[On Play] You may trash 1 card from your hand: K.O. all Characters with a cost of 1 or less.'),
       ('ST08-006', 'en', 'Shirahoshi',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Play] Give up to 1 of your opponent''s Characters −4 cost during this turn.'),
       ('ST08-006', 'fr', 'Shirahoshi',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Play] Give up to 1 of your opponent''s Characters −4 cost during this turn.'),
       ('ST08-007', 'en', 'Nefeltari Vivi',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [Trigger] Play this card.'),
       ('ST08-007', 'fr', 'Nefeltari Vivi',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [Trigger] Play this card.'),
       ('ST08-008', 'en', 'Higuma', '[On Play] Give up to 1 of your opponent''s Characters −2 cost during this turn.'),
       ('ST08-008', 'fr', 'Higuma', '[On Play] Give up to 1 of your opponent''s Characters −2 cost during this turn.'),
       ('ST08-009', 'en', 'Makino', '[On Play] If there is a Character with a cost of 0, draw 1 card.'),
       ('ST08-009', 'fr', 'Makino', '[On Play] If there is a Character with a cost of 0, draw 1 card.'),
       ('ST08-010', 'en', 'Monkey.D.Garp', NULL),
       ('ST08-010', 'fr', 'Monkey.D.Garp', NULL),
       ('ST08-011', 'en', 'Monkey.D.Luffy', NULL),
       ('ST08-011', 'fr', 'Monkey.D.Luffy', NULL),
       ('ST08-012', 'en', 'Laboon', NULL),
       ('ST08-012', 'fr', 'Laboon', NULL),
       ('ST08-013', 'en', 'Mr.2.Bon.Kurei(Bentham)',
        '[DON!! x1] At the end of a battle in which this Character battles your opponent''s Character, you may K.O. the opponent’s Character you battled with. If you do, K.O. this Character.'),
       ('ST08-013', 'fr', 'Mr.2.Bon.Kurei(Bentham)',
        '[DON!! x1] At the end of a battle in which this Character battles your opponent''s Character, you may K.O. the opponent’s Character you battled with. If you do, K.O. this Character.'),
       ('ST08-014', 'en', 'Gum-Gum Bell',
        '[Main] You may add 1 card from the top of your Life cards to your hand: Give up to 1 of your opponent''s Characters −7 cost during this turn. \n [Trigger] Add up to 1 black Character card with a cost of 2 or less from your trash to your hand.'),
       ('ST08-014', 'fr', 'Gum-Gum Bell',
        '[Main] You may add 1 card from the top of your Life cards to your hand: Give up to 1 of your opponent''s Characters −7 cost during this turn. \n [Trigger] Add up to 1 black Character card with a cost of 2 or less from your trash to your hand.'),
       ('ST08-015', 'en', 'Gum-Gum Pistol',
        '[Main] K.O. up to 1 of your opponent''s Characters with a cost of 2 or less. \n [Trigger] Draw 1 card.'),
       ('ST08-015', 'fr', 'Gum-Gum Pistol',
        '[Main] K.O. up to 1 of your opponent''s Characters with a cost of 2 or less. \n [Trigger] Draw 1 card.')
ON CONFLICT DO NOTHING;
