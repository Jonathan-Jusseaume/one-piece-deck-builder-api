-- INSERT AFTER FIRST STARTER --
INSERT INTO UT_TAG
VALUES (0),
       (1),
       (2),
       (3),
       (4)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION
VALUES (0, 'en', 'Straw Hat Crew'),
       (0, 'fr', 'Equipage du chapeau de paille'),
       (1, 'en', 'Supernovas'),
       (1, 'fr', 'Supernovas'),
       (2, 'en', 'Animal'),
       (2, 'fr', 'Animal'),
       (3, 'en', 'Alabasta'),
       (3, 'fr', 'Alabasta'),
       (4, 'en', 'Fish-Man'),
       (4, 'fr', 'Homme-poisson')
ON CONFLICT DO NOTHING;

-- INSERT AFTER SECOND STARTER --
INSERT INTO UT_TAG (ID)
VALUES (5),
       (6),
       (7),
       (8),
       (9),
       (10),
       (11),
       (12),
       (13),
       (14)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION
VALUES (5, 'en', 'Kid Pirates'),
       (5, 'fr', 'L''équipage de Kid'),
       (6, 'en', 'Firetank Pirates'),
       (6, 'fr', 'L''équipage du Firetank'),
       (7, 'en', 'Fallen Monk Pirates'),
       (7, 'fr', 'L''Équipage des Moines Dépravés'),
       (8, 'en', 'Navy'),
       (8, 'fr', 'Marine'),
       (9, 'en', 'Bonney Pirates'),
       (9, 'fr', 'L''équipage de Bonney'),
       (10, 'en', 'On-Air Pirates'),
       (10, 'fr', 'L''équipage du On-Air'),
       (11, 'en', 'Heart Pirates'),
       (11, 'fr', 'L''équipage du Heart'),
       (12, 'en', 'Hawkins Pirates'),
       (12, 'fr', 'L''équipage de Hawkins'),
       (13, 'en', 'Minks'),
       (13, 'fr', 'Minks'),
       (14, 'en', 'Drake Pirates'),
       (14, 'fr', 'L''équipage de Drake')
ON CONFLICT DO NOTHING;

-- INSERT AFTER THIRD STARTER --
INSERT INTO UT_TAG (ID)
VALUES (15),
       (16),
       (17),
       (18),
       (19),
       (20),
       (21),
       (22),
       (23),
       (24)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION
VALUES (15, 'en', 'The Seven Warlords of the Sea'),
       (15, 'fr', 'Les 7 Grands Corsaires'),
       (16, 'en', 'Baroque Works'),
       (16, 'fr', 'Baroque Works'),
       (17, 'en', 'Thriller Bark Pirates'),
       (17, 'fr', 'Les Pirates de Thriller Bark'),
       (18, 'en', 'The Sun Pirates'),
       (18, 'fr', 'Les Pirates du Soleil'),
       (19, 'en', 'Donquixote Pirates'),
       (19, 'fr', 'L''équipage de Donquixote'),
       (20, 'en', 'Revolutionary Army'),
       (20, 'fr', 'Armée Révolutionnaire'),
       (21, 'en', 'Buggy''s Delivery'),
       (21, 'fr', 'La Baggy compagnie'),
       (22, 'en', 'Biological Weapon'),
       (22, 'fr', 'Arme biologique'),
       (23, 'en', 'Kuja Pirates'),
       (23, 'fr', 'Les pirates Kuja'),
       (24, 'en', 'Blackbeard Pirates'),
       (24, 'fr', 'L''équipage de Barbe Noire')
ON CONFLICT DO NOTHING;

-- INSERT AFTER FOURTH STARTER --
INSERT INTO UT_TAG (ID)
VALUES (25),
       (26),
       (27)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION
VALUES (25, 'en', 'The Four Emperors'),
       (25, 'fr', 'Les 4 Empereurs'),
       (26, 'en', 'Animal Kingdom Pirates'),
       (26, 'fr', 'L''Équipage aux Cent Bêtes'),
       (27, 'en', 'Smile'),
       (27, 'fr', 'Smile')
ON CONFLICT DO NOTHING;

-- INSERT AFTER FIFTH STARTER --
INSERT INTO UT_TAG (ID)
VALUES (28),
       (29),
       (30),
       (31),
       (32),
       (33),
       (34)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION
