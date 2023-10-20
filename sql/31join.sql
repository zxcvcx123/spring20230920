USE w3schools;

SELECT CustomerName
FROM customers
WHERE CustomerID NOT IN(SELECT DISTINCT CustomerID FROM orders ORDER BY 1);

SELECT * FROM customers c LEFT JOIN orders o ON c.CustomerID = o.CustomerID WHERE O.CustomerID IS NULL;

SELECT * FROM employees e LEFT JOIN orders o ON e.EmployeeID = o.EmployeeID WHERE o.EmployeeID IS NULL;

SELECT * FROM employees e LEFT JOIN orders o ON e.EmployeeID = o.EmployeeID WHERE o.EmployeeID IS NULL;

INSERT INTO employees (LastName, FirstName, BirthDate, Photo, Notes) VALUE ('손','흥민','2000-01-01', '사진1', ' 축구선수');