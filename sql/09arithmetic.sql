SELECT Price FROM products WHERE ProductID = '1';
SELECT Price + 1 FROM products WHERE ProductID = '1';
SELECT Price - 10.5 FROM products WHERE ProductID = '1';
SELECT Price * 3 FROM products WHERE ProductID = '1';
SELECT Price / 5 FROM products WHERE ProductID = '1';

SELECT ProductName, Price * 2 FROM products;

SELECT ProductName + 'AB', Price FROM products; -- 문자열 연결연산은 안됨

SELECT CONCAT(ProductName, 1), Price FROM products; -- 문자열 연결은 CONCAT 사용

SELECT LastName, BirthDate FROM employees WHERE EmployeeID = '1';
SELECT LastName, BirthDate + 100 FROM employees WHERE EmployeeID = '1';

SELECT LastName, ADDDATE(BirthDate, INTERVAL 1 DAY ) FROM employees WHERE EmployeeID = '1'; -- 날짜 연산은 ADDDATE 내장 함수 사용

SELECT * FROM employees;

SELECT LastName, EmployeeID, FirstName FROM employees;
SELECT CONCAT(LastName, FirstName) FROM employees;
SELECT CONCAT(LastName, ' ', FirstName) FROM employees;
SELECT CONCAT(LastName, ' ', FirstName), ADDDATE(BirthDate, INTERVAL 1 YEAR ) FROM employees;
SELECT CONCAT(LastName, ' ', FirstName), ADDDATE(BirthDate, INTERVAL -1 YEAR ) FROM employees;

-- 주문수량(quantity) * 2 결과 조회 (orderDetails 테이블)
SELECT Quantity * 2 FROM orderdetails;

-- "city, counrty" 고객 테이블 조회
SELECT CONCAT(City, ', ', Country) FROM customers;

SELECT 칼럼명 FROM 테이블명 WHERE 조건식;