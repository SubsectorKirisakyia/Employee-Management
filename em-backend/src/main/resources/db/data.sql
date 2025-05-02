INSERT INTO employees (first_name, last_name, email_id)
SELECT 'Jakrna', 'Karman', 'jarkaKram@email.com'
WHERE NOT EXISTS (SELECT 1
    FROM employees
    WHERE email_id = 'jarkaKram@email.com');

INSERT INTO employees (first_name, last_name, email_id)
SELECT 'Alice', 'Wonderland', 'alice@wonder.land'
WHERE NOT EXISTS (SELECT 1
    FROM employees
    WHERE email_id = 'alice@wonder.land');

INSERT INTO employees (first_name, last_name, email_id)
SELECT 'Bob', 'The Builder', 'bob@builder.com'
WHERE NOT EXISTS (SELECT 1
    FROM employees
    WHERE email_id = 'bob@builder.com');