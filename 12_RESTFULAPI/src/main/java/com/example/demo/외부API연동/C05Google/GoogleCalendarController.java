package com.example.demo.외부API연동.C05Google;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Controller
@Slf4j
@RequestMapping("/google/cal")
public class GoogleCalendarController {

    private String CALENDAR_ID="-";

    // POST
    /**
     * 이벤트 추가 (cal.html 모달 폼 POST: date / title / desc)
     *    DOC: https://developers.google.com/calendar/api/v3/reference/events/insert
     *    ENDPOINT: POST https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events
     *    ※ 종일(all-day) 일정은 end.date 가 "배타적(exclusive)" → 시작일 +1 일.
     */
    @PostMapping
    public void post(
            @RequestParam("start") LocalDateTime start,
            @RequestParam("end") LocalDateTime end,
            @RequestParam("summary") String summary,
            @RequestParam("description") String description

    ) {
        log.info("POST /google/cal...{},{},{},{}", start,end,summary,description);

        // 요청 파라미터 정리
        String url = "https://www.googleapis.com/calendar/v3/calendars/"+CALENDAR_ID+"/events";

        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();

        // 요청 헤더
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Bearer " + GoogleLoginController.googleTokenResponse.getAccess_token());
        header.add("Content-Type", "application/json");

        JSONObject startJOSN = new JSONObject();
        startJOSN.put("date",start.toLocalDate().toString());
        JSONObject endJSON = new JSONObject();
        endJSON.put("date",end.toLocalDate().toString());

        JSONObject events = new JSONObject();
        events.put("summary",summary);
        events.put("description",description);
        events.put("start",startJOSN);
        events.put("end",endJSON);

        System.out.println(events);

        // 요청 엔티티(헤더 + 바디(params))
        HttpEntity entity = new HttpEntity(events,header);

        // 응답 = 요청
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        System.out.println("RESPONSE : " + response.getBody());
    }

    // REMOVE
    /**
     * 이벤트 삭제
     *    DOC: https://developers.google.com/calendar/api/v3/reference/events/delete
     *    ENDPOINT: DELETE https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events/{eventId}
     */

    // LIST
    /**
     * 이벤트 목록 조회 (JSON 그대로 반환 - 확인용)
     *    DOC: https://developers.google.com/calendar/api/v3/reference/events/list
     *    ENDPOINT: GET https://www.googleapis.com/calendar/v3/calendars/{calendarId}/events
     */

}
