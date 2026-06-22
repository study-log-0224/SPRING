package com.example.demo.Config.auth.provider;

import java.util.Map;

public interface OAuth2UserInfo {
    String getName();       //이름반환
    String getEmail();      //접속 이메일 계정 반환
    String getProvier();    // PROVIDER 이름반환
    String getProviderId(); //
    Map<String,Object> getAttrivbutes(); // 계정정보 반환
}
