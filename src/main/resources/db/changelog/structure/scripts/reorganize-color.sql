DROP TABLE UT_COLOR_DESCRIPTION;

ALTER TABLE UT_CARD_COLOR DROP CONSTRAINT FK_CARD_COLOR_COLOR;

DROP TABLE UT_COLOR;

ALTER TABLE UT_CARD_COLOR
    RENAME COLUMN COLOR_ID TO COLOR;

ALTER TABLE UT_CARD_COLOR
    ALTER COLOR TYPE VARCHAR(10);

UPDATE UT_CARD_COLOR
SET COLOR='RED'
WHERE COLOR = '0';

UPDATE UT_CARD_COLOR
SET COLOR='GREEN'
WHERE COLOR = '1';

UPDATE UT_CARD_COLOR
SET COLOR='BLUE'
WHERE COLOR = '2';

UPDATE UT_CARD_COLOR
SET COLOR='PURPLE'
WHERE COLOR = '3';

UPDATE UT_CARD_COLOR
SET COLOR='BLACK'
WHERE COLOR = '4';

UPDATE UT_CARD_COLOR
SET COLOR='YELLOW'
WHERE COLOR = '5';