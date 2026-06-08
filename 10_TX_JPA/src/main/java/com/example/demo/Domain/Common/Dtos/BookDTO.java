package com.example.demo.Domain.Common.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * [EX] 도서(Book) DTO  — 완성 제공 (수정 불필요)
 *  테이블 tbl_book(id, title, author, price) 과 1:1 매핑된다.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookDTO {
    private Long id;        // 도서 번호 (PK)
    @NotBlank(message = "TITLE 는 필수 항목 입니다.")
    private String title;   // 제목
    private String author;  // 저자
    private Integer price;  // 가격
}
