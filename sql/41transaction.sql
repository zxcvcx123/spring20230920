CREATE TABLE bank
(

    name  VARCHAR(10) PRIMARY KEY,
    money INT NOT NULL default 0
);

INSERT INTO bank(name, money)
values ('son', 10000),
       ('kim', 10000);

-- 송금 업무 son -> kim 1000원 송금
UPDATE bank
SET money = 10000
WHERE name = 'son';
--- son의 송금 과정에서 오류 발생 ---
UPDATE bank
SET money = 10000
WHERE name = 'kim';

-- 되돌리기
ROLLBACK;



SELECT * FROM bank;

-- 되돌리기
ROLLBACK;



