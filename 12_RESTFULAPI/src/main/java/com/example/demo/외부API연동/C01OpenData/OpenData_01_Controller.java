package com.example.demo.외부API연동.C01OpenData;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

// 대구광역시 시내버스 노선정보 : https://www.data.go.kr/data/15156114/fileData.do
// 노선 ID : 3000649000
// 버스번호 : 649
// 정류소 ID : 7001001600
@RestController
@Slf4j
@RequestMapping("/Open/Weather")
public class OpenData_01_Controller {

    private String server = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
    private String serviceKey = "fc2ad88577ffd8918f5a7ef3b3f7dde5a41218d7bb38a6742f5fa3150d48de0e";
    private String pageNo = "1";
    private String numOfRows = "1000";
    private String dataType = "JSON";
    private String base_date = "20260609";
    private String base_time = "1430";
    private String nx = "89";
    private String ny = "90";

    @GetMapping
    public void get() {
        // 요청 파라미터 준비
        URI uri = UriComponentsBuilder.fromHttpUrl(server)
                .queryParam("serviceKey", serviceKey)   // 디코딩 키
                .queryParam("pageNo", pageNo)
                .queryParam("numOfRows", numOfRows)
                .queryParam("dataType", dataType)
                .queryParam("base_date", base_date)
                .queryParam("base_time", base_time)
                .queryParam("nx", nx)
                .queryParam("ny", ny)
                .encode()                   // 한번만 인코딩
                .build()
                .toUri();
        log.info("GET /Open/Weather..." + uri);
        // 요청 헤더(x)

        // 요청 바디(x)

        // 응답 = 요청
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Root> response =
        restTemplate.exchange(uri, HttpMethod.GET, null, Root.class);
        // 응답 변환 처리
        System.out.println(response.getBody());
    }
    // -------------------------------------
    @Data
    private static class Body{
        public String dataType;
        public Items items;
        public int pageNo;
        public int numOfRows;
        public int totalCount;
    }
    @Data
    private static class Header{
        public String resultCode;
        public String resultMsg;
    }
    @Data
    private static class Item{
        public String baseDate;
        public String baseTime;
        public String category;
        public int nx;
        public int ny;
        public String obsrValue;
    }
    @Data
    private static class Items{
        public ArrayList<Item> item;
    }
    @Data
    private static class Response{
        public Header header;
        public Body body;
    }
    @Data
    private static class Root{
        public Response response;
    }
}
