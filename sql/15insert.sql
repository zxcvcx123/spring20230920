-- INSERT INTO tableName (columnName1, columnName2, ...)
-- VALUES (values1, values2 ...)
INSERT INTO 테이블명 (칼럼명, 칼럼명 ...) VALUES (값, 값 ...);

INSERT INTO employees (EmployeeID, LastName, FirstName, BirthDate, Photo, Notes) VALUE (10, '손', '흥민', '2000-01-01', '사진10', 'EPL 득점왕');

INSERT INTO employees (EmployeeID, LastName, FirstName, BirthDate, Photo, Notes) VALUE (11, '이', '강인', '2000-02-02', '사진11', '드리블 잘함');

INSERT INTO employees VALUE (12, '김', '민재', '2000-03-03', '사진11', '벽');

-- 모든 컬럼에 값 넣을 때 컬럼명 나열 생략 가능
INSERT INTO employees (EmployeeID, LastName, FirstName) VALUE (13, '정', '우영');

-- 특정 컬럼에만 값을 넣을 때 컬럼명 나열 생략 불가능
-- 나열된 컬럼명과 값의 순서, 갯수가 같아야함
INSERT INTO employees (EmployeeID, FirstName, LastName) VALUE (14, '범근', '차');

-- 값의 타입에 따라 넣는 방법이 다름
INSERT INTO employees (EmployeeID) VALUE (15);

INSERT INTO employees (EmployeeID) VALUE ('16');

INSERT INTO employees (LastName) VALUE ('SON');
INSERT INTO employees (LastName) VALUE ('10000');
INSERT INTO employees (LastName) VALUE (10000);
INSERT INTO employees (BirthDate) VALUE ('2000-01-01');

SELECT * FROM employees ORDER BY EmployeeID DESC;


INSERT INTO products (Price) VALUE (20.10);

INSERT INTO products (Price) VALUE ('30.33');
SELECT * FROM products ORDER BY ProductID DESC;

-- 80번 상품 입력 모든 칼럼 전부
INSERT INTO products VALUE (80, 'Orange', '26', 3, '1 box', 25.25);
-- 새 상품 입력 (id 제외한 나머지 칼럼)
INSERT INTO products (ProductName, SupplierID, CategoryID, Unit, Price) VALUE ('Banana', 22, 3, '1 box', 12.00);

SELECT * FROM employees ORDER BY EmployeeID DESC ;