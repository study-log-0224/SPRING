package com.example.demo.Domain.Common.Daos;

import com.example.demo.Domain.Common.Dtos.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @Test
    public void selectAll() {
        productDAO.selectAll();
    }
}