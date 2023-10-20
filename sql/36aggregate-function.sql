USE w3schools;

-- aggregate function (집계함수, 집합함수, 그룹함수)

-- MAX, MIN, COUNT, SUM, AVG

SELECT * FROM products;

-- MAX 최대값
SELECT  MAX(Price) FROM products;
SELECT MAX(컬럼명) FROM 테이블명;

-- 상품명이 제대로 매칭안됨
SELECT  ProductName, MAX(Price) FROM products; -- Côte de Blaye가 나와야하는데 첫번째 레코드가 나옴

-- 집계함수 사용해서 상품명이랑 제대로 매칭되서 보고 싶다면 서브쿼리 활용
SELECT * FROM products
WHERE Price = (SELECT MAX(Price) FROM products);

-- MIN 최소값
SELECT MIN(Price) FROM products;
SELECT * FROM products
WHERE Price = (SELECT MIN(Price) FROM products);

-- 가장 어린 직원명 조회
SELECT LastName, FirstName, BirthDate FROM employees
WHERE BirthDate = (SELECT MAX(BirthDate) FROM employees);


-- 가장 나이 많은 직원명 조회
SELECT LastName, FirstName, BirthDate FROM employees
WHERE BirthDate = (SELECT MIN(BirthDate) FROM employees);

-- COUNT : 갯수
SELECT * FROM employees;
SELECT COUNT(EmployeeID) FROM employees;
INSERT INTO employees (LastName) VALUE ('흥민');
SELECT COUNT(EmployeeID) FROM employees; -- 10개
SELECT COUNT(FirstName) FROM employees; -- 9개

-- NULL은 집계함수에서 미포함 됨
SELECT MIN(BirthDate) FROM employees;
SELECT MAX(BirthDate) FROM employees;

INSERT INTO products (ProductName) VALUE ('커피');

SELECT * FROM products ORDER BY 1 DESC ;
SELECT MIN(Price) FROM products;
SELECT MIN(IFNULL(Price, 0)) FROM products;

-- SUM : 합계
SELECT * FROM products;
SELECT SUM(Price) FROM products;

-- JOIN 응용, '1996-07-04'
SELECT SUM(od.Quantity) FROM orders o JOIN orderdetails od
    ON o.OrderID = od.OrderID
WHERE o.OrderDate = '1996-07-04';

-- 96년 07월 04일에 매출액 구하기
SELECT SUM(p.Price * od.Quantity) AS '매출액' FROM products p JOIN orderdetails od
    ON p.ProductID = od.ProductID
JOIN orders o
    ON o.OrderID = od.OrderID
WHERE o.OrderDate = '1996-07-04';

-- AVG : 평균
SELECT AVG(Price) FROM products;
SELECT SUM(Price) FROM products;
SELECT COUNT(Price) FROM products;
