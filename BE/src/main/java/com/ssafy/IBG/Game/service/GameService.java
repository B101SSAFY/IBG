package com.ssafy.IBG.Game.service;

import com.ssafy.IBG.Game.domain.Game;
import com.ssafy.IBG.Game.repository.GameRepository;
import com.ssafy.IBG.Game.repository.GameRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

    private final GameRepositorySupport gameRepositorySupport;
    /**
     * @author : 박민주
     * @date : 2022-03-23 오후 5:49
     * @desc: 자동 완성 검색
     **/
    public List<Game> getGameSearchGame(String searchName){
        return gameRepositorySupport.findGameBySearchGame(searchName);
    }

    /**
    * @author : 박민주
    * @date : 2022-04-01 오후 9:51
    * @desc : 자동 완성을 위한 전체 게임 리스트
    **/
    public List<Game> getGameList(){
        return gameRepository.findAll();
    }

    /**
     * @author : 박민주
     * @date : 2022-03-23 오후 5:49
     * @desc: 게임 이름 검색 상세보기
     **/
    public Game getGameByGameName(String gameName){
        return gameRepository.findByName(gameName);
    }


    /**
     * @author : 박민주
     * @date : 2022-03-23 오후 5:49
     * @desc: 게임 번호 상세보기
     **/
    public Game getGameByGameNo(int gameNo){
        return gameRepository.findById(gameNo).get();
//                .orElseThrow(() -> new IllegalArgumentException("해당 게임이 존재하지 않습니다."));
    }

    /**
     * @author : 박민주
     * @date : 2022-03-23 오후 5:49
     * @desc: 검색 상세 필터
     **/
    public List<Game> getGameByFilter(String gameName, String gameKorName, Integer gamePlayer, Integer gameTime, Double gameWeight, Integer gameAge, Double gameScore, List<String> gameCategory) {
        return gameRepositorySupport.findGameByFilter(gameName, gameKorName, gamePlayer, gameTime, gameWeight, gameAge, gameScore, gameCategory);
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
