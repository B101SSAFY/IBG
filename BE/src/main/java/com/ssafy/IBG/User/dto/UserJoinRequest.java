package com.ssafy.IBG.User.dto;

import lombok.Data;

@Data
public class UserJoinRequest {
    private String userEmail;
    private String userPwd;
    private String userNick;
}
