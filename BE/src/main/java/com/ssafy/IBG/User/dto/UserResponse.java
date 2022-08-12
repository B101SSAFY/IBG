package com.ssafy.IBG.User.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    private int userNo;
    private String userEmail;
}