package com.example.spring20230920.controller;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main22")
public class Controller22 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(Integer page) throws SQLException {
        String sql = """
                SELECT customerId id,
                       customerName name
                FROM customers
                ORDER BY id
                LIMIT ?, ?
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        // pstmt.setInt(1, 0); // 1페이지
        // pstmt.setInt(1, 10); // 2페이지
        pstmt.setInt(1, (page - 1) * 10); // ? 페이지 처리
        pstmt.setInt(2, 10);

        ResultSet rs = pstmt.executeQuery();
        try (con; pstmt; rs;) {
            System.out.println("고객 목록");
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");

                System.out.println(id + " : " + name);
            }
        }

    }

    // 페이지당 7개 씩 공급자 목록 조회
    // /main22/sub2?p=1
    @GetMapping("sub2")
    public void method2(@RequestParam(value = "p", defaultValue = "1") Integer page, Model model) throws SQLException {
        String sql = """
                SELECT SupplierID AS id,
                       SupplierName AS name
                FROM suppliers 
                WHERE SupplierID 
                ORDER BY SupplierID ASC
                LIMIT ?, 7           
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, (page - 1) * 7);
        pstmt.setInt(2, 7);
        ResultSet rs = pstmt.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();

        try (con; pstmt; rs;) {
            System.out.println("조회 결과");
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();

                map.put("id", rs.getString("id"));
                map.put("name", rs.getString("name"));

                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println(id + " : " + name);

                list.add(map);

                String sql1 = """
                        SELECT COUNT(*)
                        FROM suppliers
                        """;

                Connection con1 = dataSource.getConnection();
                Statement stmt1 = con1.createStatement();
                ResultSet rs1 = stmt1.executeQuery(sql1);


                try (con1; stmt1; rs1;) {
                    if (rs1.next()) {
                        int countAll = rs1.getInt(1);

                        int lastPageNumber = ((countAll - 1) / 7) + 1;

                        model.addAttribute("lastPageNumber", lastPageNumber);
                    }
                }


                model.addAttribute("list", list);
            }
        }
    }

    // /main22/sub3?p=2
    // 2페이지 고객목록을 jsp에 테이블 형식 출력 (id, name) 출력
    // page 번호로 링크
    // 1페이지 5개씩
    @GetMapping("sub3")
    public void method3(@RequestParam(value = "p", defaultValue = "1") Integer page,
                        Model model) throws SQLException {

        Integer listPageNum = 5;

        String getListSQL = """
                SELECT CustomerID AS id, CustomerName AS name
                FROM customers
                ORDER BY CustomerID ASC
                LIMIT ?, ?
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(getListSQL);
        pstmt.setInt(1, (page - 1) * listPageNum);
        pstmt.setInt(2, listPageNum);
        ResultSet rs = pstmt.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();

        try (con; pstmt; rs;) {
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", rs.getString("id"));
                map.put("name", rs.getString("name"));


                list.add(map);
            }
        }

        String getTotal = """
                SELECT COUNT(*)
                FROM customers
                """;

        Connection con1 = dataSource.getConnection();
        Statement stmt1 = con1.createStatement();
        ResultSet rs1 = stmt1.executeQuery(getTotal);

        int lastPageNum = 0;

        try (con1; stmt1; rs1;) {
            if(rs1.next()){
                int total = rs1.getInt(1);
                lastPageNum = ((total - 1) / listPageNum + 1);

                model.addAttribute("lastPageNum", lastPageNum);
            }
        }


        model.addAttribute("list", list);

        // 현재 페이지
        model.addAttribute("currentPage", page);

        // 5개씩 끊을때
        int leftPageNumber = (page -1) / 5 * 5 + 1;
        int rightPageNumber = leftPageNumber + 4;
        int prevPageNumber = leftPageNumber - 5;
        int nextPageNumber = rightPageNumber + 1;

        rightPageNumber = Math.min(rightPageNumber, lastPageNum);

        model.addAttribute("prevPageNumber", prevPageNumber);
        model.addAttribute("nextPageNumber", nextPageNumber);
        model.addAttribute("leftPageNumber",leftPageNumber);
        model.addAttribute("rightPageNumber",rightPageNumber);

        // 끊을 단위의 페이지 m
        // 현재페이지 n
        // 만약 현재 13페이지라면 ? n = 13
        // 11 12 13 14 15 16 17 18 19 20
        // (n-1)/m * m +1 (왼쪽)
        // 오른쪽번호 = 왼쪽번호 + (m-1)

    }

}
