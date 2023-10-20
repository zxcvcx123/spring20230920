DELETE FROM 테이블명
DELETE FROM 테이블명 WHERE 조건식;

SELECT * FROM employees WHERE LastName = '손';
DELETE FROM employees WHERE  LastName = '손';

DELETE FROM employees WHERE FirstName = '김';



-- 직원테이블에 오늘 입력한 레코드들 지우기
SELECT * FROM employees;
-- DELETE FROM employees WHERE employees.EmployeeID = '20';

-- 상품테이블에 오늘 입력한 레코드들 지우기
SELECT  * FROM products;
-- DELETE FROM products WHERE ProductID = '82';