UPDATE UT_PRODUCT_DESCRIPTION
SET NAME = '[ST-01] STRAW HAT CREW'
WHERE PRODUCT_ID = 'ST-01';

UPDATE UT_PRODUCT_DESCRIPTION
SET NAME = '[ST-02] WORST GENERATION'
WHERE PRODUCT_ID = 'ST-02';

UPDATE UT_PRODUCT_DESCRIPTION
SET NAME = '[ST-03] The SEVEN WARLORDS OF THE SEA'
WHERE PRODUCT_ID = 'ST-03';

UPDATE UT_PRODUCT_DESCRIPTION
SET NAME = '[ST-04] ANIMAL KINGDOM PIRATES'
WHERE PRODUCT_ID = 'ST-04';

UPDATE UT_PRODUCT_DESCRIPTION
SET NAME = '[ST-05] ONE PIECE FILM EDITION'
WHERE PRODUCT_ID = 'ST-05';

UPDATE UT_PRODUCT_DESCRIPTION
SET NAME = '[ST-06] THE NAVY'
WHERE PRODUCT_ID = 'ST-06';

UPDATE UT_PRODUCT_DESCRIPTION
SET NAME = '[ST-07] BIG MOM PIRATES'
WHERE PRODUCT_ID = 'ST-07';

UPDATE UT_PRODUCT_DESCRIPTION
SET NAME = '[OP-01] ROMANCE DAWN'
WHERE PRODUCT_ID = 'OP-01';

UPDATE UT_PRODUCT_DESCRIPTION
SET NAME = '[OP-02] PARAMOUNT WAR'
WHERE PRODUCT_ID = 'OP-02';

UPDATE UT_PRODUCT_DESCRIPTION
SET NAME = '[OP-03] PILLARS OF STRENGTH'
WHERE PRODUCT_ID = 'OP-03';

UPDATE UT_PRODUCT_DESCRIPTION
SET NAME = '[OP-04] KINGDOMS OF INTRIGUE'
WHERE PRODUCT_ID = 'OP-04';



INSERT INTO UT_PRODUCT_DESCRIPTION (PRODUCT_ID, LANGUAGE_CODE, NAME)
VALUES ('ST-01', 'en', 'Straw Hat Crew [ST-01]'),
       ('ST-01', 'fr', 'Equipage du chapeau de paille [ST-01]')
ON CONFLICT DO NOTHING;
