package com.ssafy.IBG.Game.dto;

import com.ssafy.IBG.Game.domain.Game;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SearchAutoResponse {

    private String gameName;
    private String gameKorName;
    private int gameNo;

    @Builder
    public SearchAutoResponse(Game game) {
        this.gameName = game.getName();
        this.gameKorName = game.getKorName();
        this.gameNo = game.getNo();
    }
}
