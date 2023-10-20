-- normalization : 정규화

-- atomic data (원자적 데이터) 책 209쪽
-- 예) 이름, 최종학력, 특기
CREATE TABLE my_table21_person (
    name VARCHAR(100) NOT NULL ,
    schools VARCHAR(100) ,
    skill VARCHAR(1000)
);
INSERT INTO my_table21_person (name, schools, skill) VALUE ('손흥민', '대학', '축구, 노래');
INSERT INTO my_table21_person (name, schools, skill) VALUE ('이강인', '대학원', '야구, 농구');
INSERT INTO my_table21_person (name, schools, skill) VALUE ('김민재', '대학원', '배구');

SELECT * FROM my_table21_person;
-- 같은 타입의 데이터가 한 컬럼에 여러 개 들어가는걸 권장하지 않는다.

CREATE TABLE my_table22_person (
    name VARCHAR(20) NOT NULL ,
    school VARCHAR(100) ,
    skill1 VARCHAR(100) ,
    skill2 VARCHAR(100) ,
    skill3 VARCHAR(100)
);

-- 같은 타입의 데이터가
INSERT INTO my_table22_person (name, school, skill1, skill2, skill3) VALUE ('손흥민', '대학', '축구', '노래', NULL);
INSERT INTO my_table22_person (name, school, skill1, skill2, skill3) VALUE ('이강인', '대학원', '야구', '농구', '축구');
INSERT INTO my_table22_person (name, school, skill1, skill2, skill3) VALUE ('김민재', '대학원', '배구', NULL, NULL);
SELECT * FROM my_table22_person;

CREATE TABLE my_table23_person (
   name VARCHAR(100) NOT NULL ,
   schools VARCHAR(100) ,
   skill VARCHAR(1000)
);

INSERT INTO my_table23_person (name, schools, skill) VALUE ('흥민', '대학', '축구');
INSERT INTO my_table23_person (name, schools, skill) VALUE ('흥민', '대학', '노래');

