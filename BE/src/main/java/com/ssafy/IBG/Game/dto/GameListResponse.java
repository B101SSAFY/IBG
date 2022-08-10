package com.ssafy.IBG.Game.dto;

import com.ssafy.IBG.Game.domain.Game;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
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

    @Builder
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
