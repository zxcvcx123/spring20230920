package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto33;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyDao9 {
    @Insert("""
            INSERT INTO w3schools.employees (lastname, firstname, birthdate, notes)
            VALUES (#{lastName}, #{firstName}, #{birthDate}, #{notes}) 
            """)
    int insertEmployee(MyDto33 dto);



}
