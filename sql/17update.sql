SELECT * FROM products;
SELECT * FROM employees WHERE EmployeeID = 3;

UPDATE 테이블명 SET 변경할 컬럼명 = '값', 변경할 컬럼명 = '값' ... WHERE 조건식

UPDATE products
SET ProductName = 'Cang',
    Price = '20.00'
WHERE ProductID = '2';


SELECT * FROM customers;

-- 2번 고객의 이름 수정하기
UPDATE customers
SET CustomerName = 'Lee Kang In'
WHERE CustomerID = '2';

-- 5번 직원이 notes 변경하기
SELECT * FROM employees;
UPDATE employees
SET Notes = '이 편지는 영국에서 시작되어...'
WHERE EmployeeID = '5';

-- 1번 공급자의 전화번호, 주소 변경하기
SELECT * FROM suppliers;
UPDATE suppliers
SET Phone = '010-1111-1111', Address = '서울특별시 종로구'
WHERE SupplierID = '1';

SELECT * FROM products WHERE CategoryID = 1;

UPDATE products
SET Price = Price * 2
WHERE CategoryID = 1;
