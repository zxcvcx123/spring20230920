package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto19;
import com.example.spring20230920.domain.MyDto21;
import com.example.spring20230920.domain.MyDto22;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.*;

@Mapper
public interface MyDao3 {


    // 1행 1열
    @Select("""
            SELECT customerName FROM w3schools.customers
            WHERE CustomerID = 1
            """)
    String select1();

    @Select("""
            SELECT Price FROM w3schools.products
            WHERE ProductID = 1
            """)
    Double select2();

    @Select("""
                SELECT LastName FROM w3schools.employees
                WHERE EmployeeID = 1
            """)
    String select3();

    @Select("""
                SELECT BirthDate FROM w3schools.employees
                WHERE EmployeeID = 2
            """)
    LocalDate select4();


    @Select("""
            SELECT DISTINCT Country FROM w3schools.customers
            ORDER BY 1
            """)
    List<String> select5();


    @Select("""
                SELECT BirthDate FROM w3schools.employees
            """)
    List<LocalDate> select6();


    @Select("""
                SELECT Price FROM w3schools.products
            """)
    List<Double> select7();


    @Select("""
            SELECT CustomerID, CustomerName, Address FROM w3schools.customers
            WHERE CustomerID = 1
            """)
    LinkedHashMap<String, Object> select8();


    @Select("""
                SELECT p.ProductName, p.Price, c.CategoryName 
                FROM w3schools.products p JOIN w3schools.categories c 
                    ON p.CategoryID = c.CategoryID
                WHERE p.ProductID = 1
            """)
    LinkedHashMap<String, Object> select9();


    @Select("""
            SELECT EmployeeID, LastName, FirstName 
            FROM employees
            WHERE EmployeeID = 1
            """)
    MyDto19 select10();

    @Select("""
            SELECT ProductName, Price, CategoryName
            FROM products p JOIN categories c 
                ON c.CategoryID = p.CategoryID
            WHERE p.ProductID = 1
            """)
    MyDto20 select11();

    @Select("""
            SELECT CustomerID AS id, CustomerName AS name, Country
            FROM customers
            WHERE CustomerID = 2
            """)
    MyDto21 select12();


    @Select("""
                SELECT ProductID id, ProductName name, Price 
                FROM products
                WHERE CategoryID = 2
                ORDER BY Price
            """)
    List<Map<String, Object>> select13();


    @Select("""
            SELECT p.ProductName name, od.Quantity num, p.price
            FROM products p JOIN orderdetails od
                    ON p.ProductID = od.ProductID
                JOIN orders o
                    ON od.OrderID = o.OrderID
            WHERE o.OrderDate = '1996-07-04'
            """)
    List<Map<String, Object>> select14();

    @Select("""
            SELECT p.ProductName name, od.Quantity num, p.price
            FROM products p JOIN orderdetails od
                    ON p.ProductID = od.ProductID
                JOIN orders o
                    ON od.OrderID = o.OrderID
            WHERE o.OrderDate = '1996-07-04'
            """)
    List<MyDto22> select15();

    @Select("""
            SELECT o.OrderDate, p.ProductName, c.CategoryName, od.Quantity ,p.Price 
            FROM products p JOIN orderdetails od
                    ON p.ProductID = od.ProductID
                JOIN orders o
                    ON od.OrderID = o.OrderID
                JOIN categories c 
                    ON p.CategoryID = c.CategoryID
            WHERE c.CategoryID = 1
            ORDER BY o.OrderDate, p.ProductName
            """)
    List<Map<String, Object>> select16();


    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE CustomerID = 100
            """)
    String select17();

    @Select("""
            SELECT CustomerID
            FROM customers
            WHERE CustomerID = 100
            """)
    Integer select18();

    @Select("""
            SELECT CustomerID id,
                    CustomerName name,
                    Country
            FROM customers
            WHERE CustomerID = 1
            """)
    MyDto24 select19();

    @Select("""
            SELECT CustomerID id,
                    CustomerName name,
                    Country
            FROM customers
            WHERE CustomerID > 1
            """)
    List<MyDto24> select20();
}


