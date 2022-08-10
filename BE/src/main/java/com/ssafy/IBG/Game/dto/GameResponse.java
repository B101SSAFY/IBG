package com.ssafy.IBG.Game.dto;

import com.ssafy.IBG.Review.dto.ReviewResponse;
import com.ssafy.IBG.Game.domain.Game;
import lombok.Data;

import java.util.List;

@Data
public class GameResponse{
    private int gameNo;
    private String gameImg;
    private String gameName;
    private String gameKorName;
    private int gameYear;
    private double gameTotalScore;
    private boolean isLike;
    private double myScore;
    private int gameMinPlayer;
    private int gameMaxPlayer;
    private int gameMinTime;
    private int gameMaxTime;
    private double gameWeight;
    private String gameCategory;
    private String gameDesc;
    private String gameKorDesc;
    private List<ReviewResponse> ResponseReviewList;

    public GameResponse(Game game, boolean isLike, List<ReviewResponse> ResponseReviewList, double myScore) {
        this.gameNo = game.getNo();
        this.gameImg = game.getImg();
        this.gameName = game.getName();
        this.gameKorName = game.getKorName();
        this.gameYear = game.getYear();
        this.gameTotalScore = game.getTotalScore();
        this.isLike = isLike;
        this.myScore = myScore;
        this.gameMinPlayer = game.getMinPlayer();
        this.gameMaxPlayer = game.getMaxPlayer();
        this.gameMinTime = game.getMinTime();
        this.gameMaxTime = game.getMaxTime();
        this.gameWeight = game.getWeight();
        this.gameCategory = game.getCategory();
        this.gameDesc = game.getEngDesc();
        this.gameKorDesc = game.getKorDesc();
        this.ResponseReviewList = ResponseReviewList;
    }
}