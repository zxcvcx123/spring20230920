package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("main26")
public class Controller26 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() throws SQLException {
        String sql = """
                INSERT INTO mydb1.my_table12 (
                int_col, dec_col, str_col, date_col, date_time_col
                )
                VALUE(?,?,?,?,?)
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

        try (con; pstmt;) {
            pstmt.setInt(1, 298432);
            pstmt.setDouble(2, 3.14);
            pstmt.setString(3, "string value");
            pstmt.setTimestamp(4, Timestamp.valueOf(LocalDate.now().atStartOfDay()));
            pstmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            pstmt.executeUpdate();
        }
    }

    @GetMapping("sub2")
    public void method2() throws Exception {
        String sql = """
                SELECT * 
                FROM mydb1.my_table12 
                LIMIT 1
                """;

        Connection con = dataSource.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        try (con; stmt; rs;) {

            if (rs.next()) {
                int intCol = rs.getInt("int_col");
                double decCol = rs.getDouble("dec_col");
                String strCol = rs.getString("str_col");
                LocalDate dateCol = rs.getTimestamp("date_col").toLocalDateTime().toLocalDate();
                LocalDateTime dateTimeCol = rs.getTimestamp("date_time_col").toLocalDateTime();

                System.out.println(intCol);
                System.out.println(decCol);
                System.out.println(strCol);
                System.out.println(dateCol);
                System.out.println(dateTimeCol);
            }
        }


    }

}
