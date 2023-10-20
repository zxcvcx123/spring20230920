-- GROUP BY : 그룹함수 사용 시 그룹함수의 범위 지정
SELECT MAX(Price)
FROM products;

SELECT CategoryID ,MAX(Price) FROM products GROUP BY CategoryID;
SELECT CategoryID ,MIN(Price) FROM products GROUP BY CategoryID;

SELECT o.OrderDate, SUM(p.Price * od.Quantity) AS 매출액 FROM products p JOIN orderdetails od
    ON p.ProductID = od.ProductID
JOIN orders o
    ON od.OrderID = o.OrderID
GROUP BY o.OrderDate
ORDER BY o.OrderDate;

-- 직원별 총 주문 처리액 조회 / 직원명, 직원별 주문 처리액
SELECT CONCAT(e.LastName, ' ', e.FirstName) AS '직원명', SUM(p.Price * od.Quantity) AS '처리 금액'
FROM products p JOIN orderdetails od
    ON p.ProductID = od.ProductID
JOIN orders o
    ON od.OrderID = o.OrderID
JOIN employees e
    ON o.EmployeeID = e.EmployeeID
GROUP BY e.EmployeeID;


-- 고객별 총 주문 금액 조회
SELECT c.CustomerName AS '고객명', SUM(p.Price * od.Quantity) AS '총 주문 금액'
FROM products p JOIN orderdetails od
    ON p.ProductID = od.ProductID
JOIN orders o
    ON od.OrderID = o.OrderID
JOIN customers c
    ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID;