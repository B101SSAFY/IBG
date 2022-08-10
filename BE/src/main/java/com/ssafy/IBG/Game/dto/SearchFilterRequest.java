package com.ssafy.IBG.Game.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class SearchFilterRequest {
    /** 이상 찾기 **/
    private String gameName;
    private String gameKorName;
    private Integer gamePlayer;
    private Integer gameTime;
    private Double gameWeight;
    private Integer gameAge;
    private Double gameScore;
    private List<String> gameCategory;
    private Integer userNo;

    public SearchFilterRequest(String gameName, String gameKorName, Integer gamePlayer, Integer gameTime, Double gameWeight, Integer gameAge, Double gameScore, List<String> gameCategory, Integer userNo) {
        this.gameName = gameName;
        this.gameKorName = gameKorName;
        this.gamePlayer = gamePlayer;
        this.gameTime = gameTime;
        this.gameWeight = gameWeight;
        this.gameAge = gameAge;
        this.gameScore = gameScore;
        this.gameCategory = gameCategory;
        this.userNo = userNo;
    }
}
