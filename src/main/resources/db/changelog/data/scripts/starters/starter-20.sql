INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-20', '2024-10-25')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-20', 'en', '[ST-20] YELLOW CHARLOTTE KATAKURI'),
       ('ST-20', 'fr', '[ST-20] YELLOW CHARLOTTE KATAKURI')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST20-001', 1, 0, 5, 6000, NULL, 1000),
       ('ST20-002', 1, 4, 4, 5000, NULL, 1000),
       ('ST20-003', 1, 2, 3, 3000, NULL, 2000),
       ('ST20-004', 1, 3, 3, 2000, NULL, 1000),
       ('ST20-005', 1, 2, 6, 7000, NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('OP03-099', 'OP03-099_p2.png', 0, 'ST-20'),
       ('OP03-106', 'OP03-106_p1.png', 1, 'ST-20'),
       ('OP03-107', 'OP03-107_p1.png', 1, 'ST-20'),
       ('OP03-110', 'OP03-110_p1.png', 5, 'ST-20'),
       ('OP03-112', 'OP03-112_p5.png', 5, 'ST-20'),
       ('OP03-115', 'OP03-115_p1.png', 5, 'ST-20'),
       ('OP03-118', 'OP03-118_p1.png', 2, 'ST-20'),
       ('OP03-121', 'OP03-121_p3.png', 1, 'ST-20'),
       ('ST07-005', 'ST07-005_p1.png', 1, 'ST-20'),
       ('ST07-014', 'ST07-014_p1.png', 1, 'ST-20'),
       ('ST20-001', 'ST20-001.png', 3, 'ST-20'),
       ('ST20-002', 'ST20-002.png', 1, 'ST-20'),
       ('ST20-003', 'ST20-003.png', 1, 'ST-20'),
       ('ST20-004', 'ST20-004.png', 1, 'ST-20'),
       ('ST20-005', 'ST20-005.png', 3, 'ST-20')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (5, 'ST20-001'),
       (5, 'ST20-002'),
       (5, 'ST20-003'),
       (5, 'ST20-004'),
       (5, 'ST20-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (72, 'ST20-001'),
       (72, 'ST20-002'),
       (72, 'ST20-003'),
       (72, 'ST20-004'),
       (25, 'ST20-005'),
       (72, 'ST20-005')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST20-001', 'en', 'Charlotte Katakuri',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [Activate: Main] [Once Per Turn] You may turn 1 card from the top of your Life cards face-up: Give up to 1 rested DON!! card to your Leader or 1 of your Characters.'),
       ('ST20-001', 'fr', 'Charlotte Katakuri',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [Activate: Main] [Once Per Turn] You may turn 1 card from the top of your Life cards face-up: Give up to 1 rested DON!! card to your Leader or 1 of your Characters.'),
       ('ST20-002', 'en', 'Charlotte Cracker',
        '[Once Per Turn] If this Character would be K.O.''d by an effect, you may trash 1 card from the top of your Life cards instead. \n [Trigger] You may trash 1 card from your hand: Play this card.'),
       ('ST20-002', 'fr', 'Charlotte Cracker',
        '[Once Per Turn] If this Character would be K.O.''d by an effect, you may trash 1 card from the top of your Life cards instead. \n [Trigger] You may trash 1 card from your hand: Play this card.'),
       ('ST20-003', 'en', 'Charlotte Brulee',
        '[Trigger] Look at up to 1 card from the top of your or your opponent''s Life cards, and place it at the top or bottom of the Life cards. Then, add this card to your hand.'),
       ('ST20-003', 'fr', 'Charlotte Brulee',
        '[Trigger] Look at up to 1 card from the top of your or your opponent''s Life cards, and place it at the top or bottom of the Life cards. Then, add this card to your hand.'),
       ('ST20-004', 'en', 'Charlotte Pudding',
        '[On Play] You may add 1 card from the top of your Life cards to your hand: Set up to 1 of your {Big Mom Pirates} type Characters with a cost of 3 or less as active. \n [Trigger] Rest up to 1 of your opponent''s Characters with a cost of 3 or less.'),
       ('ST20-004', 'fr', 'Charlotte Pudding',
        '[On Play] You may add 1 card from the top of your Life cards to your hand: Set up to 1 of your {Big Mom Pirates} type Characters with a cost of 3 or less as active. \n [Trigger] Rest up to 1 of your opponent''s Characters with a cost of 3 or less.'),
       ('ST20-005', 'en', 'Charlotte Linlin',
        '[On Play] You may trash 1 card from your hand: Your opponent chooses one: \n • Your opponent trashes 2 cards from their hand. \n • Trash 1 card from the top of your opponent''s Life cards.'),
       ('ST20-005', 'fr', 'Charlotte Linlin',
        '[On Play] You may trash 1 card from your hand: Your opponent chooses one: \n • Your opponent trashes 2 cards from their hand. \n • Trash 1 card from the top of your opponent''s Life cards.')
ON CONFLICT DO NOTHING;
