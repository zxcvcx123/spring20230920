-- 정규화 NORMALIZATION
-- 첫번째 정규화 (FIRST NORMAL FORM) 1NF
--  원자적 데이터를 가진 테이블, PK 컬럼이 있어야함

-- 책(369쪽)
-- 두번째 정규화 (SECOND NORMAL FORM) 2NF
--  1NF 조건을 충족시키고, 부분적 함수 의존이 없어야함

-- 부분적함수 의존(partial functional dependency)
-- 키가 아닌 컬럼의 값이 키 컬럼 일부에 종속되지 않아야한다.
-- 키의 일부가 변경되면 키가 아닌 컬럼이 변경되어야 하면 부분적 함수 의존

-- 책(374쪽)
-- 세번째 정규화 (THIRD NORMAL FORM) 3NF
--  2NF 조건을 충족시키고, 이행적 종속이 없어야 함

-- 이행적 종속 (transitive depdendency) :
--  키가 아닌 컬럼이 키가 아닌 다른 컬럼에 의존
--  키가 아닌 컬럼이 변경되면 다른 키가 아닌 컬럼이 변경 되어야 할때

-- 입사지원자
-- id, 이름, 학교, 학교 주소
CREATE TABLE  1nf_table (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    school         VARCHAR(50),
    school_address VARCHAR(100),
    hobby1 VARCHAR(100),
    hobby2 VARCHAR(100),
    hobby3 VARCHAR(100),
    hobby4 VARCHAR(100)
);


INSERT INTO 1nf_table (name, school, school_address, hobby1, hobby2, hobby3, hobby4) VALUES
                                                         ('손흥민', '서울대', '관악', '축구', '농구',NULL,NULL),
                                                         ('이강인', '고려대', '안암', '축구', '배구',NULL,NULL),
                                                         ('김민재', '연세대', '신촌', '게임', '코딩',NULL,NULL),
                                                         ('박지성', '고려대', '안암', '헬스','달리기','푸쉬업',NULL),
                                                         ('정우영', '연세대', '신촌', '농구','야구', '축구', '배구');

SELECT * FROM 1nf_table;




CREATE TABLE my_table30_person
(
    id             INT PRIMARY KEY AUTO_INCREMENT,
    name           VARCHAR(10),
    school         VARCHAR(50),
    school_address VARCHAR(100)
);

INSERT INTO my_table30_person (name, school, school_address)
VALUES ('손흥민', '서울대', '관악'),
       ('이강인', '고려대', '안암'),
       ('김민재', '연세대', '신촌'),
       ('박지성', '고려대', '안암'),
       ('정우영', '연세대', '신촌');

SELECT *
FROM my_table30_person;

CREATE TABLE my_table31_person
(
    id     INT PRIMARY KEY AUTO_INCREMENT,
    name   VARCHAR(10),
    school VARCHAR(100)
);

CREATE TABLE my_table32_school
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(100),
    address VARCHAR(100)
);

INSERT INTO my_table31_person (name, school)
VALUES ('손흥민', '서울대'),
       ('이강인', '고려대'),
       ('김민재', '연세대'),
       ('박지성', '고려대'),
       ('정우영', '연세대');


INSERT INTO my_table32_school (name, address)
VALUES ('서울대', '관악'),
       ('고려대', '안암'),
       ('연세대', '신촌'),
       ('고려대', '안암'),
       ('연세대', '신촌');

SELECT *
FROM my_table31_person;
SELECT *
FROM my_table32_school;

CREATE TABLE my_table33_person
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(10),
    school_id INT -- 한 테이블의 컬럼이 다른 테이블을 참조하면 참조할 테이블의 pk를 사용해야함 / 타입도 맞춰야함
);

CREATE TABLE my_table34_school
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(100),
    address VARCHAR(100)
);

INSERT INTO my_table33_person (NAME, SCHOOL_ID)
VALUES ('흠민', 1),
       ('강인', 2),
       ('민재', 1);

INSERT INTO my_table34_school (name, address)
VALUES ('서울대', '관악'),
       ('연세대', '신촌'),
       ('고려대', '안암');

INSERT INTO my_table33_person (NAME, SCHOOL_ID)
VALUES ('지성', 4);

SELECT *
FROM my_table34_school;
SELECT *
FROM my_table33_person;

-- 외래키, 참조키, FK (FOREIGN KEY)

CREATE TABLE my_table35_person
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(10),
    school_id INT REFERENCES my_table36_school (id)
    -- 한 테이블의 컬럼이 다른 테이블을 참조하면 참조할 테이블의 pk를 사용해야함 / 타입도 맞춰야함
    -- REFERENCES 사용 REFERENCES 참조할 테이블명(참조테이블의 PK)
    -- 외래키(FOREIGN KEY) 제약사항
);

CREATE TABLE my_table36_school
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(100),
    address VARCHAR(100)
);


