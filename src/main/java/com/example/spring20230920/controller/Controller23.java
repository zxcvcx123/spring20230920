package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main23")
public class Controller23 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(String keyword) throws SQLException {

        String sql = """
                SELECT * FROM products
                WHERE ProductName LIKE ?
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, "%" + keyword + "%");
        ResultSet rs = pstmt.executeQuery();

        try (con; pstmt; rs;) {
            System.out.println(keyword + "가 포함된 상품목록");
            while (rs.next()) {
                String name = rs.getString("ProductName");
                System.out.println("name = " + name);
            }
        }

    }

    // main23/sub2?k=erd
    // erd 라는 텍스트가 중간에 있는 고객명 조회
    @GetMapping("sub2")
    public void method2(@RequestParam(value = "k", defaultValue = "") String keyword, Model model) throws SQLException {

        String sql = """
                SELECT * FROM customers
                WHERE CustomerName LIKE ?
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, "%" + keyword + "%");
        ResultSet rs = pstmt.executeQuery();

        try (con; pstmt; rs;) {
            System.out.println(keyword + "가 포함된 고객명 조회");
            while (rs.next()) {
                String name = rs.getString("CustomerName");
                System.out.println("name: " + name);
            }
        }

    }


    @GetMapping("sub3")
    public void method3(@RequestParam(value = "st", defaultValue = "") String searchType,
                        @RequestParam(value = "k", defaultValue = "") String keyword,
                        Model model) throws SQLException {
        String sql = """
                SELECT * FROM customers
                WHERE
                """;

        if (searchType.equals("name1")) {
            sql += "customerName LIKE ?";
        } else if (searchType.equals("name2")) {
            sql += "contactName LIKE ?";
        } else if (searchType.equals("")) {
            sql = " SELECT * FROM customers";
        }

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");

        ResultSet resultSet = statement.executeQuery();
        System.out.println("쿼리문: " + sql);
        List<Map<String, Object>> list = new ArrayList<>();
        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                String customerName = resultSet.getString("customerName");
                String contactName = resultSet.getString("contactName");

                list.add(Map.of("customerName", customerName, "contactName", contactName));
            }
            model.addAttribute("searchType", searchType);
            model.addAttribute("keyword", keyword);
            model.addAttribute("customers", list);
        }

    }

    @GetMapping("sub4")
    public void method4(@RequestParam(value = "t", defaultValue = "") String type,
                        @RequestParam(value = "k", defaultValue = "") String keyword,
                        Model model) throws SQLException {

        String sql = """
                SELECT * FROM employees
                WHERE 
                """;

        if (type.equals("lname")) {
            sql += "LastName LIKE ?";
        } else if (type.equals("fname")) {
            sql += "FirstName LIKE ?";
        } else if (type.equals("note")) {
            sql += "Notes LIKE ?";
        } else if (type.equals("")) {
            sql = "SELECT * FROM employees";
        }

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, "%" + keyword + "%");
        ResultSet rs = pstmt.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();

        try (con; pstmt; rs;) {
            while (rs.next()) {
                String lastName = rs.getString("LastName");
                String firstName = rs.getString("FirstName");
                String notes = rs.getString("Notes");

                list.add(Map.of("lastName", lastName, "firstName", firstName, "notes", notes));
            }
        }

        model.addAttribute("type", type);
        model.addAttribute("keyword", keyword);
        model.addAttribute("list", list);
    }



}
