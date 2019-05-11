INSERT INTO Company (id, name, phone, founded, registered, approved) VALUES
    (null, 'Pierwsza firma - test', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0),
    (null, 'Druga firma - test', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0),
    (null, 'Trzecia firma - test', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0),
    (null, 'Czwarta firma - test', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0),
    (null, 'Piąta firma - test', '123 123 123', '2012-12-12', '2019-03-01 12:20:12', 0);

INSERT INTO Users (id, login, is_owner, password_reset, password_change, confirmed) VALUES 
	(21, 'testlogin', 0, 0, 0, 0),
	(22, 'testlogin2', 0, 0, 0, 0),
	(23, 'testlogin3', 0, 0, 0, 0);
	
INSERT INTO Users (id, login, email, password, is_owner, password_reset, password_change, confirmed) VALUES 
	(25, 'testlogin4', 'test@test.pl','$2a$10$XDU/CUyzZRrMmDtgWpLj5OENjc2Xlsm58yCZAl8KlMEl7lKM1rT82', 0, 0, 0, 0),
	(26, 'testloginreset','test2@test.pl', '$2a$10$XDU/CUyzZRrMmDtgWpLj5OENjc2Xlsm58yCZAl8KlMEl7lKM1rT82', 0, 0, 1, 1);
	
INSERT INTO Generated_Token (id, token, user_id, expiration_date) VALUES
	(1, '123456', 21, '2022-03-01 12:20:12');
	
INSERT INTO Auth_Token (id, token) VALUES 
	(100, 'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyNSIsImlhdCI6MTU1NzUwMTIxNSwiZXhwIjoxNTU3NTIyODE1fQ.EReIs5ZEoLK8u_qmoXg2f4T_MEIaufE_c_gsnWCE5EZlMO0_ikQPjVlnFPzE1ynpzQbEJ31I-9uuDIF2hDeE7w');