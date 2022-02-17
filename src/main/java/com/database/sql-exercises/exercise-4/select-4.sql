/* First solution with joins */
SELECT company.company_code,
       company.founder,
       COUNT(DISTINCT lead_manager_code) AS number_of_lead_managers,
       COUNT(DISTINCT senior_manager_code) AS number_of_senior_managers,
       COUNT(DISTINCT manager_code) AS number_of_managers,
       COUNT(DISTINCT employee_code) AS number_of_employees
FROM company
INNER JOIN employee ON employee.company_code = company.company_code
GROUP BY company.company_code
ORDER BY company_code;

/* Second solution without joins */
SELECT company.company_code,
       company.founder,
       COUNT(DISTINCT lead_manager.lead_manager_code),
       COUNT(DISTINCT senior_manager.senior_manager_code),
       COUNT(DISTINCT manager.manager_code),
       COUNT(DISTINCT employee_code)
FROM company,
     lead_manager,
     senior_manager,
     manager,
     employee
WHERE employee.manager_code = manager.manager_code
  AND manager.senior_manager_code = senior_manager.senior_manager_code
  AND lead_manager.lead_manager_code = senior_manager.lead_manager_code
  AND company.company_code = lead_manager.company_code
GROUP BY company.company_code, company.founder
ORDER BY company.company_code;
