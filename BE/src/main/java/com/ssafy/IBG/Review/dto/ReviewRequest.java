package com.ssafy.IBG.Review.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewRequest{
    private Integer userNo;
    private String content;

    public ReviewRequest(Integer userNo, String content) {
        this.userNo = userNo;
        this.content = content;
    }
}