VALUES (28, 'en', 'FILM'),
       (28, 'fr', 'FILM'),
       (29, 'en', 'Neo Navy'),
       (29, 'fr', 'Néo Marine'),
       (30, 'en', 'The Pirates Fest'),
       (30, 'fr', 'Pirate Festival'),
       (31, 'en', 'Grantesoro'),
       (31, 'fr', 'Grantesoro'),
       (32, 'en', 'Golden Lion Pirates'),
       (32, 'fr', 'Les Pirates du Lion d''Or'),
       (33, 'en', 'Scientist'),
       (33, 'fr', 'Scientifique'),
       (34, 'en', 'Red-Haired Pirates'),
       (34, 'fr', 'L''équipage du Roux')
ON CONFLICT DO NOTHING;

-- INSERT AFTER OP-01 --
INSERT INTO UT_TAG
VALUES (35),
       (36),
       (37),
       (38),
       (39),
       (40),
       (41),
       (42),
       (43),
       (44),
       (45),
       (46),
       (47),
       (48),
       (49),
       (50)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION (TAG_ID, LANGUAGE_CODE, NAME)
VALUES (35, 'en', 'Land of Wano'),
       (35, 'fr', 'Pays des Wa'),
       (36, 'en', 'Caribou Pirates'),
       (36, 'fr', 'Les pirates de Caribou'),
       (37, 'en', 'Beautiful Pirates'),
       (37, 'fr', 'L''Équipage des Magnifiques Pirates'),
       (38, 'en', 'Happosui Army'),
       (38, 'fr', 'Flotte de Happou'),
       (39, 'en', 'Giant'),
       (39, 'fr', 'Géant'),
       (40, 'en', 'New Giant Pirates'),
       (40, 'fr', 'Les Nouveaux Pirates Géants'),
       (41, 'en', 'Barto Club'),
       (41, 'fr', 'Barto Club'),
       (42, 'en', 'Former Whitebeard Pirates'),
       (42, 'fr', 'L''ancien équipage de Barbe Blanche'),
       (43, 'en', 'Kouzuki Clan'),
       (43, 'fr', 'Clan Kozuki'),
       (44, 'en', 'The Akazaya Nine'),
       (44, 'fr', 'Les Neux Fourreaux Rouges'),
       (45, 'en', 'Arlong Pirates'),
       (45, 'fr', 'L''équipage d''Arlong'),
       (46, 'en', 'Buggy Pirates'),
       (46, 'fr', 'L''équipage de Baggy'),
       (47, 'en', 'Punk Hazard'),
       (47, 'fr', 'Punk Hazard'),
       (48, 'en', 'Krieg Pirates'),
       (48, 'fr', 'L''équipage de Krieg'),
       (49, 'en', 'Dressrosa'),
       (49, 'fr', 'Dressrosa'),
       (50, 'en', 'Kurozumi Clan'),
       (50, 'fr', 'Clan Kurozumi')
ON CONFLICT DO NOTHING;

-- INSERT AFTER OP-02 --
INSERT INTO UT_TAG
VALUES (51),
       (52),
       (53),
       (54),
       (55),
       (56),
       (57),
       (58),
       (59),
       (60)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION(TAG_ID, LANGUAGE_CODE, NAME)
VALUES (51, 'en', 'Whitebeard Pirates'),
       (51, 'fr', 'Les Pirates de Barbe Blanche'),
       (52, 'en', 'Windmill Village'),
       (52, 'fr', 'Village de Fuchsia'),
       (53, 'en', 'Whitebeard Pirates Allies'),
       (53, 'fr', 'Les Alliés de Barbe Blanche'),
       (54, 'en', 'Spade Pirates'),
       (54, 'fr', 'L''Équipage des Spade'),
       (55, 'en', 'Impel Down'),
       (55, 'fr', 'Impel Down'),
       (56, 'en', 'World Pirates'),
       (56, 'fr', 'L''Équipage des Pirates Worlds'),
       (57, 'en', 'Former Baroque Works'),
       (57, 'fr', 'Ancien du Baroque Works'),
       (58, 'en', 'Jailer Beast'),
       (58, 'fr', 'Garde Bestial'),
       (59, 'en', 'Former Navy'),
       (59, 'fr', 'Ancien Marine'),
       (60, 'en', 'Mountain Bandits'),
       (60, 'fr', 'Bandits des Montagnes')
ON CONFLICT DO NOTHING;

