USE mydb1;

-- Table 만들기
CREATE TABLE 테이블명 (컬럼명 컬럼타입, 컬럼명 컬럼타입, ...);

-- 테이블명, 컬럼명 작성 관습은 회사마다 다름
CREATE TABLE my_table1
(
    col_name1 varchar(100),
    col_name2 varchar(100),
    col_name3 varchar(100)
);

SELECT * FROM my_table1;

INSERT INTO my_table1 (col_name1, col_name2, col_name3) VALUE ('민재', '흥민','강인');

-- my_table2 만들기, 컬럼은 4개, 모든 컬럼 타입은 varchar(10)
CREATE TABLE my_table2 (name varchar(10), age varchar(10), gender varchar(10));
SELECT * FROM my_table2;
INSERT INTO my_table2 (name, age, gender) VALUE ('황희찬', '27', '남자');