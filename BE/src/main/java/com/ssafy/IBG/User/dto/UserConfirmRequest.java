package com.ssafy.IBG.User.dto;

import lombok.Data;

@Data
public class UserConfirmRequest {
    private String userEmail;
    private String userNick;
}
