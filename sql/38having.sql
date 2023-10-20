-- HAVING : 그룹함수 연산결과를 조건으로 줄 수 있는 키워드

SELECT c.CustomerName AS 고객명, SUM(p.Price * od.Quantity) `총 주문 금액`
FROM products p JOIN orderdetails od
                     ON p.ProductID = od.ProductID
                JOIN orders o
                     ON od.OrderID = o.OrderID
                JOIN customers c
                     ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
HAVING `총 주문 금액` >= 100000;

-- 총 처리 금액 10만 달러 미만인 직원 조회
SELECT CONCAT(e.LastName, ' ', e.FirstName) AS 직원명, SUM(p.Price * od.Quantity) AS `총 처리 금액`
FROM products p JOIN orderdetails od
    ON p.ProductID = od.ProductID
JOIN orders o
    ON od.OrderID = o.OrderID
JOIN employees e
    ON o.EmployeeID = e.EmployeeID
GROUP BY e.EmployeeID
HAVING `총 처리 금액` < 100000;
