package com.ssafy.IBG.api.recommend;

import com.ssafy.IBG.Game.domain.Game;
import com.ssafy.IBG.domain.Recommend;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendResultResponse {
    private int gameNo;
    private String gameName;
    private String gameKorName;
    private String gameCategory;
    private int gameMinPlayer;
    private int gameMaxPlayer;
    private double predictScore;
    private double gameTotalScore;
    private String gameImg;
    private boolean isLike;

    public RecommendResultResponse(Game g, boolean isLike){
        this.gameNo = g.getNo();
        this.gameName = g.getName();
        this.gameKorName = g.getKorName();
        this.gameCategory = g.getCategory();
        this.gameMinPlayer = g.getMinPlayer();
        this.gameMaxPlayer = g.getMaxPlayer();
        this.gameTotalScore = g.getTotalScore();
        this.gameImg = g.getImg();
        this.isLike = isLike;
    }

    public RecommendResultResponse(Recommend r, boolean isLike) {
        this.gameNo = r.getGame().getNo();
        this.gameName = r.getGame().getName();
        this.gameKorName = r.getGame().getKorName();
        this.gameCategory = r.getGame().getCategory();
        this.gameMinPlayer = r.getGame().getMinPlayer();
        this.gameMaxPlayer = r.getGame().getMaxPlayer();
        this.predictScore = r.getRecommendRating();
        this.gameTotalScore = r.getGame().getTotalScore();
        this.gameImg = r.getGame().getImg();
        this.isLike = isLike;
    }
}
