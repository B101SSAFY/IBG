package com.ssafy.IBG.api.game;

import com.ssafy.IBG.Game.domain.Game;
import lombok.Data;

@Data
public class SearchAutoResponse {

    private String gameName;
    private String gameKorName;
    private int gameNo;

    public SearchAutoResponse(Game game) {
        this.gameName = game.getName();
        this.gameKorName = game.getKorName();
        this.gameNo = game.getNo();
    }
}
