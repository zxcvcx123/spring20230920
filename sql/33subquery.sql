USE w3schools;

-- Ipoh coffee 이름의 상품 가격 조회
SELECT Price
FROM products
WHERE ProductName = 'Ipoh coffee';

--
SELECT ProductName, Price
FROM products
WHERE Price > 46.00
ORDER BY Price DESC;

-- 서브쿼리 활용
SELECT ProductName, Price
FROM products
WHERE Price > (SELECT Price FROM products WHERE ProductName = 'Ipoh coffee')
ORDER BY Price DESC;

-- 서브쿼리활용
SELECT BirthDate
FROM employees
WHERE LastName = 'leverling';

SELECT BirthDate
FROM employees
WHERE BirthDate < (SELECT BirthDate
                   FROM employees
                   WHERE LastName = 'leverling');
SELECT 컬럼명
FROM 테이블명
WHERE 컬럼명 조건식 (서브쿼리);
-- subquery
-- 행, 열 하나 즉 단일 값

-- 행 여러개 열 1개
SELECT ShipperID
FROM orders
WHERE OrderDate = '1996-07-08';
SELECT CustomerName
FROM customers
WHERE Country = 'mexico';

-- 행 여러개 열 여러개
SELECT CustomerID, CustomerName
FROM customers
WHERE Country = 'mexico';

-- 행1개 열1개 예제
-- 'Tofu' 상품을 공급하는 공급자명
SELECT SupplierID
FROM products
WHERE ProductName = 'tofu';

SELECT SupplierID, SupplierName
FROM suppliers
WHERE SupplierID = '6';

-- 여러 행 1개 열
-- 멕시코 고객이 주문한 일자들 조회
SELECT CustomerID
FROM customers
WHERE Country = 'mexico';
SELECT OrderDate
FROM orders
WHERE CustomerID IN (SELECT CustomerID FROM customers WHERE Country = 'mexico');

-- 1번 카테고리에 있는 상품이 주문된 주문 번호(orderDetails, products)
SELECT ProductID
FROM products
WHERE CategoryID = '1'
ORDER BY ProductID DESC;
SELECT OrderID
FROM orderdetails
WHERE ProductID IN (SELECT ProductID FROM products WHERE CategoryID = '1')
ORDER BY OrderDetailID DESC;

-- 주문한적 없는 고객들
SELECT CustomerID
FROM orders;

SELECT *
FROM customers
WHERE CustomerID NOT IN (SELECT CustomerID FROM orders);

-- 행 여러개 열 여러개
INSERT INTO customers (CustomerName, Address, Country)
        (SELECT SupplierName, Address, Country FROM suppliers);

-- INSERT 예제
-- 열의 개수와 타입만 맞으면 서브쿼리로 INSERT 도 가능
INSERT INTO customers (CustomerName, Address, Country)
        (SELECT ContactName, City, Phone, FROM suppliers);

-- SELECT 예제
SELECT *
FROM customers
WHERE (City, Country) IN (SELECT City, Country FROM suppliers);

-- CREATE TABLE 예제
CREATE TABLE table_c
SELECT CustomerName, City, Country
FROM customers;

-- 1번 카테고리에 있는 상품들로 새 테이블을 만드는데
--  새로운 테이블은(table_d) productName, categoryName, price
SELECT p.ProductName, c.CategoryName
FROM products p
         JOIN categories c
              ON p.CategoryID = c.CategoryID
WHERE p.CategoryID = '1';

CREATE TABLE table_d
    (SELECT p.ProductName AS productName, c.CategoryName AS categoryName
     FROM products p
              JOIN categories c
                   ON p.CategoryID = c.CategoryID
     WHERE P.CategoryID = '1');


SELECT *
FROM table_d;