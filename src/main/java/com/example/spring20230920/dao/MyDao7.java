package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.Map;

@Mapper
public interface MyDao7 {

    @Select("""
            SELECT *
            FROM w3schools.customers
            WHERE CustomerID = #{id}
            """)
    Map<String, Object> selectByCustomerId(Integer id);

    @Select("""
            SELECT *
            FROM w3schools.employees
            WHERE EmployeeID = #{id}
            """)
    Map<String, Object> selectByEmployeeId(Integer id);

    @Insert("""
            INSERT INTO w3schools.products (ProductName, Price, CategoryID) VALUES (#{name}, #{price}, #{category})
            """)
    int insertProduct(String name, Double price, Integer category);

    @Update("""
            UPDATE w3schools.employees
            SET LastName = #{lastName},
                FirstName = #{firstName},
                BirthDate = #{birthDate}
            WHERE EmployeeID = #{id}
            """)
    void updateEmp(String lastName, String firstName, LocalDate birthDate, Integer id);
}
