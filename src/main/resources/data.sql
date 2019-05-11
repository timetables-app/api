INSERT INTO Company (id, name, phone, founded, registered, approved) VALUES
    (1, 'Pierwsza firma', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0),
    (2, 'Druga firma', '999 999 999', '2012-12-12', '2019-03-01 12:20:12', 0),
    (3, 'Trzecia firma', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0),
    (4, 'Czwarta firma', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0),
    (5, 'Piąta firma', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0);

INSERT INTO COUNTRY (ID, ISO, OBSOLETE, ISO3, NAME)
VALUES
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

INSERT INTO STATE (ID, CODE, OBSOLETE, NAME, COUNTRY_ID)
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

INSERT INTO REGION (ID, CODE, OBSOLETE, NAME, STATE_ID)
VALUES (1, 2814, false, 'Powiat olsztyński', 16),
       (2, 1201, false, 'Powiat bocheński', 2),
       (3, 1202, false, 'Powiat brzeski', 2),
       (4, 1203, false, 'Powiat chrzanowski', 2),
       (5, 1204, false, 'Powiat dąbrowski', 2),
       (6, 1205, false, 'Powiat gorlicki', 2),
       (7, 1261, false, 'Kraków', 2),
       (8, 1207, false, 'Powiat limanowski', 2),
       (9, 1209, false, 'Powiat myślenicki', 2),
       (10, 1262, false, 'Powiat nowosądecki', 2),
       (11, 1211, false, 'Powiat nowotarski', 2),
       (12, 1212, false, 'Powiat olkuski', 2),
       (13, 1213, false, 'Powiat oświęcimski', 2),
       (14, 1214, false, 'Powiat proszowicki', 2),
       (15, 1215, false, 'Powiat suski', 2),
       (16, 1263, false, 'Powiat tarnowski', 2),
       (17, 1217, false, 'Powiat tatrzański', 2),
       (18, 1218, false, 'Powiat wadowicki', 2),
       (19, 1219, false, 'Powiat wielicki', 2),
       (20, 1465, false, 'Warszawa', 3),
       (21, 1061, false, 'powiat Łódzki Wschodni', 8),
       (22, 1005, false, 'powiat Łowicki', 8),
       (23, 0661, false, 'Biała Podlaska', 1),
       (24, 0662, false, 'Chełm', 1),
       (25, 0664, false, 'Zamość', 1),
       (26, 0811, false, 'Powiat żarski', 9),
       (27, 1601, false, 'Powiat brzeski', 10),
       (28, 1606, false, 'Powiat namysłowski', 10),
       (29, 1607, false, 'Powiat nyski', 10),
       (30, 3008, false, 'Powiat kępiński', 13),
       (31, 1206, false, 'Powiat krakowski', 2);

INSERT INTO LOCALITY (ID, OBSOLETE, NAME, REGION_ID)
VALUES (1, false, 'Kraków', 7),
       (2, false, 'Jerzmanowice-Przeginia', 31),
       (3, false, 'Sułoszowa', 31),
       (4, false, 'Igołomia-Wawrzeńczyce', 31),
       (5, false, 'Mogilany', 31),
       (6, false, 'Michałowice', 31),
       (7, false, 'Wielka Wieś', 31),
       (8, false, 'Zielonki', 31),
       (9, false, 'Zabierzów', 31),
       (10, false, 'Czernichów', 31),
       (11, false, 'Iwanowice', 31),
       (12, false, 'Kocmyrzów-Luborzyca', 31),
       (13, false, 'Liszki', 31),
       (14, false, 'Skała', 31),
       (15, false, 'Krzeszowice', 31),
       (16, false, 'Świątniki Górne', 31),
       (17, false, 'Słomniki', 31),
       (19, false, 'Skawina', 31);

INSERT INTO PLACE (ID, CAPACITY, EXPLANATION, OBSOLETE, LAT, LNG, NAME, VARIANT_OF_ID, LOCALITY_ID)
VALUES (1, 5, '', false, 50.0642364, 19.9221641, 'AGH/UR', null, 1),
       (2, 5, '', false, 50.0664265, 19.9231297, 'Plac Inwalidów', null, 1),
       (3, 5, '', false, 50.0618259, 19.9231297, 'Muzeum Narodowe', null, 1),
       (4, 5, '', false, 50.0709027, 19.9297816, 'Nowy Kleparz', null, 1),
       (5, 5, '', false, 50.0685752, 19.9405319, 'Kraków MDA', null, 1);

