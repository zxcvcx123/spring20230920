-- pk 기본적인 문법
CREATE TABLE my_table27 (
    id INT PRIMARY KEY ,
    name VARCHAR(20)
);

CREATE TABLE 테이블명 (컬럼명 타입 제약사항, 컬럼명 타입 제약사항 제약사항 제약사항, ...);
CREATE TABLE table (idx INT PRIMARY KEY AUTO_INCREMENT, col1 INT NOT NULL CHECK (col1 > 100 AND col1 < 200 ) UNIQUE );

-- pk 다른 문법
CREATE TABLE my_table28(
    id INT,
    name VARCHAR(10),
    PRIMARY KEY (id)
);

-- 여러 pk 설정 가능
CREATE TABLE my_table29 (
    name VARCHAR(10),
    birth DATE,
    PRIMARY KEY (name, birth)
);

-- 보통 AI(AUTO_INCREMENT) 와 같이 사용
CREATE TABLE my_table30 (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10)
);

INSERT INTO my_table30 (name) VALUE ('son');
INSERT INTO my_table30 (name) VALUE ('lee');
INSERT INTO my_table30 (name) VALUE ('kim');
INSERT INTO my_table30 (name) VALUE ('park');

SELECT * FROM my_table30;
