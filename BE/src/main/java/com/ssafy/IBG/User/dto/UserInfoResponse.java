package com.ssafy.IBG.User.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private Integer userNo;
    private String userEmail;
    private String userNick;
}
