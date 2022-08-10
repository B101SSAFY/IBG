package com.ssafy.IBG.Score.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScoreRequest {

    private Integer userNo;
    private Integer scoreRating;

    public ScoreRequest(Integer userNo, Integer scoreRating) {
        this.userNo = userNo;
        this.scoreRating = scoreRating;
    }
}
