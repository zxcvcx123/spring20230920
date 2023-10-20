package com.example.spring20230920.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface MyDao5 {


    @Select("""
            <script>
            SELECT COUNT(*) FROM customers 
                
            <if test='country != null'>
                WHERE Country = #{country}
            </if>
            </script>
            """)
    String select1(String country);

    @Select("""

            <script>
            SELECT ContactName FROM w3schools.customers
            <if test='num == 10'>
                -- 수가 10일 때
            </if>
            <if test='num != 10'>
                -- 10이 아니다.
            </if>
            <if test='num > 10'>
                -- 10보다 크다.
            </if>
            <if test='num lt 10'>
                -- 10보다 작다.
            </if>
            <if test='num >= 10'>
                -- 10보다 크거나 같다.
            </if>
            <if test='num lte 10'>
                -- 10보다 작거나 같다.
            </if>
            </script>
            """)
    List<String> select2(Integer num);

    @Select("""
            <script>
            SELECT customerName, contactName
            FROM customers
            <if test='code == 1'>
            WHERE customerName LIKE CONCAT('%',#{k},'%')
            </if>
            <if test='code == 2'>
            WHERE contactName LIKE CONCAT('%',#{k},'%')
            </if>
            </script>
            """)
    List<Map<String, Object>> select3(Integer code, String k);


    @Select("""
            <script>
            SELECT COUNT(*) FROM w3schools.customers
            WHERE 
                <if test='i gt 10'>
                -- i가 10보다 큼
                </if>
                <if test='i lt 10'>
                -- i가 10보다 작음
                </if>
                <if test='(i gt 10) and (i lt 100)'>
                -- i가 0보다 크고 100보다 작음
                </if>
            </script>
            """)
    String select4(int i);


    // CDATA: 안에 어떤 기호가 있더라도 태그로 인식하지 마라 CharterData 약자
    @Select("""
            <script>
                <![CDATA[
                
                SELECT * 
                FROM w3schools.customers
                WHERE CustomerName < 'a'
                ]]>
            </script>
            """)
    String select6();

    @Select("""
            SELECT *
            FROM w3schools.customers
            WHERE CustomerName < 'a';
                        
            """)
    void select5();


    @Select("""
                <script>
                    SELECT *
                    FROM w3schools.customers
                    WHERE 
                        Country IN (
                    
                        <foreach collection="args" item="elem" separator="," open="(" close=")">
                            #{elem}
                        </foreach>
                    
                        )
                </script>
            """)
    String select7(List args);


    @Select("""
                <script>
                SELECT * FROM w3schools.customers
                WHERE 
                     --  prefixOverrides 맨 앞에 있던 어떤 코드를 지울건지
                     -- prefix trim안에 출력될 내용물이 있다면 WHERE을 붙여라
                    <trim prefix="WHERE"  prefixOverrides="OR"> 
                        <foreach collection="args" item="elem">
                            OR country = #{elem}
                        </foreach>
                    </trim>
                </script>    
            """)
    String select8(List args);


    @Select("""
    <script>
    <bind name="alterKeyword" value="'%' + keyword + '%'"/>
        SELECT *
        FROM w3schools.customers
        WHERE CustomerName LIKE #{alterKeyword}
    </script>
""")
    String select9(String keyword);

}
