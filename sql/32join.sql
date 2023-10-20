use w3schools;

SELECT e1.BirthDate
FROM employees e1 JOIN employees e2 WHERE e1.BirthDate > '1963-08-30';

-- 같은 테이블을 JOIN 가능
SELECT e1.LastName, e1.BirthDate, e2.LastName, e2.BirthDate
FROM employees e1 JOIN employees e2
WHERE e1.BirthDate < e2.BirthDate AND e2.LastName = 'Leverling';

-- 같은 테이블을 JOIN 가능
-- 'Ipoh Coffee' 보다 비싼 상품명 조회
SELECT p2.ProductName, p2.Price
FROM products p1 JOIN products p2
WHERE p1.Price < p2.Price AND p1.ProductName = 'Ipoh Coffee' ORDER BY p2.Price DESC;

CREATE TABLE Employee_a (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    salary INT,
    managerId INT
);

INSERT INTO Employee_a (name, salary, managerId) VALUES
                                                     ('Joe', 70000, 3),
                                                     ('Henry', 80000, 4),
                                                     ('Sam', 60000, NULL),
                                                     ('Max', 90000, NULL);

SELECT e1.name AS Employee
FROM Employee_a e1 JOIN Employee_a e2
                      ON e2.managerId = e1.id;