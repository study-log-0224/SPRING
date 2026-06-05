package com.example.demo.Domain.Common.Repository.ex;

import com.example.demo.Domain.Common.Entity.ex.ExBoard;
import com.example.demo.Domain.Common.Entity.ex.ExReply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ExBoardRepositoryTest {
    @Autowired
    ExBoardRepository exBoardRepository;

    @Test
    void t1() {

        ExBoard board =
                exBoardRepository.save(
                        ExBoard.builder()
                                .title("게시글1")
                                .content("내용")
                                .build()
                );
    }
}