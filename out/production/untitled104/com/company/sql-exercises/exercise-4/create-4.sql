DROP TABLE IF EXISTS company, lead_manager, senior_manager, manager, employee;

CREATE TABLE company(
    company_id BIGINT GENERATED ALWAYS AS IDENTITY,
    company_code VARCHAR NOT NULL,
    founder VARCHAR NOT NULL,
    PRIMARY KEY (company_code)
);

CREATE TABLE lead_manager(
    lead_manager_id BIGINT GENERATED ALWAYS AS IDENTITY,
    lead_manager_code VARCHAR NOT NULL,
    company_code VARCHAR NOT NULL,
    PRIMARY KEY (lead_manager_code),
    CONSTRAINT company_fk
        FOREIGN KEY (company_code)
        REFERENCES company(company_code)
);

CREATE TABLE senior_manager(
    senior_manager_id BIGINT GENERATED ALWAYS AS IDENTITY,
    senior_manager_code VARCHAR NOT NULL,
    lead_manager_code VARCHAR NOT NULL,
    company_code VARCHAR NOT NULL,
    PRIMARY KEY (senior_manager_code),
    CONSTRAINT lead_manager_fk
        FOREIGN KEY (lead_manager_code)
        REFERENCES lead_manager(lead_manager_code)
);

CREATE TABLE manager(
    manager_id BIGINT GENERATED ALWAYS AS IDENTITY,
    manager_code VARCHAR NOT NULL,
    senior_manager_code VARCHAR NOT NULL,
    lead_manager_code VARCHAR NOT NULL,
    company_code VARCHAR NOT NULL,
    PRIMARY KEY (manager_code),
    CONSTRAINT senior_manager_fk
        FOREIGN KEY (senior_manager_code)
        REFERENCES senior_manager(senior_manager_code)
);

CREATE TABLE employee(
    employee_id BIGINT GENERATED ALWAYS AS IDENTITY,
    employee_code VARCHAR NOT NULL,
    manager_code VARCHAR NOT NULL,
    senior_manager_code VARCHAR NOT NULL,
    lead_manager_code VARCHAR NOT NULL,
    company_code VARCHAR NOT NULL,
    PRIMARY KEY (employee_code),
    CONSTRAINT manager_fk
        FOREIGN KEY (manager_code)
        REFERENCES manager(manager_code)
);


