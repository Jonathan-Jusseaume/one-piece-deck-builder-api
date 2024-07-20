INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-16', '2024-10-25')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-16', 'en', '[ST-16] GREEN UTA'),
       ('ST-16', 'fr', '[ST-16] GREEN UTA')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST16-001', 1, 2, 4, 6000, NULL, NULL),
       ('ST16-002', 1, 3, 2, NULL, NULL, 1000),
       ('ST16-003', 1, 0, 3, 4000, NULL, 1000),
       ('ST16-004', 1, 4, 9, 11000, NULL, NULL),
       ('ST16-005', 1, 0, 2, 3000, NULL, 2000)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('P-029', 'P-029_p1.png', 7, 'ST-16'),
       ('P-057', 'P-057_p1.png', 7, 'ST-16'),
       ('P-058', 'P-058_p1.png', 7, 'ST-16'),
       ('P-059', 'P-059_p1.png', 7, 'ST-16'),
       ('P-060', 'P-060_p1.png', 7, 'ST-16'),
       ('P-061', 'P-061_p1.png', 7, 'ST-16'),
       ('ST11-001', 'ST11-001_p1.png', 0, 'ST-16'),
       ('ST11-003', 'ST11-003_p2.png', 1, 'ST-16'),
       ('ST11-004', 'ST11-004_p2.png', 3, 'ST-16'),
       ('ST11-005', 'ST11-005_p2.png', 1, 'ST-16'),
       ('ST16-001', 'ST16-001.png', 3, 'ST-16'),
       ('ST16-002', 'ST16-002.png', 1, 'ST-16'),
       ('ST16-003', 'ST16-003.png', 1, 'ST-16'),
       ('ST16-004', 'ST16-004.png', 3, 'ST-16'),
       ('ST16-005', 'ST16-005.png', 1, 'ST-16')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (1, 'ST16-001'),
       (1, 'ST16-002'),
       (1, 'ST16-003'),
       (1, 'ST16-004'),
       (1, 'ST16-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (28, 'ST16-001'),
       (28, 'ST16-002'),
       (28, 'ST16-003'),
       (72, 'ST16-003'),
       (28, 'ST16-004'),
       (25, 'ST16-004'),
       (34, 'ST16-004'),
       (28, 'ST16-005'),
       (1, 'ST16-005'),
       (0, 'ST16-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST16-001', 'en', 'Uta',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [Activate: Main] [Once Per Turn] You may trash 1 {FILM} type card from your hand: Give up to 1 rested DON!! card to your Leader or 1 of your Characters.'),
       ('ST16-001', 'fr', 'Uta',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [Activate: Main] [Once Per Turn] You may trash 1 {FILM} type card from your hand: Give up to 1 rested DON!! card to your Leader or 1 of your Characters.'),
       ('ST16-002', 'en', 'Gordon',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Your Opponent''s Attack] You may trash any number of {Music} type cards from your hand. Your Leader or 1 of your Characters gains +1000 power during this battle for every card trashed.'),
       ('ST16-002', 'fr', 'Gordon',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Your Opponent''s Attack] You may trash any number of {Music} type cards from your hand. Your Leader or 1 of your Characters gains +1000 power during this battle for every card trashed.'),
       ('ST16-003', 'en', 'Charlotte Katakuri',
        'If your Leader has the {FILM} type and you have 6 or more rested cards, this Character gains +2000 power.'),
       ('ST16-003', 'fr', 'Charlotte Katakuri',
        'If your Leader has the {FILM} type and you have 6 or more rested cards, this Character gains +2000 power.'),
       ('ST16-004', 'en', 'Shanks', '[On Play] K.O. up to 1 of your opponent''s rested Characters.'),
       ('ST16-004', 'fr', 'Shanks', '[On Play] K.O. up to 1 of your opponent''s rested Characters.'),
       ('ST16-005', 'en', 'Monkey.D.Luffy', 'If you have a rested [Uta], this Character gains +1000 power.'),
       ('ST16-005', 'fr', 'Monkey.D.Luffy', 'If you have a rested [Uta], this Character gains +1000 power.')
ON CONFLICT DO NOTHING;
