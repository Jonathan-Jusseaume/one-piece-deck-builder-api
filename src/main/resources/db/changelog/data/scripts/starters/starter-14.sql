INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-14', '2024-08-16')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-14', 'en', '[ST-14] 3D2Y'),
       ('ST-14', 'fr', '[ST-14] 3D2Y')
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG
VALUES (133)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION(TAG_ID, LANGUAGE_CODE, NAME)
VALUES (133, 'en', 'Bowin Island'),
       (133, 'fr', 'Bowin Island')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST14-001', 0, 0, NULL, 5000, 5, NULL),
       ('ST14-002', 1, 1, 3, 4000, NULL, 1000),
       ('ST14-003', 1, 0, 5, 6000, NULL, NULL),
       ('ST14-004', 1, 0, 3, 4000, NULL, 1000),
       ('ST14-005', 1, 3, 4, 6000, NULL, 1000),
       ('ST14-006', 1, 2, 3, 2000, NULL, 1000),
       ('ST14-007', 1, 0, 6, 7000, NULL, 1000),
       ('ST14-008', 1, 3, 1, NULL, NULL, 2000),
       ('ST14-009', 1, 2, 5, 6000, NULL, 1000),
       ('ST14-010', 1, 4, 5, 7000, NULL, 1000),
       ('ST14-011', 1, 3, 1, 2000, NULL, 2000),
       ('ST14-012', 1, 0, 8, 10000, NULL, NULL),
       ('ST14-013', 1, 4, 6, 8000, NULL, 1000),
       ('ST14-014', 3, NULL, 1, NULL, NULL, NULL),
       ('ST14-015', 3, NULL, 2, NULL, NULL, NULL),
       ('ST14-016', 3, NULL, 1, NULL, NULL, NULL),
       ('ST14-017', 2, NULL, 1, NULL, NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('ST14-001', 'ST14-001.png', 0, 'ST-14'),
       ('ST14-002', 'ST14-002.png', 1, 'ST-14'),
       ('ST14-003', 'ST14-003.png', 3, 'ST-14'),
       ('ST14-004', 'ST14-004.png', 1, 'ST-14'),
       ('ST14-005', 'ST14-005.png', 1, 'ST-14'),
       ('ST14-006', 'ST14-006.png', 3, 'ST-14'),
       ('ST14-007', 'ST14-007.png', 1, 'ST-14'),
       ('ST14-008', 'ST14-008.png', 1, 'ST-14'),
       ('ST14-009', 'ST14-009.png', 1, 'ST-14'),
       ('ST14-010', 'ST14-010.png', 1, 'ST-14'),
       ('ST14-011', 'ST14-011.png', 1, 'ST-14'),
       ('ST14-012', 'ST14-012.png', 1, 'ST-14'),
       ('ST14-013', 'ST14-013.png', 1, 'ST-14'),
       ('ST14-014', 'ST14-014.png', 1, 'ST-14'),
       ('ST14-015', 'ST14-015.png', 1, 'ST-14'),
       ('ST14-016', 'ST14-016.png', 1, 'ST-14'),
       ('ST14-017', 'ST14-017.png', 1, 'ST-14')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (4, 'ST14-001'),
       (4, 'ST14-002'),
       (4, 'ST14-003'),
       (4, 'ST14-004'),
       (4, 'ST14-005'),
       (4, 'ST14-006'),
       (4, 'ST14-007'),
       (4, 'ST14-008'),
       (4, 'ST14-009'),
       (4, 'ST14-010'),
       (4, 'ST14-011'),
       (4, 'ST14-012'),
       (4, 'ST14-013'),
       (4, 'ST14-014'),
       (4, 'ST14-015'),
       (4, 'ST14-016'),
       (4, 'ST14-017')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (0, 'ST14-001'),
       (0, 'ST14-002'),
       (0, 'ST14-003'),
       (4, 'ST14-004'),
       (18, 'ST14-004'),
       (2, 'ST14-005'),
       (0, 'ST14-005'),
       (0, 'ST14-006'),
       (0, 'ST14-007'),
       (88, 'ST14-008'),
       (0, 'ST14-009'),
       (0, 'ST14-010'),
       (133, 'ST14-011'),
       (0, 'ST14-012'),
       (0, 'ST14-013'),
       (0, 'ST14-014'),
       (0, 'ST14-015'),
       (0, 'ST14-016'),
       (0, 'ST14-017')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST14-001', 'en', 'Monkey.D.Luffy',
        '[DON!! x1] All of your Characters gain +1 cost. If you have a Character with a cost of 8 or more, this Leader gains +1000 power.'),
       ('ST14-001', 'fr', 'Monkey.D.Luffy',
        '[DON!! x1] All of your Characters gain +1 cost. If you have a Character with a cost of 8 or more, this Leader gains +1000 power.'),
       ('ST14-002', 'en', 'Usopp',
        '[DON!! x1] [When Attacking] If you have a Character with a cost of 8 or more, K.O. up to 1 of your opponent''s Characters with a cost of 4 or less.'),
       ('ST14-002', 'fr', 'Usopp',
        '[DON!! x1] [When Attacking] If you have a Character with a cost of 8 or more, K.O. up to 1 of your opponent''s Characters with a cost of 4 or less.'),
       ('ST14-003', 'en', 'Sanji',
        '[On Play] If you have a Character with a cost of 6 or more, K.O. up to 1 of your opponent''s Characters with a cost of 5 or less.'),
       ('ST14-003', 'fr', 'Sanji',
        '[On Play] If you have a Character with a cost of 6 or more, K.O. up to 1 of your opponent''s Characters with a cost of 5 or less.'),
       ('ST14-004', 'en', 'Jinbe',
        '[Activate: Main] [Once Per Turn] Up to 1 of your black {Straw Hat Crew} type Characters gains +2 cost until the end of your opponent''s next turn.'),
       ('ST14-004', 'fr', 'Jinbe',
        '[Activate: Main] [Once Per Turn] Up to 1 of your black {Straw Hat Crew} type Characters gains +2 cost until the end of your opponent''s next turn.'),
       ('ST14-005', 'en', 'Tony Tony.Chopper', NULL),
       ('ST14-005', 'fr', 'Tony Tony.Chopper', NULL),
       ('ST14-006', 'en', 'Nami',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Play] If you have 6 or less cards in your hand and a Character with a cost of 8 or more, draw 1 card.'),
       ('ST14-006', 'fr', 'Nami',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Play] If you have 6 or less cards in your hand and a Character with a cost of 8 or more, draw 1 card.'),
       ('ST14-007', 'en', 'Nico Robin',
        '[On Play]/[When Attacking] If you have a Character with a cost of 8 or more, give up to 1 of your opponent''s Characters −5 cost during this turn.'),
       ('ST14-007', 'fr', 'Nico Robin',
        '[On Play]/[When Attacking] If you have a Character with a cost of 8 or more, give up to 1 of your opponent''s Characters −5 cost during this turn.'),
       ('ST14-008', 'en', 'Haredas',
        '[Activate: Main] You may rest this Character: Up to 1 of your black {Straw Hat Crew} type Characters gains +2 cost until the end of your opponent''s next turn. Then, if you have a Character with a cost of 8 or more, draw 1 card and trash 1 card from your hand.'),
       ('ST14-008', 'fr', 'Haredas',
        '[Activate: Main] You may rest this Character: Up to 1 of your black {Straw Hat Crew} type Characters gains +2 cost until the end of your opponent''s next turn. Then, if you have a Character with a cost of 8 or more, draw 1 card and trash 1 card from your hand.'),
       ('ST14-009', 'en', 'Franky',
        '[DON!! x1] [Opponent''s Turn] If you have a Character with a cost of 6 or more, this Character cannot be K.O.''d by your opponent''s effects and gains +2000 power.'),
       ('ST14-009', 'fr', 'Franky',
        '[DON!! x1] [Opponent''s Turn] If you have a Character with a cost of 6 or more, this Character cannot be K.O.''d by your opponent''s effects and gains +2000 power.'),
       ('ST14-010', 'en', 'Brook', NULL),
       ('ST14-010', 'fr', 'Brook', NULL),
       ('ST14-011', 'en', 'Heracles',
        '[Activate: Main] You may rest this Character: Up to 1 of your black {Straw Hat Crew} type Characters gains +2 cost until the end of your opponent''s next turn.'),
       ('ST14-011', 'fr', 'Heracles',
        '[Activate: Main] You may rest this Character: Up to 1 of your black {Straw Hat Crew} type Characters gains +2 cost until the end of your opponent''s next turn.'),
       ('ST14-012', 'en', 'Monkey.D.Luffy',
        'If you have a Character with a cost of 10 or more, this Character gains [Rush]. \n (This card can attack on the turn in which it is played.)'),
       ('ST14-012', 'fr', 'Monkey.D.Luffy',
        'If you have a Character with a cost of 10 or more, this Character gains [Rush]. \n (This card can attack on the turn in which it is played.)'),
       ('ST14-013', 'en', 'Roronoa Zoro', NULL),
       ('ST14-013', 'fr', 'Roronoa Zoro', NULL),
       ('ST14-014', 'en', 'Gum-Gum Giant Rifle',
        '[Counter] If you have a Character with a cost of 8 or more, up to 1 of your Leader or Character cards gains +3000 power during this battle. \n [Trigger] Add up to 1 of your Character cards with a cost of 2 or less from your trash to your hand.'),
       ('ST14-014', 'fr', 'Gum-Gum Giant Rifle',
        '[Counter] If you have a Character with a cost of 8 or more, up to 1 of your Leader or Character cards gains +3000 power during this battle. \n [Trigger] Add up to 1 of your Character cards with a cost of 2 or less from your trash to your hand.'),
       ('ST14-015', 'en', 'Gum-Gum Diable Three-Swords Style Mouten Jet Six Hundred Pound Phoenix Cannon',
        '[Main] Up to 1 of your Leader or Character cards gains +3000 power during this turn. Then, if you have a Character with a cost of 8 or more, K.O. up to 1 of your opponent''s Characters with a cost of 2 or less. \n [Trigger] If you have a Character with a cost of 8 or more, K.O. up to 1 of your opponent''s Characters with a cost of 5 or less.'),
       ('ST14-015', 'fr', 'Gum-Gum Diable Three-Swords Style Mouten Jet Six Hundred Pound Phoenix Cannon',
        '[Main] Up to 1 of your Leader or Character cards gains +3000 power during this turn. Then, if you have a Character with a cost of 8 or more, K.O. up to 1 of your opponent''s Characters with a cost of 2 or less. \n [Trigger] If you have a Character with a cost of 8 or more, K.O. up to 1 of your opponent''s Characters with a cost of 5 or less.'),
       ('ST14-016', 'en', 'I Have My Crew!!',
        '[Main] Draw 1 card. Then, up to 1 of your Characters gains +3 cost until the end of your opponent''s next turn. \n [Trigger] K.O. up to 1 of your opponent''s Characters with a cost of 3 or less.'),
       ('ST14-016', 'fr', 'I Have My Crew!!',
        '[Main] Draw 1 card. Then, up to 1 of your Characters gains +3 cost until the end of your opponent''s next turn. \n [Trigger] K.O. up to 1 of your opponent''s Characters with a cost of 3 or less.'),
       ('ST14-017', 'en', 'Thousand Sunny',
        'All of your black {Straw Hat Crew} type Characters gain +1 cost. \n [On Play] If your Leader has the {Straw Hat Crew} type, draw 1 card.'),
       ('ST14-017', 'fr', 'Thousand Sunny',
        'All of your black {Straw Hat Crew} type Characters gain +1 cost. \n [On Play] If your Leader has the {Straw Hat Crew} type, draw 1 card.')
ON CONFLICT DO NOTHING;
