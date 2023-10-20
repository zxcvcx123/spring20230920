package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("main25")
public class Controller25 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(@RequestParam(value = "id", required = false) Integer customerId) throws SQLException {
        if (customerId == null) {
            System.out.println("삭제할 id를 넣어주세요");
            return;
        }

        String sql = """
                DELETE FROM customers
                WHERE customerId = ?
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        try (con; pstmt;) {
            pstmt.setInt(1, customerId);

            int cnt = pstmt.executeUpdate();

            if (cnt == 1) {
                System.out.println("데이터 삭제 완료");
            } else {
                System.out.println("데이터 삭제 문제 발생");
            }
        }

    }

    @GetMapping("sub2")
    public void method2() {

    }

    @PostMapping("sub2")
    public void method3(@RequestParam(value = "pid", required = false) Integer id) throws SQLException {

        if(id == null){
            System.out.println("번호입력 plz");
            return;
        }

        String sql = """
                DELETE FROM products
                WHERE ProductID = ?            
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        try (con; pstmt;) {
            pstmt.setInt(1, id);
            int cnt = pstmt.executeUpdate();

            if(cnt >= 1){
                System.out.println("삭제완료");
            } else {
                System.out.println("오류 발생");
            }
        }
    }
    
    @GetMapping("sub4")
    public void method4() throws SQLException {
        String sql = """
                UPDATE shippers
                SET ShipperName = ?,
                    Phone = ?
                WHERE ShipperID = ?
                """;
        
        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        try(con; pstmt;) {
            pstmt.setString(1, "이강인");
            pstmt.setString(2, "010-1234-5678");
            pstmt.setInt(3, 1);
            int rows = pstmt.executeUpdate();
            if (rows >= 1){
                System.out.println("업데이트 완료");
            } else {
                System.out.println("문제 발생");
            }
        
        }
    }
    
    @GetMapping("sub5")
    public void method5(){

    }

    @PostMapping("sub5")
    public void method6(@RequestParam("id") Integer shipperId,
                        @RequestParam("name") String shipperName,
                        @RequestParam("phone") String phone) throws SQLException {

        String sql = """
                UPDATE shippers
                SET shipperName = ?,
                    phone = ?
                WHERE = shipperId = ?
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        try(con; pstmt;){
            pstmt.setString(1, shipperName);
            pstmt.setString(2, phone);
            pstmt.setInt(3, shipperId);
            int rows = pstmt.executeUpdate();
            
            if(rows >= 1 ){
                System.out.println("잘 변경");
            } else {
                System.out.println("문제 발생");
            }

        }

    }

    @GetMapping("sub7")
    public void method7(@RequestParam(value = "id", required = false) Integer employeeId, Model model) throws SQLException {
        if (employeeId == null) {
            return;
        }
        String sql = """
                SELECT * FROM employees
                WHERE employeeId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setInt(1, employeeId);

            ResultSet resultSet = statement.executeQuery();

            try (resultSet) {
                if (resultSet.next()) {
                    String lastName = resultSet.getString("lastName");
                    String firstName = resultSet.getString("firstName");
                    LocalDate birthDate = resultSet.getTimestamp("birthDate").toLocalDateTime().toLocalDate();
                    String photo = resultSet.getString("photo");
                    String notes = resultSet.getString("notes");

                    model.addAttribute("employee", Map.of("lastName", lastName,
                            "firstName", firstName,
                            "birthDate", birthDate,
                            "photo", photo,
                            "notes", notes,
                            "employeeId", employeeId));

                }
            }
        }
    }

    @PostMapping("sub7")
    public String method8(@RequestParam("id") Integer employeeId,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("firstName") String firstName,
                          @RequestParam("birthDate") String birthDate,
                          @RequestParam("photo") String photo,
                          @RequestParam("notes") String notes,
                          RedirectAttributes rttr) throws SQLException {

        String sql = """
                UPDATE employees
                SET LastName = ?,
                    FirstName = ?,
                    BirthDate = ?,
                    Photo = ?,
                    Notes = ?
                WHERE EmployeeID = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        
        try(connection; statement;) {
            statement.setString(1, lastName);
            statement.setString(2, firstName);
            statement.setString(3, birthDate);
            statement.setString(4, photo);
            statement.setString(5, notes);
            statement.setInt(6, employeeId);
            
            int rows = statement.executeUpdate();
            if(rows >= 1){
                System.out.println("업데이트 완료");
            }  else {
                System.out.println("업데이트 실패");
            }
        }

        rttr.addAttribute("id", employeeId);

        return "redirect:/main25/sub7";
    }

    @GetMapping("sub9")
    public void method9(){

    }
    
}
