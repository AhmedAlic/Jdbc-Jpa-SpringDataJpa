INSERT INTO company VALUES (DEFAULT, 'C1', 'Monika');
INSERT INTO company VALUES (DEFAULT, 'C2', 'Samantha');

INSERT INTO lead_manager VALUES (DEFAULT, 'LM1', 'C1');
INSERT INTO lead_manager VALUES (DEFAULT, 'LM2', 'C2');

INSERT INTO senior_manager VALUES (DEFAULT, 'SM1', 'LM1', 'C1');
INSERT INTO senior_manager VALUES (DEFAULT, 'SM2', 'LM1', 'C1');
INSERT INTO senior_manager VALUES (DEFAULT, 'SM3', 'LM2', 'C2');

INSERT INTO manager VALUES (DEFAULT, 'M1', 'SM1', 'LM1', 'C1');
INSERT INTO manager VALUES (DEFAULT, 'M2', 'SM3', 'LM2', 'C2');
INSERT INTO manager VALUES (DEFAULT, 'M3', 'SM3', 'LM2', 'C2');

INSERT INTO employee VALUES (DEFAULT, 'E1', 'M1', 'SM1', 'LM1', 'C1');
INSERT INTO employee VALUES (DEFAULT, 'E2', 'M1', 'SM1', 'LM1', 'C1');
INSERT INTO employee VALUES (DEFAULT, 'E3', 'M2', 'SM3', 'LM2', 'C2');
INSERT INTO employee VALUES (DEFAULT, 'E4', 'M3', 'SM3', 'LM2', 'C2');
