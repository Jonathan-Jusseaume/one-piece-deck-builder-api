INSERT INTO UT_TYPE
VALUES (0),
       (1),
       (2),
       (3)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TYPE_DESCRIPTION
VALUES (0, 'en', 'Leader'),
       (0, 'fr', 'Capitaine'),
       (1, 'en', 'Character'),
       (1, 'fr', 'Personnage'),
       (2, 'en', 'Stage'),
       (2, 'fr', 'Terrain'),
       (3, 'en', 'Event'),
       (3, 'fr', 'Événement')
ON CONFLICT DO NOTHING;
