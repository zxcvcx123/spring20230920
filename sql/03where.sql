SELECT * FROM w3schools.customers;

-- WHERE : 레코드 선택(솎아내기)
SELECT * FROM customers WHERE CustomerID = '1';
SELECT * FROM customers WHERE CustomerID = '2';
SELECT * FROM customers WHERE Country = 'USA';
SELECT * FROM customers WHERE Country = 'Mexico';

SELECT * FROM  customers WHERE Country = 'mexico';

SELECT * FROM customers WHERE Country = 'FRANCE';
SELECT * FROM customers WHERE CustomerID = 3;

-- 예) 영국(UK)에 사는 고객들 조회
SELECT * FROM customers WHERE Country = 'UK';

-- 예) 1번 카테고리에 속한 상품(Products)들 조회
SELECT * FROM products WHERE CategoryID = 1;

-- 예) Osaka에 있는 공급자들 조회
SELECT * FROM suppliers WHERE City = 'Osaka';

-- 예) 미국에 사는 고객의 이름들 조회
SELECT CustomerName FROM customers WHERE Country = 'USA';
-- 예) 미국에 사는 고객의 이름들 조회
SELECT CustomerID, CustomerName FROM customers WHERE Country = 'UK';

-- 예) 2번 카테고리에 있는 상품명과 가격 조회
SELECT ProductName, Price FROM products WHERE CategoryID = '2';

-- 예) 일본에 있는 공급자의 이름(SupplierName)과 전화번호 조회
SELECT SupplierName, Phone FROM suppliers WHERE Country = 'Japan';

-- 예) 2번 카테고리의 이름(categoryName) 조회
SELECT CategoryName FROM categories WHERE CategoryID = '2';

SELECT CustomerID, CustomerName, Address, Country
FROM w3schools.customers
WHERE Country LIKE '%U';
