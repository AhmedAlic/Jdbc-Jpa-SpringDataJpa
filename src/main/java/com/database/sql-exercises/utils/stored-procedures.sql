CREATE OR REPLACE PROCEDURE insertEmployee(
    IN unique_id int,
    IN employee_name VARCHAR,
    IN employee_occupation VARCHAR
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO occupations(id , name, occupation) VALUES (unique_id, employee_name, employee_occupation)
END $$

CREATE OR REPLACE PROCEDURE selectEmployee(
    IN employee_occupation VARCHAR
)
LANGUAGE plpgsql
AS $$
BEGIN
SELECT * FROM occupations WHERE occupation = employee_occupation;
END $$

