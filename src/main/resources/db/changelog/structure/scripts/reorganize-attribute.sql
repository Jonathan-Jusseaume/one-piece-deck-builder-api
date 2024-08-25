DROP TABLE UT_ATTRIBUTE_DESCRIPTION;

ALTER TABLE UT_CARD DROP CONSTRAINT FK_CARD_ATTRIBUTE;

DROP TABLE UT_ATTRIBUTE;

ALTER TABLE UT_CARD
    RENAME COLUMN ATTRIBUTE_ID TO ATTRIBUTE;

ALTER TABLE UT_CARD
    ALTER ATTRIBUTE TYPE VARCHAR(10);

UPDATE UT_CARD
SET ATTRIBUTE='STRIKE'
WHERE ATTRIBUTE = '0';

UPDATE UT_CARD
SET ATTRIBUTE='RANGED'
WHERE ATTRIBUTE = '1';

UPDATE UT_CARD
SET ATTRIBUTE='SPECIAL'
WHERE ATTRIBUTE = '2';

UPDATE UT_CARD
SET ATTRIBUTE='WISDOM'
WHERE ATTRIBUTE = '3';

UPDATE UT_CARD
SET ATTRIBUTE='SLASH'
WHERE ATTRIBUTE = '4';
