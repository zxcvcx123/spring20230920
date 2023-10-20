SELECT * FROM customers WHERE CustomerName = 'Alfreds Futterkiste';
SELECT * FROM customers WHERE CustomerName LIKE '%the%';
SELECT * FROM customers WHERE CustomerName LIKE '%ch%';

-- LIKE : 검색
-- %, _ 기호(wildcard)와 같이 사용됨

-- '~%' : ~ 시작하는
SELECT * FROM customers WHERE CustomerName LIKE 'ch%'; -- ch로 시작하는

-- '%~' : ~ 끝나는
SELECT * FROM customers WHERE CustomerName LIKE '%ch'; -- ch로 끝나는

-- '%~%' : ~ 가 포함된
SELECT * FROM customers WHERE CustomerName LIKE '%ch%'; -- ch 가 포함된

-- '_' : 1개의 문자 아무거나
SELECT * FROM employees WHERE FirstName LIKE '_____'; -- 5글자들을 조회
SELECT * FROM employees WHERE LastName LIKE '____'; -- 4글자들을 조회

-- 응용
SELECT * FROM employees WHERE LastName LIKE '_e%'; -- 첫번째 글자는 아무거나 두번째 글자는 e 로 시작하는

-- ch로 시작하는 상품명 조회
SELECT * FROM products WHERE ProductName LIKE 'ch%';
-- es로 끝나는 상품명 조회
SELECT * FROM products WHERE ProductName LIKE '%es';
-- 중간에 use가 들어간 상품명 조회
SELECT * FROM products WHERE ProductName LIKE '%use%';
-- 두번째 글자가 u인 상품명 조회
SELECT * FROM products WHERE ProductName LIKE '_u%';

SELECT 칼럼명 FROM 테이블명 WHERE 검색할칼럼명 LIKE 'LIKE조건식';

SELECT * FROM employees