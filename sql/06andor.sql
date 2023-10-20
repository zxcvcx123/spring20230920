SELECT CustomerName, City, Country
FROM customers
WHERE Country = 'spain';

SELECT CustomerName, City, Country
FROM customers
WHERE City = 'Madrid';

SELECT CustomerName, City, Country
FROM customers
WHERE City = 'Madrid'
  AND Country = 'Spain';

SELECT CustomerName, City, Country
FROM customers
WHERE City != 'Madrid'
   OR Country != 'Spain';

SELECT *
FROM products
WHERE Price > 10.00
  AND Price <= 20.00;

-- 스웨덴이나 이탈리아에 있는 공급자들 조회
SELECT *
FROM suppliers
WHERE Country = 'Sweden'
   OR Country = 'Italy';

-- 1963년 8월 생 직원 조회
SELECT *
FROM employees
WHERE BirthDate > '1963-07-31'
  AND BirthDate < '1963-09-01';

-- 가격이 100.00~200.00(포함) 사이인 상품 조회
SELECT *
FROM products
WHERE Price > 100.00
  AND Price <= 200.00;

-- 1997년에 주문한 주문 조회
SELECT *
FROM orders
WHERE OrderDate > '1996-12-31'
  AND OrderDate < '1998-01-01';

-- 여러 연산자 조합시 () 사용해서 우선순위 결정해줄 것
-- 10달러 미만, 100달러 이상
SELECT *
FROM products
WHERE  (Price < 10
   OR Price >= 100 )  AND (CategoryID = '1');