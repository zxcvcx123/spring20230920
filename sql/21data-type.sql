USE mydb1;
-- 수형 (정수, 실수)
-- 정수 : int
CREATE TABLE my_table3
(
    col1 int
);

INSERT INTO my_table3 (col1)
    VALUE (298743);

SELECT *
FROM my_table3;

CREATE TABLE my_table6
(
    age   int,
    score DEC(7, 2)
);
SELECT * FROM  my_table6;
CREATE TABLE table2 (col1 DEC(5, 2));
INSERT INTO table2 (col1) VALUE (123.45);
SELECT *
FROM table1;

INSERT INTO my_table6 VALUE (18, 88.98);

-- 문자열

CREATE TABLE my_table9 (
    name varchar(100),
    address varchar(100),
    phone varchar(100)
);


INSERT INTO my_table9 VALUE ('고봉민', '서울특별시 마포구', '02-848-1322');
SELECT * FROM my_table9;

-- 날짜(날짜시간)
CREATE  TABLE my_table10 (
    col1 DATE
);
INSERT INTO my_table10 VALUE ('2000-01-01');
CREATE TABLE 테이블명 (컬럼명 DATE, 컬럼명 DATETIME);
CREATE TABLE my_table11 (
    col1 DATETIME
);

INSERT INTO my_table11 VALUE ('1515-12-13 21:03:10');

SELECT * FROM my_table11;

CREATE TABLE 테이블명 (컬럼명 DEC(길이, 소수점 자리 수), 컬럼명 DEC(5,2));