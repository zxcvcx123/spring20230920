SELECT * FROM employees ORDER BY BirthDate;

SELECT * FROM employees ORDER BY 4;

SELECT EmployeeID, LastName, BirthDate FROM employees ORDER BY 3;

SELECT * FROM products ORDER BY CategoryID DESC , Price;

-- 고객을 국가명 오름차순으로 조회
SELECT * FROM customers ORDER BY Country;

-- 가격이 비싼 상품이 먼저 조회되도록 코드 작성
SELECT * FROM products ORDER BY Price DESC;

-- 가장 어린 직원이 먼저 조회되도록 코드 작성
SELECT * FROM employees ORDER BY BirthDate DESC;

-- products 테이블의 CategoryID 칼럼의 값이 1인 것중 Price 칼럼의 값을 내림차순으로 정렬 조회
SELECT * FROM products WHERE CategoryID = '1' ORDER BY Price DESC;