package com.ssafy.IBG.Review.controller;

import com.ssafy.IBG.api.dto.Result;
import com.ssafy.IBG.Review.dto.ReviewRequest;
import com.ssafy.IBG.Review.dto.ReviewResponse;
import com.ssafy.IBG.Game.domain.Game;
import com.ssafy.IBG.Review.domain.Review;
import com.ssafy.IBG.Score.domain.Score;
import com.ssafy.IBG.domain.User;
import com.ssafy.IBG.Game.service.GameService;
import com.ssafy.IBG.Review.service.ReviewService;
import com.ssafy.IBG.Score.service.ScoreService;
import com.ssafy.IBG.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/review")
@Api(tags = "리뷰")
@RestController
@RequiredArgsConstructor
public class ReviewApiController {

    private final ReviewService reviewService;

    /**
    * @author : 박민주
    * @date : 2022-03-23 오후 6:22
    * @desc: 게임 하나의 리뷰 목록
    **/

    @ApiOperation(value = "리뷰 조회", notes = "리뷰 조회")
    @GetMapping("/{gameNo}")
    public ResponseEntity<List<ReviewResponse>> getReviewList(@PathVariable("gameNo") int gameNo){
        return new ResponseEntity<>(reviewService.getReviewByGameNo(gameNo), HttpStatus.OK);
    }

    @ApiOperation(value = "리뷰 등록", notes = "리뷰 등록")
    @PostMapping("/{gameNo}")
    public ResponseEntity<String> setReview(@PathVariable("gameNo") int gameNo, @RequestBody ReviewRequest request){
        reviewService.saveReview(gameNo, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
