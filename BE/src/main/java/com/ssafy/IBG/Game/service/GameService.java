package com.ssafy.IBG.Game.service;

import static com.ssafy.IBG.Game.GameConstant.*;
import com.ssafy.IBG.Game.domain.Game;
import com.ssafy.IBG.Game.dto.*;
import com.ssafy.IBG.Game.repository.GameRepository;
import com.ssafy.IBG.Game.repository.GameRepositorySupport;
import com.ssafy.IBG.Review.dto.ReviewResponse;
import com.ssafy.IBG.Score.domain.Score;
import com.ssafy.IBG.Score.repository.ScoreRepository;
import com.ssafy.IBG.Review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final ReviewRepository reviewRepository;
    private final ScoreRepository scoreRepository;
    private final GameRepositorySupport gameRepositorySupport;

    public List<GameListResponse> getGameSearchGame(SearchNameRequest request){
        return gameRepositorySupport.findGameBySearchGame(request.getSearchName())
                // TODO: interest 변경
                .stream().map(game -> GameListResponse.builder().game(game).isLike(false).build())
                .collect(Collectors.toList());
    }

    public List<SearchAutoResponse> getGameList(){
        return gameRepository.findAll().stream()
                .map(game -> new SearchAutoResponse(game))
                .collect(Collectors.toList());
    }

    public GameResponse getGameByGameName(GameNameRequest request){
        Game game = gameRepository.findByName(request.getGameName())
                .orElseThrow(() -> new IllegalArgumentException(MISSMATCH_NAME_ERROR_MESSAGE));
        // TODO: left join dsl 구현
        List<ReviewResponse> reviewList = reviewRepository.findByGame_NoOrderByNoDesc(game.getNo()).stream()
                .map(review -> {
                    Score score = scoreRepository.findByUser_NoAndGame_No(review.getUser().getNo(), game.getNo())
                            .orElse(Score.builder().build());
                    return new ReviewResponse(review, score);
                }).collect(Collectors.toList());

        // TODO: interestRepository.findInterestByUserNoGameNo()
        return new GameResponse(game,
                false,
                reviewList,
                scoreRepository.findByUser_NoAndGame_No(request.getUserNo(), game.getNo()).orElse(Score.builder().build()).getRating());
    }


    public GameResponse getGameByGameNo(int gameNo, int userNo){
        Game game = gameRepository.findById(gameNo)
                .orElseThrow(() -> new IllegalArgumentException(MISSMATCH_NO_ERROR_MESSAGE));
        // TODO: left join dsl 구현
        List<ReviewResponse> reviewList = reviewRepository.findByGame_NoOrderByNoDesc(game.getNo()).stream()
                .map(review -> {
                    Score score = scoreRepository.findByUser_NoAndGame_No(review.getUser().getNo(), game.getNo())
                            .orElse(Score.builder().build());
                    return new ReviewResponse(review, score);
                }).collect(Collectors.toList());

        // TODO: interestRepository.findInterestByUserNoGameNo()
        return new GameResponse(game,
                false,
                reviewList,
                scoreRepository.findByUser_NoAndGame_No(userNo, game.getNo()).orElse(Score.builder().build()).getRating());
    }

    public List<GameListResponse> getGameByFilter(SearchFilterRequest request) {
        return gameRepositorySupport.findGameByFilter(request)
                // TODO: interest 변경
                .stream().map(game -> new GameListResponse(game, false))
                .collect(Collectors.toList());
    }

    /**
     * @author : 권오범
     * @date : 2022-04-03 오후 3:49
     * @desc: 게임 평균 난이도
     **/
    public double getAvgWeight(){
        return gameRepositorySupport.findAvgWeight();
    }
}
