SELECT * FROM customers;
SELECT * FROM customers WHERE Country = 'Germany';
SELECT * FROM customers WHERE NOT Country = 'Germany';

-- 1번 카테고리에 속하지 않는 상품들 조회
SELECT * FROM products WHERE NOT CategoryID = '1';

-- Japan 에 있지 않는 공급자들 조회
SELECT SupplierName, ContactName, Country FROM suppliers WHERE NOT Country = 'Japan';