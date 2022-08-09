package com.ssafy.IBG.api.game;

import com.ssafy.IBG.Game.domain.Game;
import lombok.Data;

@Data
public class GameListResponse{
    private int gameNo;
    private String gameName;
    private String gameKorName;
    private String gameCategory;
    private int gameMinPlayer;
    private int gameMaxPlayer;
    private double gameTotalScore;
    private String gameImg;
    private boolean isLike;

    public GameListResponse(Game game, boolean isLike) {
        this.gameNo = game.getNo();
        this.gameName = game.getName();
        this.gameKorName = game.getKorName();
        this.gameCategory = game.getCategory();
        this.gameMinPlayer = game.getMinPlayer();
        this.gameMaxPlayer = game.getMaxPlayer();
        this.gameTotalScore = game.getTotalScore();
        this.gameImg = game.getImg();
        this.isLike = isLike;
    }
}
