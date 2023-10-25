package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto33;
import com.example.spring20230920.domain.MyDto45;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface MyDao8 {


    @Select("""
            SELECT *
            FROM w3schools.products
            WHERE ProductID = #{id}
            """)
    Map<String, Object> selectProductById(Integer id);


    @Select("""
                SELECT EmployeeID id, LastName, FirstName, Photo, Notes, BirthDate
                FROM w3schools.employees
                WHERE EmployeeID = #{id}
            """)
    MyDto33 selectByEmpId(Integer id);

    @Select("""
            SELECT p.ProductID id, p.Price price, c.CategoryName category, p.Unit unit
            FROM w3schools.products p JOIN w3schools.categories c
                ON p.CategoryID = c.CategoryID
            WHERE p.ProductID = #{id}
            """)
    MyDto45 selectProductId(Integer id);
}
