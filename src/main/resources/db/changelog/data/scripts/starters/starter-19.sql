INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-19', '2024-10-25')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-19', 'en', '[ST-19] BLACK SMOKER'),
       ('ST-19', 'fr', '[ST-19] BLACK SMOKER')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST19-001', 1, 2, 6, 8000, NULL, NULL),
       ('ST19-002', 1, 3, 1, 1000, NULL, 1000),
       ('ST19-003', 1, 4, 5, 6000, NULL, 1000),
       ('ST19-004', 1, 2, 4, 6000, NULL, NULL),
       ('ST19-005', 1, 0, 3, 4000, NULL, 1000)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('OP02-093', 'OP02-093_p2.png', 0, 'ST-19'),
       ('OP02-098', 'OP02-098_p4.png', 5, 'ST-19'),
       ('OP02-106', 'OP02-106_p3.png', 2, 'ST-19'),
       ('OP02-108', 'OP02-108_p3.png', 1, 'ST-19'),
       ('OP02-109', 'OP02-109_p1.png', 1, 'ST-19'),
       ('OP02-113', 'OP02-113_p1.png', 2, 'ST-19'),
       ('OP02-116', 'OP02-116_p1.png', 1, 'ST-19'),
       ('OP02-117', 'OP02-117_p3.png', 2, 'ST-19'),
       ('OP03-079', 'OP03-079_p1.png', 2, 'ST-19'),
       ('OP03-089', 'OP03-089_p2.png', 5, 'ST-19'),
       ('ST19-001', 'ST19-001.png', 1, 'ST-19'),
       ('ST19-002', 'ST19-002.png', 1, 'ST-19'),
       ('ST19-003', 'ST19-003.png', 3, 'ST-19'),
       ('ST19-004', 'ST19-004.png', 3, 'ST-19'),
       ('ST19-005', 'ST19-005.png', 1, 'ST-19')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (4, 'ST19-001'),
       (4, 'ST19-002'),
       (4, 'ST19-003'),
       (4, 'ST19-004'),
       (4, 'ST19-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (8, 'ST19-001'),
       (8, 'ST19-002'),
       (8, 'ST19-003'),
       (8, 'ST19-004'),
       (8, 'ST19-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST19-001', 'en', 'Smoker',
        '[On Play] You may trash 1 black {Navy} type card from your hand: Up to 2 of your opponent''s Characters with a cost of 4 or less cannot attack until the end of your opponent''s next turn.'),
       ('ST19-001', 'fr', 'Smoker',
        '[On Play] You may trash 1 black {Navy} type card from your hand: Up to 2 of your opponent''s Characters with a cost of 4 or less cannot attack until the end of your opponent''s next turn.'),
       ('ST19-002', 'en', 'Sengoku',
        '[On Play] You may trash 2 black {Navy} type cards from your hand: If your Leader has the {Navy} type, draw 3 cards.'),
       ('ST19-002', 'fr', 'Sengoku',
        '[On Play] You may trash 2 black {Navy} type cards from your hand: If your Leader has the {Navy} type, draw 3 cards.'),
       ('ST19-003', 'en', 'Tashigi',
        '[On Play] If your Leader is [Smoker], give up to 1 of your opponent''s Characters −4 cost during this turn. \n [Activate: Main] [Once Per Turn] If this Character was played on this turn, trash up to 1 of your opponent''s Characters with a cost of 0.'),
       ('ST19-003', 'fr', 'Tashigi',
        '[On Play] If your Leader is [Smoker], give up to 1 of your opponent''s Characters −4 cost during this turn. \n [Activate: Main] [Once Per Turn] If this Character was played on this turn, trash up to 1 of your opponent''s Characters with a cost of 0.'),
       ('ST19-004', 'en', 'Hina',
        '[DON!! x1] [Opponent''s Turn] This Character gains +4 cost. \n [Activate: Main] [Once Per Turn] You may place 1 card from your trash at the bottom of your deck: Give up to 1 rested DON!! card to your Leader or 1 of your Characters.'),
       ('ST19-004', 'fr', 'Hina',
        '[DON!! x1] [Opponent''s Turn] This Character gains +4 cost. \n [Activate: Main] [Once Per Turn] You may place 1 card from your trash at the bottom of your deck: Give up to 1 rested DON!! card to your Leader or 1 of your Characters.'),
       ('ST19-005', 'en', 'Monkey.D.Garp',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [Activate: Main] [Once Per Turn] You may place 1 card from your trash at the bottom of your deck: Give up to 1 of your opponent''s Characters −1 cost during this turn.'),
       ('ST19-005', 'fr', 'Monkey.D.Garp',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [Activate: Main] [Once Per Turn] You may place 1 card from your trash at the bottom of your deck: Give up to 1 of your opponent''s Characters −1 cost during this turn.')
ON CONFLICT DO NOTHING;
