package com.ssafy.IBG.Game.controller;

import com.ssafy.IBG.Game.dto.*;
import com.ssafy.IBG.Review.dto.ReviewResponse;
import com.ssafy.IBG.Game.domain.Game;
import com.ssafy.IBG.api.dto.Result;
import com.ssafy.IBG.Review.domain.Review;
import com.ssafy.IBG.Score.domain.Score;
import com.ssafy.IBG.Game.service.GameService;
import com.ssafy.IBG.service.InterestService;
import com.ssafy.IBG.Review.service.ReviewService;
import com.ssafy.IBG.Score.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/game")
@Api(tags = "게임")
@RequiredArgsConstructor
@RestController
public class GameApiController {

    private final GameService gameService;
    private final ReviewService reviewService;
    private final InterestService interestService;
    private final ScoreService scoreService;

    @ApiOperation(value = "게임 이름 자동완성 조회", notes = "검색 내용을 포함한 게임 리스트")
    @PostMapping("/search/auto")
    public ResponseEntity<List<GameListResponse>> getSearchAutoComplete(@RequestBody SearchNameRequest request){
        return new ResponseEntity<>(gameService.getGameSearchGame(request), HttpStatus.OK);
    }

    @ApiOperation(value = "게임이름 리스트", notes = "자동완성을 위한 게임 리스트")
    @GetMapping("/auto")
    public ResponseEntity<List<SearchAutoResponse>> getSearchAutoList(){
        return new ResponseEntity<>(gameService.getGameList(), HttpStatus.OK);
    }

    @ApiOperation(value = "게임 이름 조회", notes = "게임 상세")
    @PostMapping("/search")
    public ResponseEntity<GameResponse> getGameByGameName(@RequestBody GameNameRequest request){
        return new ResponseEntity<>(gameService.getGameByGameName(request), HttpStatus.OK);
    }

    @ApiOperation(value = "게임 번호 조회", notes = "게임 상세")
    @GetMapping("/search/{gameNo}/{userNo}")
    public ResponseEntity<GameResponse> getGame(@PathVariable("gameNo") Integer gameNo, @PathVariable("userNo") Integer userNo){
        return new ResponseEntity<>(gameService.getGameByGameNo(gameNo, userNo), HttpStatus.OK);
    }

    @ApiOperation(value = "검색 상세 필터 조회", notes = "게임 리스트")
    @PostMapping("/search/filter")
    public ResponseEntity<List<GameListResponse>> getGameByFilter(@RequestBody SearchFilterRequest request){
        return new ResponseEntity<>(gameService.getGameByFilter(request), HttpStatus.OK);
    }

}

