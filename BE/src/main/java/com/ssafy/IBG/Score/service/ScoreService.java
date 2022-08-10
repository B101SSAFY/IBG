package com.ssafy.IBG.Score.service;

import com.ssafy.IBG.Score.domain.Score;
import com.ssafy.IBG.Game.repository.GameRepository;
import com.ssafy.IBG.Score.dto.ScoreRequest;
import com.ssafy.IBG.Score.repository.ScoreRepository;
import com.ssafy.IBG.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScoreService {

    private final ScoreRepository scoreRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Transactional
    public void registScore(int gameNo, ScoreRequest request) {
        try{
            Score score = scoreRepository.findByUser_UserNoAndGame_No(request.getUserNo(), gameNo).get();
            score.updateScore(request.getScoreRating());
        }catch (NoSuchElementException e){
            scoreRepository.save(Score.builder().game(gameRepository.findById(gameNo).get()).user(userRepository.findUserByUserNo(request.getUserNo())).build());
        }
    }

    public int getScoreCnt(Integer userNo){
        return scoreRepository.countByUser_UserNo(userNo);
    }

    public Score getScoreByUserNoGameNo(Integer userNo, Integer gameNo){
        Score score = scoreRepository.findByUser_UserNoAndGame_No(userNo, gameNo)
                .orElse(Score.builder().rating(0).build());
        return score;
    }

    /**
    * @author : 박민주
    * @date : 2022-04-04 오전 2:40
    * @desc : 유저가 평점 매긴 게임 찾기
    **/
    public List<Score> getScoreByUserNo(Integer userNo){
        return scoreRepository.findByUser_UserNo(userNo);
    }

    /**
     * @author : 권오범
     * @date : 2022-04-01 오후 03:16
     * @desc : 유저가 평가한 게임 목록 평점 순 상위 10개 가져오기
     **/
    public List<Score> getScoreListByUserNoOrderByRating(Integer userNo){
        return scoreRepository.findByUser_UserNoOrderByRatingDesc(userNo);
    }

}
