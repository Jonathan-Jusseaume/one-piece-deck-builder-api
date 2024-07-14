INSERT INTO UT_PRODUCT(ID, RELEASE_DATE)
VALUES ('ST-09', '2023-07-28')
ON CONFLICT DO NOTHING;

INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-09', 'en', '[ST-09] Yamato'),
       ('ST-09', 'fr', '[ST-09] Yamato')
ON CONFLICT DO NOTHING;
INSERT INTO UT_CARD (ID, TYPE_ID, ATTRIBUTE_ID, COST, POWER, LIFE, COUNTER)
VALUES ('ST09-001', 0, 0, NULL, 5000, 5, NULL),
       ('ST09-002', 1, 4, 4, 5000, NULL, 1000),
       ('ST09-003', 1, 0, 4, 6000, NULL, 1000),
       ('ST09-004', 1, 2, 4, 5000, NULL, 1000),
       ('ST09-005', 1, 4, 7, 7000, NULL, NULL),
       ('ST09-006', 1, 2, 2, 4000, NULL, 1000),
       ('ST09-007', 1, 2, 3, 2000, NULL, NULL),
       ('ST09-008', 1, 4, 5, 6000, NULL, NULL),
       ('ST09-009', 1, 4, 3, 4000, NULL, 1000),
       ('ST09-010', 1, 2, 6, 7000, NULL, NULL),
       ('ST09-011', 1, 0, 3, 5000, NULL, 1000),
       ('ST09-012', 1, 0, 3, 3000, NULL, 2000),
       ('ST09-013', 1, 2, 5, 7000, NULL, 1000),
       ('ST09-014', 3, NULL, 1, NULL, NULL, NULL),
       ('ST09-015', 3, NULL, 2, NULL, NULL, NULL)
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_IMAGE (CARD_ID, NAME, RARITY_ID, PRODUCT_ID)
VALUES ('ST09-001', 'ST09-001.png', 0, 'ST-09'),
       ('ST09-002', 'ST09-002.png', 1, 'ST-09'),
       ('ST09-003', 'ST09-003.png', 1, 'ST-09'),
       ('ST09-004', 'ST09-004.png', 1, 'ST-09'),
       ('ST09-005', 'ST09-005.png', 3, 'ST-09'),
       ('ST09-006', 'ST09-006.png', 1, 'ST-09'),
       ('ST09-007', 'ST09-007.png', 1, 'ST-09'),
       ('ST09-008', 'ST09-008.png', 1, 'ST-09'),
       ('ST09-009', 'ST09-009.png', 1, 'ST-09'),
       ('ST09-010', 'ST09-010.png', 3, 'ST-09'),
       ('ST09-011', 'ST09-011.png', 1, 'ST-09'),
       ('ST09-012', 'ST09-012.png', 1, 'ST-09'),
       ('ST09-013', 'ST09-013.png', 1, 'ST-09'),
       ('ST09-014', 'ST09-014.png', 1, 'ST-09'),
       ('ST09-015', 'ST09-015.png', 1, 'ST-09')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_COLOR (COLOR_ID, CARD_ID)
VALUES (5, 'ST09-001'),
       (5, 'ST09-002'),
       (5, 'ST09-003'),
       (5, 'ST09-004'),
       (5, 'ST09-005'),
       (5, 'ST09-006'),
       (5, 'ST09-007'),
       (5, 'ST09-008'),
       (5, 'ST09-009'),
       (5, 'ST09-010'),
       (5, 'ST09-011'),
       (5, 'ST09-012'),
       (5, 'ST09-013'),
       (5, 'ST09-014'),
       (5, 'ST09-015')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_TAG (TAG_ID, CARD_ID)
VALUES (35, 'ST09-001'),
       (35, 'ST09-002'),
       (26, 'ST09-003'),
       (25, 'ST09-004'),
       (26, 'ST09-004'),
       (35, 'ST09-005'),
       (43, 'ST09-005'),
       (35, 'ST09-006'),
       (43, 'ST09-006'),
       (35, 'ST09-007'),
       (35, 'ST09-008'),
       (35, 'ST09-009'),
       (35, 'ST09-010'),
       (51, 'ST09-010'),
       (35, 'ST09-011'),
       (0, 'ST09-011'),
       (35, 'ST09-012'),
       (35, 'ST09-013'),
       (35, 'ST09-014'),
       (35, 'ST09-015')
ON CONFLICT DO NOTHING;

