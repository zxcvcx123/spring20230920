package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto15;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main20")
public class Controller20 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() {

    }

    @GetMapping("sub2")
    public String method2(String id, Model model, MyDto15 myDto15) throws Exception {

        String sql =
                """
                        SELECT CustomerID, CustomerName, Address, Country
                        FROM customers
                        WHERE CustomerID = ?
                        """;

        List<MyDto15> list = new ArrayList<>();

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        try (con; pstmt; rs;) {
            while (rs.next()) {
                myDto15.setId(rs.getInt(1));
                myDto15.setName(rs.getString(2));
                myDto15.setAddress(rs.getString(3));
                myDto15.setCountry(rs.getString(4));
                list.add(myDto15);
            }
        }

        model.addAttribute("customerList", list);


        return "/main19/sub6";
    }

    @GetMapping("sub3")
    public void method3(String id) throws Exception {
        String sql = """
                SELECT customerId, customerName, country
                FROM customers
                WHERE customerId = ?
                """;
        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println("고객정보");
            System.out.println("id: " + rs.getString(1) + " name: " + rs.getString(2) + " country: " + rs.getString(3));
        }
    }

    @GetMapping("sub4")
    public void method4(String id) throws Exception {
        String sql = """
                SELECT productId, productName
                FROM products
                WHERE productId = ?
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println();
            System.out.println(" ===== 상품 정보 ===== ");
            System.out.println(" 상품번호: " + rs.getString(1));
            System.out.println(" 상품명: " + rs.getString(2));
            System.out.println(" =================== ");
            System.out.println();
        }

    }

    @GetMapping("sub5")
    public void method5(String country) throws Exception {
        String sql = """
                SELECT CustomerName, Country
                FROM customers
                WHERE Country = ?
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, country);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println("고객 정보");
            System.out.println("고객이름: " + rs.getString(1));
            System.out.println("고객국가: " + rs.getString(2));
            System.out.println();
        }
    }

    @GetMapping("sub6")
    public void method6(String c1, String c2) throws Exception {

        String sql = """
                SELECT customerName, country
                FROM customers
                WHERE country = ? OR country = ?
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, c1);
        pstmt.setString(2, c2);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            System.out.println("조회 결과");
            System.out.println("name: " + rs.getString(1));
            System.out.println("country: " + rs.getString(2));
            System.out.println();

        }

    }

    @GetMapping("sub7")
    public void method7() {

    }

    @GetMapping("sub8")
    public void method8(Model model, String min, String max) throws Exception {

        String sql = """
                SELECT ProductName, Price FROM products WHERE Price > ? AND Price < ? ORDER BY Price ASC         
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, min);
        pstmt.setString(2, max);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {

            System.out.println("조회 정보");
            System.out.println("상품명: " + rs.getString(1));
            System.out.println("가격: " + rs.getString(2));

        }

    }

    @GetMapping("sub9")
    public void method9(@RequestParam("country") List<String> countryList) throws Exception {

        String questionMarks = "";
        for (int i = 0; i < countryList.size(); i++) {
            questionMarks += "?";

            if (i < countryList.size() - 1) {
                questionMarks += ", ";
            }
        }
        // 특정 국가에 속한 고객들 조회
        String sql = """
                SELECT *
                FROM customers
                WHERE country IN ("""

                +

                questionMarks

                +

                """
                        )
                        """;


        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < countryList.size(); i++) {
            statement.setString(i + 1, countryList.get(i));
        }
        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {
            System.out.println("고객 목록");
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String country = resultSet.getString(7);

                System.out.println(name + " : " + country);
            }
        }
    }

    @GetMapping("sub10")
    public void method10(Model model) throws Exception {

        // 공급자의 국가 목록 조회
        String sql = """
                SELECT DISTINCT country
                FROM suppliers
                """;

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        List<String> list = new ArrayList<>();

        try (con; stmt; rs;) {
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        }

        model.addAttribute("countryList", list);
    }

    @GetMapping("sub11")
    public String method11(@RequestParam("country") List<String> country, Model model) throws Exception {

        String qm = "?";

        for(int i = 0; i<country.size(); i++){
            if(i < country.size()-1){
                qm += ", ?";
            }
        }

        String sql = """
                SELECT SupplierID, SupplierName, Country 
                FROM suppliers 
                WHERE Country IN (
                """
                +
                qm
                +
                """
                ) ORDER BY Country ASC
                """;

        System.out.println("country: " + country);

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        for(int i = 0; i < country.size(); i++){
            pstmt.setString(i+1, country.get(i));

        }

        ResultSet rs = pstmt.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();

        try(con; pstmt; rs;){
            while (rs.next()){

                Map<String, Object> map = new HashMap<>();

                map.put("id", rs.getString(1));
                map.put("name", rs.getString(2));
                map.put("country", rs.getString(3));

                list.add(map);

                System.out.println(" ===== 고객 정보 ===== ");
                System.out.println("ID: " + map.get("id") + " NAME: " + map.get("name") + " COUNTRY: " + map.get("country"));
                System.out.println(" ================= ");
                System.out.println();
            }
        }

        model.addAttribute("lists", list);

        return "/main20/sub11";
    }
}
