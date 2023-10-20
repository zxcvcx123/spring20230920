-- 비상관쿼리 : 외부쿼리의 컬럼이 내부쿼리에 사용되지 않을 때


-- 상관쿼리 : 외부쿼리의 컬럼이 내부쿼리에 사용될 때 / 속도 문제가 생길 수 있다
-- 이유는 내부쿼리 한 행이 외부쿼리에 모든 행을 탐색하기 때문이다.
-- 외부쿼리란 ? () 밖에 있는 테이블의 정보를 가져와서 ()안에서 사용할 때
-- 각 공급자가 있는 나라의 고객 수는?
SELECT * FROM suppliers;

-- 비상관쿼리
SELECT COUNT(*) FROM customers
                WHERE Country = (SELECT Country FROM suppliers WHERE SupplierID = 1);

-- 상관쿼리
SELECT SupplierID, Country FROM suppliers;
SELECT Country FROM customers;

SELECT s.supplierID, (SELECT COUNT(*) FROM customers c WHERE c.Country = s.Country) AS 'Num'
FROM suppliers s;

-- 상관쿼리 예제) 각 직원보다 나이가 많은 직원의 수
SELECT * FROM employees;

SELECT e2.LastName, (SELECT COUNT(*) FROM employees e1 WHERE e1.BirthDate < e2.BirthDate) AS 'NumberOfEmp'
FROM employees e2;
