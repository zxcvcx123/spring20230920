-- ALTER TABLE : 테이블 수정

-- 컬럼 추가, 변경, 삭제

-- 제약 사항 변경
-- NOT NULL, UNIQUE, PRIMARY KEY, DEFAULT, FOREIGN KEY

-- 컬럼 추가
ALTER TABLE 테이블명;
ALTER TABLE 테이블명
ADD COLUMN 컬럼명 타입 제약사항;

ALTER TABLE products
ADD COLUMN col1 INT;

ALTER TABLE products
ADD COLUMN col2 VARCHAR(10);

-- 중간에 컬럼 추가
ALTER TABLE products
ADD COLUMN col3 VARCHAR(10) AFTER ProductName;

-- 맨 앞에 컬럼 추가
ALTER TABLE products
ADD COLUMN col4 VARCHAR(10) FIRST;

-- 제약사항도 추가 가능
ALTER TABLE products
ADD COLUMN col5 INT NOT NULL DEFAULT 1 REFERENCES employees(EmployeeID);

DESC products;

-- 직원 테이블에 salay 컬럼 마지막에 추가
-- data type은 dec(10, 2), null 허용 안함, 기본값은 0.00
ALTER TABLE employees
ADD COLUMN salay DEC(10, 2) NOT NULL DEFAULT 0.00;
DESC employees;

-- 컬럼 삭제
ALTER TABLE products
DROP COLUMN col2;

-- 컬럼 수정
-- 컬럼을 변경 할 때 변경할 컬럼안에 레코드가 있다면 타입을 변경할 때 조심
ALTER TABLE products
MODIFY COLUMN col3 INT;