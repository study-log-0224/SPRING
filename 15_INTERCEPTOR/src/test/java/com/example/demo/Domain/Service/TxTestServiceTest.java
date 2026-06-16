package com.example.demo.Domain.Service;

import com.example.demo.Domain.Common.Service.TxTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TxTestServiceTest {
    @Autowired
    private TxTestService txTestService;

    @Test
    public void t1() throws Exception {
        txTestService.addMemo();
//        txTestService.addMemoTx();
    }
}