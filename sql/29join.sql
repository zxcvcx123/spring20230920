USE w3schools;

SELECT * FROM products p JOIN suppliers s
    ON p.SupplierID = s.SupplierID;

-- 같은 컬럼의 이름을 찾아서 매칭
SELECT * FROM products p JOIN suppliers s USING (SupplierID);

-- 같은 컬럼의 이름을 찾아서 매칭
SELECT * FROM products p NATURAL JOIN suppliers s;

