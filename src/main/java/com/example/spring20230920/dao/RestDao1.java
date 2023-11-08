package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface RestDao1 {
    @Select("""
            SELECT *
            FROM w3schools.customers
                
            """)
    List<Map<String, Object>> getCustomer();

    @Select("""
            SELECT CONCAT(FirstName, ' ', LastName) AS name
            FROM w3schools.employees
            WHERE EmployeeID = ${id}
            """)
    String getEmp(String id);

    @Select("""
            SELECT EmployeeID
            FROM w3schools.employees
            """)
    List<String> getEmpId();
}
