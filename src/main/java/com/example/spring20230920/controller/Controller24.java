package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto18Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
@RequestMapping("main24")
public class Controller24 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() throws SQLException {

        String sql = """
                INSERT INTO products (ProductName, SupplierID, CategoryID, Unit, Price) 
                VALUE (?,?,?,?,?)
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        try (con; pstmt;) {
            pstmt.setString(1, "돈까스");
            pstmt.setString(2, "3");
            pstmt.setString(3, "4");
            pstmt.setString(4, "한 장");
            pstmt.setString(5, "500.00");

            int cnt = pstmt.executeUpdate();

            if (cnt == 1) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }

        }
    }

    @GetMapping("sub2")
    public void method2(@RequestParam(value = "SupplierName", required = false) String supplierName,
                        @RequestParam(value = "ContactName", required = false) String contactName,
                        @RequestParam(value = "Address", required = false) String address,
                        @RequestParam(value = "City", required = false) String city,
                        @RequestParam(value = "PostalCode", required = false) String postalCode,
                        @RequestParam(value = "Country", required = false) String country,
                        @RequestParam(value = "Phone", required = false) String phone) throws SQLException {

        String sql = """
                INSERT INTO suppliers (SupplierName, ContactName, Address, City, PostalCode, Country, Phone) 
                VALUE (?,?,?,?,?,?,?)              
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        if (supplierName != null) {
            try (con; pstmt;) {
                pstmt.setString(1, supplierName);
                pstmt.setString(2, contactName);
                pstmt.setString(3, address);
                pstmt.setString(4, city);
                pstmt.setString(5, postalCode);
                pstmt.setString(6, country);
                pstmt.setString(7, phone);

                if (pstmt.executeUpdate() == 1) {
                    System.out.println("등록 성공");
                } else {
                    System.out.println("등록 실패");
                }
            }
        }
    }

    @GetMapping("sub3")
    public String method3(){
        return "/main24/sub4";
    }

    @PostMapping("sub4")
    public void method4(MyDto18Employee dto) throws SQLException {

        String sql = """
                INSERT INTO employees (LastName, FirstName, BirthDate, Photo, Notes)
                VALUE  (?,?,?,?,?)             
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        try (con; pstmt;) {
            pstmt.setString(1, dto.getLastName());
            pstmt.setString(2, dto.getFirstName());
            pstmt.setObject(3, dto.getBirthDate());
            pstmt.setString(4, dto.getPhoto());
            pstmt.setString(5, dto.getNotes());
            pstmt.executeUpdate();
        }

    }


}

