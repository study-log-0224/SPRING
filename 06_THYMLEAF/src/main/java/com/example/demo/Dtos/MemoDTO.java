package com.example.demo.Dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemoDTO {
    @Min(value = 10 , message = "ID 는 10이상의 값 부터 시작 합니다.")
    @Max(value = 65535 , message = "ID의 최대 숫자는 65535 입니다.")
    @NotNull(message = "ID 는 필수 항목 입니다.")
    private Long id;
    @NotBlank(message = "TITLE 는 필수 항목 입니다.")
    private String title;
    @NotBlank(message = "WRITER 는 필수 항목 입니다.")
    @Email(message = "example@emxample.com 형식으로 입력하세요.")
    private String writer;
    @NotBlank(message = "TEXT 는 필수 항목 입니다.")
    private String text;
    @NotNull(message = "CREATE_AT 는 필수 항목 입니다.")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Future(message = "오늘 날짜기준 이후 날짜를 입력하세요.")
    private LocalDateTime createAt;

    //CUSTOM DATABINDER 용
    private LocalDate customData;   // YYYY-MM-DD
}
