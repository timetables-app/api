INSERT INTO Company (id, name, phone, founded, registered, approved) VALUES
    (null, 'Pierwsza firma', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0),
    (null, 'Druga firma', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0),
    (null, 'Trzecia firma', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0),
    (null, 'Czwarta firma', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0),
    (null, 'Piąta firma', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0);

INSERT INTO COUNTRY (ID, ISO, IS_OBSOLETE, ISO3, NAME) VALUES
 (1, 'PL', false, 'POL', 'Poland'),
 (2, 'AD', false, 'AND', 'Andorra'),
 (3, 'AE', false, 'ARE', 'United Arab Emirates'),
 (4, 'AF', false, 'AFG', 'Afghanistan'),
 (5, 'AG', false, 'ATG', 'Antigua and Barbuda'),
 (6, 'AI', false, 'AIA', 'Anguilla'),
 (7, 'AL', false, 'ALB', 'Albania'),
 (8, 'AM', false, 'ARM', 'Armenia'),
 (9, 'AO', false, 'AGO', 'Angola'),
 (10, 'AQ', false, 'ATA', 'Antarctica'),
 (11, 'AR', false, 'ARG', 'Argentina'),
 (12, 'AS', false, 'ASM', 'American Samoa'),
 (13, 'AT', false, 'AUT', 'Austria'),
 (14, 'AU', false, 'AUS', 'Australia'),
 (15, 'AW', false, 'ABW', 'Aruba'),
 (16, 'AX', false, 'ALA', 'Aland Islands'),
 (17, 'AZ', false, 'AZE', 'Azerbaijan'),
 (18, 'BA', false, 'BIH', 'Bosnia and Herzegovina'),
 (19, 'BB', false, 'BRB', 'Barbados'),
 (21, 'BD', false, 'BGD', 'Bangladesh'),
 (22, 'BE', false, 'BEL', 'Belgium'),
 (23, 'BF', false, 'BFA', 'Burkina Faso'),
 (24, 'BG', false, 'BGR', 'Bulgaria'),
 (25, 'BH', false, 'BHR', 'Bahrain'),
 (26, 'BI', false, 'BDI', 'Burundi'),
 (27, 'BJ', false, 'BEN', 'Benin'),
 (28, 'BL', false, 'BLM', 'Saint Barthelemy'),
 (29, 'BM', false, 'BMU', 'Bermuda'),
 (31, 'BN', false, 'BRN', 'Brunei'),
 (32, 'BO', false, 'BOL', 'Bolivia'),
 (33, 'BQ', false, 'BES', 'Bonaire, Saint Eustatius and Saba '),
 (34, 'BR', false, 'BRA', 'Brazil'),
 (35, 'BS', false, 'BHS', 'Bahamas'),
 (36, 'BT', false, 'BTN', 'Bhutan'),
 (37, 'BV', false, 'BVT', 'Bouvet Island'),
 (38, 'BW', false, 'BWA', 'Botswana'),
 (39, 'BY', false, 'BLR', 'Belarus'),
 (41, 'BZ', false, 'BLZ', 'Belize'),
 (42, 'CA', false, 'CAN', 'Canada'),
 (43, 'CC', false, 'CCK', 'Cocos Islands'),
 (44, 'CD', false, 'COD', 'Democratic Republic of the Congo'),
 (45, 'CF', false, 'CAF', 'Central African Republic'),
 (46, 'CG', false, 'COG', 'Republic of the Congo'),
 (47, 'CH', false, 'CHE', 'Switzerland'),
 (48, 'CI', false, 'CIV', 'Ivory Coast'),
 (49, 'CK', false, 'COK', 'Cook Islands'),
 (51, 'CL', false, 'CHL', 'Chile'),
 (52, 'CM', false, 'CMR', 'Cameroon'),
 (53, 'CN', false, 'CHN', 'China'),
 (54, 'CO', false, 'COL', 'Colombia'),
 (55, 'CR', false, 'CRI', 'Costa Rica'),
 (56, 'CU', false, 'CUB', 'Cuba'),
 (57, 'CV', false, 'CPV', 'Cape Verde');

INSERT INTO STATE (ID, CODE, IS_OBSOLETE, NAME, COUNTRY_ID)
VALUES (1, 75, false, 'Województwo Lubelskie', 1),
       (2, 77, false, 'Województwo Małopolskie', 1),
       (3, 78, false, 'Województwo Mazowieckie', 1),
       (4, 80, false, 'Województwo Podkarpackie', 1),
       (5, 81, false, 'Województwo Podlaskie', 1),
       (6, 84, false, 'Województwo Świętokrzyskie', 1),
       (7, 72, false, 'Województwo Dolnośląskie', 1),
       (8, 74, false, 'Województwo Łódzkie', 1),
       (9, 76, false, 'Województwo Lubuskie', 1),
       (10, 79, false, 'Województwo Opolskie', 1),
       (11, 82, false, 'Województwo Pomorskie', 1),
       (12, 83, false, 'Województwo Śląskie', 1),
       (13, 86, false, 'Województwo Wielkopolskie', 1),
       (14, 87, false, 'Województwo Zachodniopomorskie', 1),
       (15, 73, false, 'Województwo Kujawsko-Pomorskie', 1),
       (16, 85, false, 'Województwo Warmińsko-Mazurskie', 1),
       
       (17,'SZ', false, 'Kanton Schwyz', 47),
       (18,'VS', false, 'Canton du Valais', 47),
       (19,'UR', false, 'Kanton Uri', 47),
       (20,'SO', false, 'Kanton Solothurn', 47),
       (21,'ZH', false, 'Kanton Zürich', 47),
       (22,'ZG', false, 'Kanton Zug', 47),
       (23,'VD', false, 'Canton de Vaud', 47),
       (24,'TI', false, 'Ticino', 47),
       (25,'TG', false, 'Kanton Thurgau', 47),
       (26,'SH', false, 'Kanton Schaffhausen', 47),
       (27,'SG', false, 'Kanton St. Gallen', 47),
       (28,'FR', false, 'Canton de Fribourg', 47),
       (29,'OW', false, 'Kanton Obwalden', 47),
       (30,'NW', false, 'Kanton Nidwalden', 47),
       (31,'NE', false, 'Neuchâtel', 47),
       (32,'LU', false, 'Kanton Luzern', 47),
       (33,'JU', false, 'Jura', 47),
       (34,'GL', false, 'Kanton Glarus', 47),
       (35,'GR', false, 'Kanton Graubünden', 47),
       (36,'GE', false, 'Genève', 47),
       (37,'BE', false, 'Canton de Berne', 47),
       (38,'BS', false, 'Kanton Basel-Stadt', 47),
       (40,'BL', false, 'Kanton Basel-Landschaft', 47),
       (41,'AG', false, 'Kanton Aargau', 47),
       (42,'AR', false, 'Kanton Appenzell Ausserrhoden', 47),
       (43,'AI', false, 'Kanton Appenzell Innerrhoden', 47);