INSERT INTO UT_CARD_DESCRIPTION (CARD_ID, LANGUAGE_CODE, NAME, EFFECT)
VALUES ('ST09-001', 'en', 'Yamato',
        '[DON!! x1] [Opponent''s Turn] If you have 2 or less Life cards, this Leader gains +1000 power.'),
       ('ST09-001', 'fr', 'Yamato',
        '[DON!! x1] [Opponent''s Turn] If you have 2 or less Life cards, this Leader gains +1000 power.'),
       ('ST09-002', 'en', 'Uzuki Tempura',
        '[Trigger] Rest up to 1 of your opponent''s Characters with a cost of 2 or less and add this card to your hand.'),
       ('ST09-002', 'fr', 'Uzuki Tempura',
        '[Trigger] Rest up to 1 of your opponent''s Characters with a cost of 2 or less and add this card to your hand.'),
       ('ST09-003', 'en', 'Ulti', NULL),
       ('ST09-003', 'fr', 'Ulti', NULL),
       ('ST09-004', 'en', 'Kaido',
        '[DON!! x1] If you have 2 or less Life cards, this Character cannot be K.O.''d in battle.'),
       ('ST09-004', 'fr', 'Kaido',
        '[DON!! x1] If you have 2 or less Life cards, this Character cannot be K.O.''d in battle.'),
       ('ST09-005', 'en', 'Kouzuki Oden',
        '[DON!! x1] This Character gains [Double Attack]. \n (This card deals 2 damage.) \n [On K.O.] You may trash 2 cards from your hand: Add up to 1 card from the top of your deck to the top of your Life cards.'),
       ('ST09-005', 'fr', 'Kouzuki Oden',
        '[DON!! x1] This Character gains [Double Attack]. \n (This card deals 2 damage.) \n [On K.O.] You may trash 2 cards from your hand: Add up to 1 card from the top of your deck to the top of your Life cards.'),
       ('ST09-006', 'en', 'Kouzuki Momonosuke', NULL),
       ('ST09-006', 'fr', 'Kouzuki Momonosuke', NULL),
       ('ST09-007', 'en', 'Shinobu',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Block] You may add 1 card from the top or bottom of your Life cards to your hand: This Character gains +4000 power during this battle.'),
       ('ST09-007', 'fr', 'Shinobu',
        '[Blocker] (After your opponent declares an attack, you may rest this card to make it the new target of the attack.) \n [On Block] You may add 1 card from the top or bottom of your Life cards to your hand: This Character gains +4000 power during this battle.'),
       ('ST09-008', 'en', 'Shimotsuki Ushimaru',
        '[DON!! x1] [When Attacking] You may add 1 card from the top or bottom of your Life cards to your hand: Play up to 1 yellow {Land of Wano} type Character card with a cost of 4 or less from your hand.'),
       ('ST09-008', 'fr', 'Shimotsuki Ushimaru',
        '[DON!! x1] [When Attacking] You may add 1 card from the top or bottom of your Life cards to your hand: Play up to 1 yellow {Land of Wano} type Character card with a cost of 4 or less from your hand.'),
       ('ST09-009', 'en', 'Fugetsu Omusubi',
        '[Trigger] K.O. up to 1 of your opponent''s Characters with a cost of 1 or less and add this card to your hand.'),
       ('ST09-009', 'fr', 'Fugetsu Omusubi',
        '[Trigger] K.O. up to 1 of your opponent''s Characters with a cost of 1 or less and add this card to your hand.'),
       ('ST09-010', 'en', 'Portgas.D.Ace',
        '[Once Per Turn] If this Character would be K.O.''d, you may trash 1 card from the top or bottom of your Life cards instead.'),
       ('ST09-010', 'fr', 'Portgas.D.Ace',
        '[Once Per Turn] If this Character would be K.O.''d, you may trash 1 card from the top or bottom of your Life cards instead.'),
       ('ST09-011', 'en', 'Monkey.D.Luffy', NULL),
       ('ST09-011', 'fr', 'Monkey.D.Luffy', NULL),
       ('ST09-012', 'en', 'Yamato',
        '[When Attacking] You may add 1 card from the top or bottom of your Life cards to your hand: This Character gains +2000 power until the start of your next turn.'),
       ('ST09-012', 'fr', 'Yamato',
        '[When Attacking] You may add 1 card from the top or bottom of your Life cards to your hand: This Character gains +2000 power until the start of your next turn.'),
       ('ST09-013', 'en', 'Yamato', NULL),
       ('ST09-013', 'fr', 'Yamato', NULL),
       ('ST09-014', 'en', 'Narikabura Arrow',
        '[Counter] If you have 2 or less Life cards, give up to 1 of your opponent''s Leader or Character cards −3000 power during this turn. \n [Trigger] You may trash 2 cards from your hand: Add up to 1 card from the top of your deck to the top of your Life cards.'),
       ('ST09-014', 'fr', 'Narikabura Arrow',
        '[Counter] If you have 2 or less Life cards, give up to 1 of your opponent''s Leader or Character cards −3000 power during this turn. \n [Trigger] You may trash 2 cards from your hand: Add up to 1 card from the top of your deck to the top of your Life cards.'),
       ('ST09-015', 'en', 'Thunder Bagua',
        '[Counter] Up to 1 of your Leader or Character cards gains +4000 power during this battle. Then, if you have 2 or less Life cards, add up to 1 of your opponent''s Characters with a cost of 3 or less to the top or bottom of the owner''s Life cards face-up. \n [Trigger] Draw 1 card.'),
       ('ST09-015', 'fr', 'Thunder Bagua',
        '[Counter] Up to 1 of your Leader or Character cards gains +4000 power during this battle. Then, if you have 2 or less Life cards, add up to 1 of your opponent''s Characters with a cost of 3 or less to the top or bottom of the owner''s Life cards face-up. \n [Trigger] Draw 1 card.')
ON CONFLICT DO NOTHING;

