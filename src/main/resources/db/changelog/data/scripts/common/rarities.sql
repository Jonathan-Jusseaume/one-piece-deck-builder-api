INSERT INTO UT_RARITY
VALUES (0, 'L'),
       (1, 'C'),
       (2, 'UC'),
       (3, 'SR'),
       (4, 'SEC'),
       (5, 'R'),
       (6, 'SP CARD'),
       (7, 'P')
ON CONFLICT DO NOTHING;
