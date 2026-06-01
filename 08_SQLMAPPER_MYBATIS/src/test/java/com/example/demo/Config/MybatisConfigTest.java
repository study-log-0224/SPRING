package com.example.demo.Config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MybatisConfigTest {
    @Autowired
    private SqlSessionFactory sqlSesseionFactory;

    public void t1() {
        assertNotNull(sqlSesseionFactory);
    }
}