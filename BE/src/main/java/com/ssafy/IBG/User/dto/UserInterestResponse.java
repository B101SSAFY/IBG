package com.ssafy.IBG.User.dto;

import com.ssafy.IBG.Game.domain.Game;
import lombok.Data;

@Data
public class UserInterestResponse {
    private int gameNo;
    private String gameImg;
    private String gameName;
    private String gameKorName;
    private double gameTotalScore;
    private int gameMinPlayer;
    private int gameMaxPlayer;
    private String gameCategory;
    private boolean isLike;

    public UserInterestResponse(Game game, boolean isLike){
        this.gameNo = game.getNo();
        this.gameImg = game.getImg();
        this.gameName = game.getName();
        this.gameKorName = game.getKorName();
        this.gameTotalScore = game.getTotalScore();
        this.gameMinPlayer = game.getMinPlayer();
        this.gameMaxPlayer = game.getMaxPlayer();
        this.gameCategory= game.getCategory();
        this.isLike = isLike;
    }
}
