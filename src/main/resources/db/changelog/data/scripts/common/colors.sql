INSERT INTO UT_COLOR
VALUES (0),
       (1),
       (2),
       (3),
       (4),
       (5)
ON CONFLICT DO NOTHING;

INSERT INTO UT_COLOR_DESCRIPTION
VALUES (0, 'en', 'Red'),
       (0, 'fr', 'Rouge'),
       (1, 'en', 'Green'),
       (1, 'fr', 'Vert'),
       (2, 'en', 'Blue'),
       (2, 'fr', 'Bleu'),
       (3, 'en', 'Purple'),
       (3, 'fr', 'Violet'),
       (4, 'en', 'Black'),
       (4, 'fr', 'Noir'),
       (5, 'en', 'Yellow'),
       (5, 'fr', 'Jaune')
ON CONFLICT DO NOTHING;