-- INSERT AFTER OP03 --
INSERT INTO UT_TAG
VALUES (61),
       (62),
       (63),
       (64),
       (65),
       (66),
       (67),
       (68),
       (69),
       (70),
       (71),
       (72),
       (73),
       (74),
       (75),
       (76)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION(TAG_ID, LANGUAGE_CODE, NAME)
VALUES (61, 'en', 'Alvida Pirates'),
       (61, 'fr', 'Alvida Pirates'),
       (62, 'en', 'CP7'),
       (62, 'fr', 'CP7'),
       (63, 'en', 'Galley-La Company'),
       (63, 'fr', 'Galley-La Company'),
       (64, 'en', 'Water Seven'),
       (64, 'fr', 'Water Seven'),
       (65, 'en', 'Odyssey'),
       (65, 'fr', 'Odyssey'),
       (66, 'en', 'CP9'),
       (66, 'fr', 'CP9'),
       (67, 'en', 'Sniper Island'),
       (67, 'fr', 'L''île des Snipers'),
       (68, 'en', 'Homies'),
       (68, 'fr', 'Homies'),
       (69, 'en', 'The Franky Family'),
       (69, 'fr', 'La Franky Family'),
       (70, 'en', 'Merfolk'),
       (70, 'fr', 'Sirènes'),
       (71, 'en', 'Black Cat Pirates'),
       (71, 'fr', 'L''Équipage du Chat Noir'),
       (72, 'en', 'Big Mom Pirates'),
       (72, 'fr', 'L''Équipage de Big Mom'),
       (73, 'en', 'CP6'),
       (73, 'fr', 'CP6'),
       (74, 'en', 'World Government'),
       (74, 'fr', 'Gouvernement Mondial'),
       (75, 'en', 'The Vinsmoke Family'),
       (75, 'fr', 'La Famille Vinsmoke'),
       (76, 'en', 'East Blue'),
       (76, 'fr', 'East Blue')
ON CONFLICT DO NOTHING;

-- INSERT AFTER OP04 --
INSERT INTO UT_TAG
VALUES (77),
       (78),
       (79),
       (80),
       (81),
       (82)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION(TAG_ID, LANGUAGE_CODE, NAME)
VALUES (77, 'en', 'CP0'),
       (77, 'fr', 'CP0'),
       (78, 'en', 'Whole Cake Island'),
       (78, 'fr', 'Whole Cake Island'),
       (79, 'en', 'Yonta Maria Fleet'),
       (79, 'fr', 'Flotte Yonta Maria'),
       (80, 'en', 'The Tontattas'),
       (80, 'fr', 'Les Tontattas'),
       (81, 'en', 'Plague'),
       (81, 'fr', 'Virus'),
       (82, 'en', 'The House Of Lambs'),
       (82, 'fr', 'Bergerie')
ON CONFLICT DO NOTHING;


INSERT INTO UT_TAG
VALUES (83),
       (84)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION(TAG_ID, LANGUAGE_CODE, NAME)
VALUES (83, 'en', 'Bellamy Pirates'),
       (83, 'fr', 'Les Pirates de Bellamy'),
       (84, 'en', 'Jellyfish Pirates'),
       (84, 'fr', 'Les Pirates de Jellyfish')
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG
VALUES (85),
       (86),
       (87),
       (88),
       (89),
       (90),
       (91)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION(TAG_ID, LANGUAGE_CODE, NAME)
VALUES (85, 'en', 'Celestial Dragons'),
       (85, 'fr', 'Dragons Célestes'),
       (86, 'en', 'The Moon'),
       (86, 'fr', 'La Lune'),
       (87, 'en', 'Goa Kingdom'),
       (87, 'fr', 'Royaume de Goa'),
       (88, 'en', 'Sky Island'),
       (88, 'fr', 'Ile Céleste'),
       (89, 'en', 'Kingdom Of Prodence'),
       (89, 'fr', 'Royaume de Prodence'),
       (90, 'en', 'Mary Geoise'),
       (90, 'fr', 'Mary Geoise'),
       (91, 'en', 'Vassals'),
       (91, 'fr', 'Vassaux')
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG
VALUES (92),
       (93),
       (94),
       (95),
       (96),
       (97),
       (98),
       (99),
       (100),
       (101),
       (102),
       (103),
       (104),
       (105),
       (106),
       (107),
       (108),
       (109),
       (110)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION(TAG_ID, LANGUAGE_CODE, NAME)
