package com.ssafy.IBG.Review.service;

import com.ssafy.IBG.Game.domain.Game;
import com.ssafy.IBG.Game.repository.GameRepository;
import com.ssafy.IBG.Review.domain.Review;
import com.ssafy.IBG.Review.dto.ReviewRequest;
import com.ssafy.IBG.Review.dto.ReviewResponse;
import com.ssafy.IBG.Review.repository.ReviewRepository;
import com.ssafy.IBG.Score.domain.Score;
import com.ssafy.IBG.Score.repository.ScoreRepository;
import com.ssafy.IBG.User.domain.User;
import com.ssafy.IBG.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.ssafy.IBG.Game.GameConstant.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final GameRepository gameRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ScoreRepository scoreRepository;

    public List<ReviewResponse> getReviewByGameNo(int gameNo){
        // TODO: join
        return reviewRepository.findByGame_NoOrderByNoDesc(gameNo).stream()
                .map(review -> new ReviewResponse(review, findScoreByUserNoAndGameNo(review.getUser().getNo(), gameNo))
                ).collect(Collectors.toList());
    }

    private Score findScoreByUserNoAndGameNo(int userNo, int gameNo){
        return scoreRepository.findByUser_NoAndGame_No(userNo, gameNo)
                .orElse(Score.builder().build());
    }

    @Transactional
    public void saveReview(int gameNo, ReviewRequest request){
        reviewRepository.save(Review.builder()
                .game(findGameById(gameNo))
                .user(findUserById(request.getUserNo()))
                .reviewContent(request.getContent()).build());
    }

    private Game findGameById(int gameNo){
        return gameRepository.findById(gameNo).orElseThrow(() -> new IllegalArgumentException(MISSMATCH_NO_ERROR_MESSAGE));
    }

    private User findUserById(int userNo){
        return userRepository.findUserByUserNo(userNo);
    }

}
