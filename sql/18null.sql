SELECT * FROM CUSTOMERS ORDER BY  1 DESC ;
INSERT INTO customers (CustomerName) VALUE ('흥민');
INSERT INTO customers (CustomerName, ContactName) VALUE ('강인','');
INSERT INTO customers (CustomerName, ContactName) VALUE ('민재', null);
SELECT ProductID, ProductName, Price FROM products ORDER BY 1 DESC ;
INSERT INTO  products (ProductName, Price) VALUE ('피자', 0.00);
INSERT INTO  products (ProductName, Price) VALUE ('햄버거', null);
SELECT * FROM products WHERE Price = null;

-- 피연산자가 NULL 이면 결과는 항상 false
SELECT * FROM products WHERE Price = null; -- null을 같은애들로 찾아도 null은 안나옴
SELECT * FROM products WHERE Price != 0.00; -- 0이 아닌애들로 찾아도 null은 안나옴

-- IS NULL : 컬럼의 값이 null 인지 확인
SELECT * FROM products WHERE Price IS null;

SELECT ProductName, IFNULL(Price, 0.00) FROM products ORDER BY ProductID DESC ;

-- contactName이 null인 고객들 조회
SELECT * FROM customers WHERE ContactName IS null;

-- address가 null인 고객들 조회
SELECT * FROM customers WHERE Address IS NULL;

-- 고객들 조회 (customerName, country 컬럼만), 단 country가 null 이면 '업음' 으로 표시
SELECT CustomerName, IFNULL(country, '없음') AS '국가' FROM customers;
