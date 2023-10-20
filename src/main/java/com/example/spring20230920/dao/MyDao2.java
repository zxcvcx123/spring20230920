package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyDao2 {

    @Select("""
            SELECT LastName From w3schools.employees
            WHERE EmployeeID = #{id}
            """)
    String select(Integer id);
}
