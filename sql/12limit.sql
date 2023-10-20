-- LIMIT 조회 레코드(행, row) 제한
SELECT * FROM customers;

-- 3개만 조회하고 싶다
SELECT * FROM customers LIMIT 3;

-- Price가 가장 비싼 10개만 조회
SELECT * FROM products ORDER BY Price DESC LIMIT 10;

-- 가장 어린 3명의 직원 조회
SELECT * FROM employees ORDER BY BirthDate DESC LIMIT 3;

-- 2번 카테고리에서 가장 저렴한 상품 조회
SELECT * FROM products WHERE CategoryID = '2' ORDER BY Price;

-- LIMIT n, m : n 부터 m개 (n은 0부터 시작)
-- 페이지 나누기
SELECT CustomerID, CustomerName FROM customers ORDER BY CustomerID; -- 91개 row

-- 10개씩 끊어서 보여주고 싶다
-- 1페이지
SELECT CustomerID, CustomerName FROM customers ORDER BY CustomerID LIMIT 0, 10;

-- 2페이지
SELECT CustomerID, CustomerName FROM customers ORDER BY CustomerID LIMIT 10, 10;

-- 3페이지
SELECT CustomerID, CustomerName FROM customers ORDER BY CustomerID LIMIT 20, 10;

-- 91개의 row 중 마지막 페이지
SELECT CustomerID, CustomerName FROM customers ORDER BY CustomerID LIMIT 90, 10;


-- 공급자(suppliers)를 한 페이지에 공급자 번호순으로 5개씩 보여줄 때  3번째 페이지 조회 코드 작성
SELECT * FROM suppliers ORDER BY SupplierID LIMIT 20, 20;

-- 몇 페이지인지 구하는 식
-- LIMIT n, m
-- (n-1) * n , m

SELECT 칼럼명 FROM 테이블명 WHERE 조건식;