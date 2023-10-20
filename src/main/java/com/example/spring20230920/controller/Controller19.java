package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto14;
import com.example.spring20230920.domain.MyDto15;
import com.example.spring20230920.domain.MyDto16;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main19")
public class Controller19 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String method1(Model model) throws Exception {

        String sql = """
                SELECT CustomerName
                FROM customers
                WHERE CustomerID = 3
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        try (connection; statement; resultSet) {

            resultSet.next();
            String name = resultSet.getString(1);

            model.addAttribute("customerName", name);
        }
        return "/main18/sub1";

    }

    @GetMapping("sub2")
    public void method2() throws Exception {
        String sql = """
                SELECT *
                FROM shippers
                """;

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try (con; stmt; rs;) {
            boolean next1 = rs.next();
            System.out.println(rs.getString(1)); // 1
            System.out.println(rs.getString(2)); // Speedy Express
            System.out.println(rs.getString(3)); // (503) 555-9831

            boolean next2 = rs.next();

            boolean next3 = rs.next();
            boolean next4 = rs.next();

        }
    }

    @GetMapping("sub3")
    public void method3(Model model) throws Exception {
        List<Map<String, String>> list = new ArrayList<>();

        String sql = """
                SELECT *
                FROM shippers
                """;

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try (con; stmt; rs;) {
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();

                map.put("id", rs.getString(1));
                map.put("name", rs.getString(2));
                map.put("phone", rs.getString(3));

                list.add(map);

                model.addAttribute("shippers", list);
            }
        }

    }

    @GetMapping("sub4")
    public void method4(Model model) throws Exception {
        String sql = """
                SELECT CustomerID, CustomerName, City, Country
                FROM customers;
                """;

        List<Map<String, Object>> list = new ArrayList<>();

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try (con; stmt; rs;) {
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", rs.getString(1));
                map.put("name", rs.getString(2));
                map.put("city", rs.getString(3));
                map.put("country", rs.getString(4));
                list.add(map);
            }
        }

        model.addAttribute("list", list);

    }

    @GetMapping("sub5")
    public void method5(Model model) throws Exception {
        String sql = """
                SELECT ProductID, ProductName, Unit, Price
                FROM products;                      
                """;

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<Map<String, Object>> list = new ArrayList<>();

        try (con; stmt; rs;) {

            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("pid", rs.getString(1));
                map.put("productName", rs.getString(2));
                map.put("unit", rs.getString(3));
                map.put("price", rs.getString(4));
                list.add(map);
            }

            model.addAttribute("productList", list);
        }

    }

    @GetMapping("sub6")
    public void method6(Model model) throws Exception {
        String sql = """
                        SELECT CustomerID, CustomerName, Address, Country
                        FROM customers;      
                """;


        List<MyDto15> list = new ArrayList();

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try (con; stmt; rs;) {

            while (rs.next()) {

                MyDto15 dto = new MyDto15();
                dto.setId(rs.getInt(1));
                dto.setName(rs.getString(2));
                dto.setAddress(rs.getString(3));
                dto.setCountry(rs.getString(4));
                list.add(dto);

            }
        }

        model.addAttribute("customerList", list);
    }

    @GetMapping("sub7")
    public String method7(Model model, MyDto16 myDto16) throws Exception {
        String sql = """
                SELECT ProductID, ProductName, Unit, Price
                FROM products;                
                """;

        List<MyDto16> list = new ArrayList<>();

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try (con; stmt; rs;) {
            while (rs.next()) {
                myDto16.setPid(rs.getString(1));
                myDto16.setProductName(rs.getString(2));
                myDto16.setUnit(rs.getString(3));
                myDto16.setPrice(rs.getString(4));
                list.add(myDto16);
            }
        }

        model.addAttribute("productList", list);

        return "/main19/sub5";
    }


    @GetMapping("sub8")
    public void method8() {

    }

    @GetMapping("sub9")
    public String method9(String pid, Model model, MyDto16 mydto16) throws Exception {

        String sql = """
                SELECT ProductID, ProductName, Unit, Price
                FROM products
                WHERE ProductID =
                """;
        sql += pid;

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<MyDto16> list = new ArrayList<>();

        try (con; stmt; rs;) {
            while (rs.next()) {
                mydto16.setPid(rs.getString(1));
                mydto16.setProductName(rs.getString(2));
                mydto16.setUnit(rs.getString(3));
                mydto16.setPrice(rs.getString(4));
                list.add(mydto16);
            }
        }

        model.addAttribute("productList", list);

        return "/main19/sub5";
    }

    @GetMapping("sub10")
    public void method10() {

    }

    @GetMapping("sub11")
    public String method11(Integer cid, Model model, MyDto15 mydto15) throws Exception {

        String sql =
                """
                        SELECT CustomerID, CustomerName, Address, Country
                        FROM customers
                        WHERE CustomerID =
                        """;
        sql += cid;


        List<MyDto15> list = new ArrayList<>();

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try (con; stmt; rs;) {
            while (rs.next()) {
                mydto15.setId(rs.getInt(1));
                mydto15.setName(rs.getString(2));
                mydto15.setAddress(rs.getString(3));
                mydto15.setCountry(rs.getString(4));
                list.add(mydto15);
            }
        }

        model.addAttribute("customerList", list);

        return "/main19/sub6";
    }

    @GetMapping("sub12")
    public void method12() {

    }

    @GetMapping("sub13")
    public String method13(String country, Model model, MyDto15 myDto15) throws Exception {

        String sql =
                """
                SELECT CustomerID, CustomerName, Address, Country
                FROM customers
                WHERE Country LIKE 
                """ + "'%" + country + "%'";

        System.out.println(sql);
        List<MyDto15> list = new ArrayList<>();

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try (con; stmt; rs;) {
            while (rs.next()) {
                myDto15.setId(rs.getInt(1));
                myDto15.setName(rs.getString(2));
                myDto15.setAddress(rs.getString(3));
                myDto15.setCountry(rs.getString(4));
                list.add(myDto15);
            }
        }

        for(MyDto15 item: list){
            System.out.println(item);
        }
        model.addAttribute("customerList", list);
        return "/main19/sub6";
    }




}
