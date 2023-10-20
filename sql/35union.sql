-- union 합집합
-- 열의 개수가 맞아야 한다

SELECT Country FROM customers;
SELECT Country FROM suppliers;

-- 중복없는 두 테이블의 Country 정보 얻기
SELECT Country FROM customers
UNION
SELECT Country FROM suppliers;

-- 중복있게 두 테이블의 Country 정보 얻기
SELECT Country FROM customers
UNION ALL
SELECT Country FROM suppliers;

SELECT CustomerName, Country FROM  customers
UNION
SELECT SupplierName, Country FROM suppliers;

-- 직원의 lastName과 firstName을 name이라는 하나의 컬럼으로 조회

SELECT LastName AS name FROM employees
UNION
SELECT FirstName FROM employees;

-- FULL OUTER JOIN : LEFT , RIGTH JOIN 합집합

SELECT * FROM my_table44_a a LEFT JOIN my_table45_b b ON a.col1 = b.col1
UNION ALL
SELECT * FROM my_table44_a a RIGHT JOIN my_table45_b b ON a.col1 = b.col1;

-- LEFT OUTER JOIN
SELECT * FROM my_table44_a a LEFT JOIN my_table45_b b ON a.col1 = b.col1;

-- RIGHT OUTER JOIN
SELECT * FROM my_table44_a a RIGHT JOIN my_table45_b b ON a.col1 = b.col1;