INSERT INTO LINE (ID, NUMBER, VEHICLE_TYPE)
VALUES (1, 1, 'tram'),
       (2, 2, 'tram'),
       (3, 3, 'tram');

INSERT INTO TIMETABLE (ID, VALID_FROM, VALID_UNTIL, SUPPORTED_COMPANY_ID)
VALUES (1, '2019-04-01', '2019-06-01', 1,),
       (2, '2019-04-01', '2019-06-01', 1,),
       (3, '2019-04-01', '2019-06-01', 2,),
       (4, '2019-04-01', '2019-06-01', 2,),
       (5, '2019-04-01', '2019-06-01', 3,);

INSERT INTO COURSE (ID, LINE_ID, TIMETABLE_ID)
VALUES (1, 1, 1),
       (2, 1, 1),
       (3, 1, 2),
       (4, 2, 2),
       (5, 2, 2),
       (6, 2, 3),
       (7, 3, 3),
       (8, 3, 4),
       (9, 3, 5);

INSERT INTO COURSE_PART (ID, SOURCE_TIME, DESTINATION_TIME, SOURCE_ID, DESTINATION_ID, COURSE_ID, DESTINATION_ON_DEMAND)
VALUES (null, PARSEDATETIME('7:00', 'HH:mm'), PARSEDATETIME('7:15', 'HH:mm'),  1, 2, 1, 1),
       (null, PARSEDATETIME('7:15', 'HH:mm'), PARSEDATETIME('7:28', 'HH:mm'),  2, 4, 1, 1),
       (null, PARSEDATETIME('7:28', 'HH:mm'), PARSEDATETIME('7:35', 'HH:mm'),  4, 5, 1, 1);

INSERT INTO COURSE_PART (ID, SOURCE_TIME, DESTINATION_TIME, SOURCE_ID, DESTINATION_ID, COURSE_ID, DESTINATION_ON_DEMAND)
VALUES (null, PARSEDATETIME('7:20', 'HH:mm'), PARSEDATETIME('7:25', 'HH:mm'),  5, 4, 2, 1),
       (null, PARSEDATETIME('7:25', 'HH:mm'), PARSEDATETIME('7:28', 'HH:mm'),  4, 3, 2, 1),
       (null, PARSEDATETIME('7:28', 'HH:mm'), PARSEDATETIME('7:35', 'HH:mm'),  3, 2, 2, 1);

INSERT INTO COURSE_PART (ID, SOURCE_TIME, DESTINATION_TIME, SOURCE_ID, DESTINATION_ID, COURSE_ID, DESTINATION_ON_DEMAND)
VALUES (null, PARSEDATETIME('16:20', 'HH:mm'), PARSEDATETIME('7:25', 'HH:mm'),  5, 4, 3, 1),
       (null, PARSEDATETIME('16:25', 'HH:mm'), PARSEDATETIME('7:28', 'HH:mm'),  4, 3, 3, 1),
       (null, PARSEDATETIME('16:28', 'HH:mm'), PARSEDATETIME('7:35', 'HH:mm'),  3, 2, 3, 1);

INSERT INTO COURSE_PART (ID, SOURCE_TIME, DESTINATION_TIME, SOURCE_ID, DESTINATION_ID, COURSE_ID, DESTINATION_ON_DEMAND)
VALUES (null, PARSEDATETIME('18:20', 'HH:mm'),  PARSEDATETIME('19:25', 'HH:mm'),  2, 4, 4, 1),
       (null, PARSEDATETIME('19:25', 'HH:mm'),  PARSEDATETIME('19:48', 'HH:mm'),  4, 1, 4, 1),
       (null, PARSEDATETIME('19:48', 'HH:mm'),  PARSEDATETIME('19:55', 'HH:mm'),  1, 5, 4, 1),
       (null, PARSEDATETIME('19:55', 'HH:mm'),  PARSEDATETIME('20:20', 'HH:mm'),  5, 3, 4, 1);