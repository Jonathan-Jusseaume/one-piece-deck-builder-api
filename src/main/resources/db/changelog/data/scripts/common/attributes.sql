INSERT INTO UT_ATTRIBUTE
VALUES (0),
       (1),
       (2),
       (3),
       (4)
ON CONFLICT DO NOTHING;

INSERT INTO UT_ATTRIBUTE_DESCRIPTION
VALUES (0, 'en', 'Strike'),
       (0, 'fr', 'Mêlée'),
       (1, 'en', 'Ranged'),
       (1, 'fr', 'Distance'),
       (2, 'en', 'Special'),
       (2, 'fr', 'Spécial'),
       (3, 'en', 'Wisdom'),
       (3, 'fr', 'Intelligence'),
       (4, 'en', 'Slash'),
       (4, 'fr', 'Sabreur')
ON CONFLICT DO NOTHING;
