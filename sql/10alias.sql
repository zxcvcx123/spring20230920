SELECT *
FROM employees;

SELECT EmployeeID, LastName
FROM employees;

-- AS : 컬럼명 또는 테이블명 변경
SELECT EmployeeID AS id, LastName AS name
FROM employees;

SELECT EmployeeID, CONCAT(FirstName, ' ', LastName) AS FullName
FROM employees;

-- AS 생략가능
SELECT EmployeeID, CONCAT(FirstName, ' ', LastName) FullName
FROM employees;

-- backtick `` <--- 1 왼쪽에 있는 특수문자으로 키워드나 특수문자 사용 가능
SELECT EmployeeID, CONCAT(FirstName, ' ', LastName) `Full Name`
FROM employees;


-- 공급자의 이름(SupplierName), 주소(address, city, country),
SELECT SupplierName, CONCAT(Address, ', ', City, ', ', Country) AS Address
FROM suppliers;

-- 전화번호(phone -> phone number) 별칭으로 조회
SELECT Phone AS `Phone number`
FROM suppliers;

SELECT *
FROM products;

SELECT products.ProductName, categories.CategoryName
FROM products
         JOIN categories ON products.CategoryID = categories.CategoryID;

SELECT p.ProductName, c.CategoryName
FROM products AS p
         JOIN categories AS c ON p.CategoryID = c.CategoryID;