VALUES (92, 'en', 'Omatsuri Island'),
       (92, 'fr', 'Omatsuri Island'),
       (93, 'en', 'Eldoraggo Crew'),
       (93, 'fr', 'Eldoraggo Crew'),
       (94, 'en', 'Shipbuilding Town'),
       (94, 'fr', 'Shipbuilding Town'),
       (95, 'en', 'Former Arlong Pirates'),
       (95, 'fr', 'Former Arlong Pirates'),
       (96, 'en', 'Asuka Island'),
       (96, 'fr', 'Asuka Island'),
       (97, 'en', 'Kingdom Of Germa'),
       (97, 'fr', 'Kingdom Of Germa'),
       (98, 'en', 'Gasparde Pirates'),
       (98, 'fr', 'Gasparde Pirates'),
       (99, 'en', 'New Fish-Man Pirates'),
       (99, 'fr', 'New Fish-Man Pirates'),
       (100, 'en', 'Mecha Island'),
       (100, 'fr', 'Mecha Island'),
       (101, 'en', 'Flying Pirates'),
       (101, 'fr', 'Flying Pirates'),
       (102, 'en', 'Gyro Pirates'),
       (102, 'fr', 'Gyro Pirates'),
       (103, 'en', 'Frost Moon Village'),
       (103, 'fr', 'Frost Moon Village'),
       (104, 'en', 'Trump Pirates'),
       (104, 'fr', 'Trump Pirates'),
       (105, 'en', 'Former Rumbar Pirates'),
       (105, 'fr', 'Former Rumbar Pirates'),
       (106, 'en', 'Crown Island'),
       (106, 'fr', 'Crown Island'),
       (107, 'en', 'Shandian Warrior'),
       (107, 'fr', 'Shandian Warrior'),
       (108, 'en', 'Germa 66'),
       (108, 'fr', 'Germa 66'),
       (109, 'en', 'Mugiwara Chase'),
       (109, 'fr', 'Mugiwara Chase'),
       (110, 'en', 'Fish-Man Island'),
       (110, 'fr', 'Fish-Man Island')
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG
VALUES (111)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION(TAG_ID, LANGUAGE_CODE, NAME)
VALUES (111, 'en', 'Music'),
       (111, 'fr', 'Music')
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG
VALUES (112),
       (113)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION(TAG_ID, LANGUAGE_CODE, NAME)
VALUES (112, 'en', 'The Flying Fish Riders'),
       (112, 'fr', 'The Flying Fish Riders'),
       (113, 'en', 'Muggy Kingdom'),
       (113, 'fr', 'Muggy Kingdom')
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG
VALUES (114),
       (115),
       (116),
       (117),
       (118),
       (119),
       (120),
       (121),
       (122),
       (123)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION(TAG_ID, LANGUAGE_CODE, NAME)
VALUES (114, 'en', 'Weevil''S Mother'),
       (114, 'fr', 'Weevil''S Mother'),
       (115, 'en', 'Former Rocks Pirates'),
       (115, 'fr', 'Former Rocks Pirates'),
       (116, 'en', 'Bluejam Pirates'),
       (116, 'fr', 'Bluejam Pirates'),
       (117, 'en', 'Lulucia Kingdom'),
       (117, 'fr', 'Lulucia Kingdom'),
       (118, 'en', 'Foolshout Island'),
       (118, 'fr', 'Foolshout Island'),
       (119, 'en', 'Long Ring Long Land'),
       (119, 'fr', 'Long Ring Long Land'),
       (120, 'en', 'Egghead'),
       (120, 'fr', 'Egghead'),
       (121, 'en', 'Foxy Pirates'),
       (121, 'fr', 'Foxy Pirates'),
       (122, 'en', 'Journalist'),
       (122, 'fr', 'Journalist'),
       (123, 'en', 'Amazon Lily'),
       (123, 'fr', 'Amazon Lily')
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG
VALUES (124),
       (125),
       (126),
       (127)
ON CONFLICT DO NOTHING;

INSERT INTO UT_TAG_DESCRIPTION(TAG_ID, LANGUAGE_CODE, NAME)
VALUES (124, 'en', 'Drum Kingdom'),
       (124, 'fr', 'Drum Kingdom'),
       (125, 'en', 'Former Roger Pirates'),
       (125, 'fr', 'Former Roger Pirates'),
       (126, 'en', 'Rumbar Pirates'),
       (126, 'fr', 'Rumbar Pirates'),
       (127, 'en', 'Monkey Mountain Alliance'),
       (127, 'fr', 'Monkey Mountain Alliance')
ON CONFLICT DO NOTHING;
