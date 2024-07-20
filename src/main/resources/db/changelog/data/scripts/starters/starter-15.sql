INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-15', '2024-10-25')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-15', 'en', '[ST-15] RED EDWARD.NEWGATE'),
       ('ST-15', 'fr', '[ST-15] RED EDWARD.NEWGATE')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST15-001', 1, 4, 4, 5000, NULL, 1000),
       ('ST15-002', 1, 2, 7, 8000, NULL, NULL),
       ('ST15-003', 1, 0, 3, 4000, NULL, 1000),
       ('ST15-004', 1, 4, 1, 2000, NULL, 2000),
       ('ST15-005', 1, 2, 5, 6000, NULL, 1000)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('OP02-001', 'OP02-001_p4.png', 0, 'ST-15'),
       ('OP02-008', 'OP02-008_p2.png', 5, 'ST-15'),
       ('OP02-018', 'OP02-018_p2.png', 5, 'ST-15'),
       ('OP02-019', 'OP02-019_p1.png', 2, 'ST-15'),
       ('OP02-023', 'OP02-023_p1.png', 1, 'ST-15'),
       ('OP03-003', 'OP03-003_p2.png', 5, 'ST-15'),
       ('OP03-006', 'OP03-006_p1.png', 1, 'ST-15'),
       ('OP03-007', 'OP03-007_p1.png', 1, 'ST-15'),
       ('OP03-009', 'OP03-009_p1.png', 1, 'ST-15'),
       ('OP03-010', 'OP03-010_p1.png', 1, 'ST-15'),
       ('ST15-001', 'ST15-001.png', 1, 'ST-15'),
       ('ST15-002', 'ST15-002.png', 3, 'ST-15'),
       ('ST15-003', 'ST15-003.png', 1, 'ST-15'),
       ('ST15-004', 'ST15-004.png', 1, 'ST-15'),
       ('ST15-005', 'ST15-005.png', 3, 'ST-15')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (0, 'ST15-001'),
       (0, 'ST15-002'),
       (0, 'ST15-003'),
       (0, 'ST15-004'),
       (0, 'ST15-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (51, 'ST15-001'),
       (25, 'ST15-002'),
       (51, 'ST15-002'),
       (51, 'ST15-003'),
       (51, 'ST15-004'),
       (51, 'ST15-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST15-001', 'en', 'Atmos',
        '[When Attacking] If your Leader is [Edward.Newgate], you cannot add Life cards to your hand using your own effects during this turn.'),
       ('ST15-001', 'fr', 'Atmos',
        '[When Attacking] If your Leader is [Edward.Newgate], you cannot add Life cards to your hand using your own effects during this turn.'),
       ('ST15-002', 'en', 'Edward.Newgate',
        '[On Play] Give up to 1 rested DON!! card to your Leader or 1 of your Characters. \n [Activate: Main] You may rest this Character: K.O. up to 1 of your opponent''s Characters with 5000 power or less.'),
       ('ST15-002', 'fr', 'Edward.Newgate',
        '[On Play] Give up to 1 rested DON!! card to your Leader or 1 of your Characters. \n [Activate: Main] You may rest this Character: K.O. up to 1 of your opponent''s Characters with 5000 power or less.'),
       ('ST15-003', 'en', 'Kingdew',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [Opponent''s Turn] When this Character is K.O.''d by an effect, up to 1 of your Leader gains +2000 power during this turn.'),
       ('ST15-003', 'fr', 'Kingdew',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [Opponent''s Turn] When this Character is K.O.''d by an effect, up to 1 of your Leader gains +2000 power during this turn.'),
       ('ST15-004', 'en', 'Thatch',
        '[On Play] If your Leader''s type includes "Whitebeard Pirates", give up to 1 of your opponent''s Characters −2000 power during this turn. Then, add 1 card from the top of your Life cards to your hand.'),
       ('ST15-004', 'fr', 'Thatch',
        '[On Play] If your Leader''s type includes "Whitebeard Pirates", give up to 1 of your opponent''s Characters −2000 power during this turn. Then, add 1 card from the top of your Life cards to your hand.'),
       ('ST15-005', 'en', 'Portgas.D.Ace',
        'If your Leader''s type includes "Whitebeard Pirates", this Character gains [Rush]. \n (This card can attack on the turn in which it is played.) \n [Once Per Turn] If this Character would be removed from the field by your opponent''s effect, you may give this Character −2000 power during this turn instead.'),
       ('ST15-005', 'fr', 'Portgas.D.Ace',
        'If your Leader''s type includes "Whitebeard Pirates", this Character gains [Rush]. \n (This card can attack on the turn in which it is played.) \n [Once Per Turn] If this Character would be removed from the field by your opponent''s effect, you may give this Character −2000 power during this turn instead.')
ON CONFLICT DO NOTHING;
