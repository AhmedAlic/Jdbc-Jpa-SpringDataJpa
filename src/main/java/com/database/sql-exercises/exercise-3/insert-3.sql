INSERT INTO occupations(id, name, occupation) VALUES (1231, 'Samantha', 'Doctor');
INSERT INTO occupations(id, name, occupation) VALUES (1232, 'Julia', 'Actor');
INSERT INTO occupations(id, name, occupation) VALUES (1233, 'Maria', 'Singer');
INSERT INTO occupations(id, name, occupation) VALUES (1234, 'Meera', 'Singer');
INSERT INTO occupations(id, name, occupation) VALUES (1235, 'Ashley', 'Professor');
INSERT INTO occupations(id, name, occupation) VALUES (1236, 'Ketty', 'Professor');
INSERT INTO occupations(id, name, occupation) VALUES (1237, 'Christen', 'Professor');
INSERT INTO occupations(id, name, occupation) VALUES (1238, 'Jane', 'Actor');
INSERT INTO occupations(id, name, occupation) VALUES (1239, 'Jenny', 'Doctor');
INSERT INTO occupations(id, name, occupation) VALUES (1240, 'Priya', 'Singer');
INSERT INTO occupations(id, name, occupation) VALUES (1241, 'House', 'Doctor');

UPDATE occupations
SET occupation = 'Singer'
WHERE id = 1233;
