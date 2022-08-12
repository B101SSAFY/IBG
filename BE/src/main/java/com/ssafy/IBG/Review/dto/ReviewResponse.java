package com.ssafy.IBG.Review.dto;

import com.ssafy.IBG.Review.domain.Review;
import com.ssafy.IBG.Score.domain.Score;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewResponse{
    private int reviewNo;
    private Double scoreRating;
    private String userNick;
    private String reviewContent;
    private String reviewReg;

    @Builder
    public ReviewResponse(Review review, Score score) {
        this.reviewNo = review.getNo();
        this.scoreRating = score.getRating();
        this.userNick = review.getUser().getNick();
        this.reviewContent = review.getContent();
        this.reviewReg = review.getCreatedDate().toString();
    }
}

