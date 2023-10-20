USE mydb1;

CREATE TABLE my_table46 (
    col1 INT,
    col2 INT,
    col3 INT,
    col4 INT,
    col5 INT
);

DESC my_table46;

ALTER TABLE my_table46
MODIFY col1 INT NOT NULL;

ALTER TABLE my_table46
MODIFY col1 INT NULL;

ALTER TABLE 테이블명
MODIFY 컬럼명 타입 NOT NULL ;
ALTER TABLE 테이블명
MODIFY 컬럼명 타입 NULL ;

ALTER TABLE 테이블명
ALTER 컬럼명 SET DEFAULT 100;

ALTER TABLE 테이블명
ALTER 컬럼명 DROP DEFAULT;

ALTER TABLE my_table46
ADD UNIQUE (col5);



-- PRIMARY KEY 제약사항 추가
ALTER TABLE 테이블명
ADD PRIMARY KEY (컬럼명);

SHOW CREATE TABLE 테이블명;

CREATE TABLE my_table47 (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10)
);

ALTER TABLE 테이블명;
ADD FOREIGN KEY (컬럼명) REFERENCES 참조할 테이블명(컬럼명);

ALTER TABLE my_table46
ADD FOREIGN KEY (col5) REFERENCES my_table47(id);

SHOW CREATE TABLE my_table46;

CREATE TABLE `my_table46` (
                              `col1` int(11) DEFAULT NULL,
                              `col2` int(11) DEFAULT NULL,
                              `col3` int(11) DEFAULT 100,
                              `col4` int(11) DEFAULT NULL,
                              `col5` int(11) DEFAULT NULL,
                              UNIQUE KEY `col5` (`col5`),
                              CONSTRAINT `my_table46_ibfk_1` FOREIGN KEY (`col5`) REFERENCES `my_table47` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci