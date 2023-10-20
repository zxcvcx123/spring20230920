package com.example.spring20230920.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class MyDao1 {

    private final DataSource dataSource;

    public String select(int i) throws SQLException {
        String sql = """
                SELECT * FROME w3schools.customers
                WHERE customerId = ?
                """;

        Connection con = dataSource.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        try (con; pstmt;) {
            pstmt.setInt(1, i);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("customerName");
            }
        }
        return null;
    }


}
