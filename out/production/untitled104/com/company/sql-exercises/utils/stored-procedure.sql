CREATE OR REPLACE PROCEDURE insertEmployee(
    IN id int,
    IN name VARCHAR,
    IN occupation VARCHAR
)
LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO occupations(id , name, occupation) VALUES (id, name, occupation)
COMMIT
END

