package com.example.spring20230920.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
@RequestMapping("main21")
public class Controller21 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() throws SQLException {
        String sql = """
                SELECT customerName AS name, country
                FROM customers
                WHERE CustomerID <= 3
                """;

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);


        try (con; stmt; rs;) {
            System.out.println("고객 목록");
            while (rs.next()) {
                String name = rs.getString("name");
                String country = rs.getString("country");

                System.out.println(name + " : " + country);
            }
        }


    }

    @GetMapping("sub2")
    public void method2() throws SQLException {
        String sql = """
                SELECT CONCAT(lastName, ' ', firstName) AS fullName,
                        BirthDate AS birth,
                        Notes AS `DESC`
                FROM employees
                """;

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try(con; stmt; rs;){
            System.out.println("조회 정보");
            while (rs.next()){
                String fullName = rs.getString("fullName");
                String birth = rs.getString("birth");
                String Notes = rs.getString("DESC");

                System.out.println(fullName + " : " + birth + " : " + Notes);
            }
        }
    }
}
