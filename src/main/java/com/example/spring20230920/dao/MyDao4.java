package com.example.spring20230920.dao;

import com.example.spring20230920.domain.*;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface MyDao4 {

    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE CustomerID = #{id}
            """)
        // 파라미터가 하나면 이름이 일치하지 않아도됨
    String select1(Integer id);


    @Select("""
                SELECT ProductName
                FROM products
                WHERE Price BETWEEN #{from} AND #{to}
            """)
    List<String> select2(Double from, Double to);


    @Select("""
                SELECT DISTINCT(ProductName)
                FROM products p JOIN orderdetails od 
                        ON p.ProductID = od.ProductID
                    JOIN orders o
                        ON od.OrderID = o.OrderID
                    WHERE o.OrderDate 
                BETWEEN #{from} AND #{to} ORDER BY o.OrderDate 
            """)
    List<String> select3(LocalDate from, LocalDate to);

    @Select("""
                SELECT ProductName
                FROM products
                WHERE Price BETWEEN #{min} AND #{max}
            """)
    List<String> select4(MyDto25 dto);

    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE Country = #{country1} OR #{country2}
            """)
    List<String> select5(MyDto26 dto);

    @Select("""
                SELECT COUNT(OrderID) 
                FROM orders
                WHERE OrderDate BETWEEN #{dto1.from} AND #{dto2.to}
            """)
    Integer select6(MyDto27 dto1, MyDto28 dto2);


    @Select("""
            SELECT customerName
            FROM customers
            WHERE customerName LIKE CONCAT('%',#{dto2.keyword},'%')
            LIMIT #{dto1.from}, #{dto1.rows}
            """)
    List<String> select7(MyDto29 dto1, MyDto30 dto2);


    @Insert("""
            INSERT INTO customers (CustomerName, Country)
            VALUE (#{name}, #{country})
            """)
    Integer insert1(MyDto31 dto);

    @Insert("""
            INSERT INTO employees (LastName, FirstName)
            VALUE (#{lastName}, #{firstName})
            """)
    int insert2(MyDto32 emp);

    @Delete("""
            DELETE FROM customers 
            WHERE CustomerID = #{id}
            """)
    int delete1(Integer id);

    @Delete("""
            DELETE FROM products 
            WHERE ProductID = #{id}
            """)
    int delete2(Integer id);

    @Select("""
            SELECT EmployeeID AS id, LastName, FirstName, Photo, Notes, BirthDate
            FROM employees
            WHERE EmployeeID = #{id}
            """)
    MyDto33 select8(Integer id);

    @Update("""
            UPDATE employees
            SET LastName = #{lastName},
                FirstName = #{firstName},
                Photo = #{photo},
                Notes = #{notes},
                BirthDate = #{birthDate}
            WHERE EmployeeID = #{id}
            """)
    int update1(MyDto33 dto);

    @Select("""
            SELECT CustomerID AS id, CustomerName AS name, Address, Country
            FROM customers
            WHERE CustomerID = #{id}
            """)
    MyDto34 select9(Integer id);

    @Update("""
UPDATE customers
SET CustomerName = #{name},
    Address = #{address},
    Country = #{country}
WHERE CustomerID = #{id}
""")
    int update2(MyDto34 myDto34);
}

