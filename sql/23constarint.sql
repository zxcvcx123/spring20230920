-- NULL 허용 여부

-- 유일한 값 여부

-- 기본값 지정

-- 값 체크

CREATE TABLE 테이블명 (컬럼명 타입 NULL, 컬럼명 타입 NOT NULL);

CREATE TABLE my_table13 (
    col1 INT NULL, -- NULL 허용 (default 값)
    co12 INT NOT NULL -- NULL 허용 안함
);

INSERT INTO my_table13 VALUE (33, 44);
INSERT INTO my_table13 (co12) VALUE (55);
INSERT INTO my_table13 (col1, co12) VALUE (NULL, 23);

SELECT * FROM my_table13;

-- UNIQUE : 해당 컬럼에 유일한 값만 허용
CREATE TABLE my_table14(
    col1 INT,
    col2 INT UNIQUE -- 이 컬럼에 중복된 값을 넣을 수 없음
);

INSERT INTO my_table14 (col1, col2) VALUE (11,22); -- ok
INSERT INTO my_table14 (col1, col2) VALUE (11,33); -- ok
INSERT INTO my_table14 (col1, col2) VALUE (11,33); -- not ok

SELECT * FROM my_table14;

CREATE TABLE my_table15 (
    col1 INT,
    col2 INT NOT NULL,
    col3 INT UNIQUE,
    col4 INT NOT NULL UNIQUE
);
CREATE TABLE 테이블명 (컬럼명 타입 UNIQUE);
CREATE TABLE table1 (col1 INT UNIQUE); -- col1 에 100인 값이 들어있는 경우 또 100인 값이 들어올 수 없음
INSERT INTO my_table15 (col1, col2, col3, col4) VALUE (11, 22, 33, 44); -- ok
INSERT INTO my_table15 (col1, col2, col3, col4) VALUE (11, 22, 33, 44); -- not ok
INSERT INTO my_table15 (col1, col2, col3, col4) VALUE (11, 22, 44, 55); -- ok

-- DEFAULT : 기본값
CREATE TABLE my_table17 (
    col1 INT,
    col2 INT DEFAULT 100, -- 값을 넣지 않으면 100
    col3 VARCHAR(100) DEFAULT 'empty', -- 값을 넣지 않으면 'empty'
    col4 DATETIME DEFAULT NOW() -- 값을 넣지 않으면 현재 일시
);
CREATE TABLE 테이블명 (컬럼명 타입 DEFAULT 기본값);
CREATE TABLE table1 (col1 INT DEFAULT 100); -- col1의 기본값은 100으로 설정
INSERT INTO my_table17 (col1, col2, col3, col4) VALUE (22, 33, 'son', '2023-11-11 22:33:24');
INSERT INTO my_table17 (col1) VALUE (222);
SELECT * FROM my_table17;

-- CHECK : 값의 유효범위 체크
CREATE TABLE my_table20 (
    col1 INT,
    col2 INT CHECK ( col2 > 100 ), -- col2는 100보다 큰 값이 들어가야 한다.
    col3 INT CHECK ( col3 > 1000 AND col3 < 2000 ) -- col3는 1000보다크고 2000보다 작아야 한다.
);
CREATE TABLE 테이블명 (컬럼명 타입 CHECK( 조건범위 지정 ));

-- col2는 100보다 큰 값이 들어가야 한다.
-- col3는 1000보다크고 2000보다 작아야 한다.
CREATE TABLE table1 (
    col1 INT CHECK ( col1 > 100 ), -- col2는 100보다 큰 값이 들어가야 한다.
    col2 INT CHECK ( col2 > 1000 AND col3 < 2000 ) -- col3는 1000보다크고 2000보다 작아야 한다.
);

INSERT INTO my_table20 (col1, col2, col3) VALUE (10000, 101, 1999);

-- 테이블의 컬럼과 타입, 제약사항 등을 확인
-- describe, DESC
DESC my_table17;

-- TABLE 생성 쿼리 확인
SHOW CREATE TABLE my_table17;