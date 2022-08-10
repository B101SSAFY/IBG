package com.ssafy.IBG.Review.controller;

import com.ssafy.IBG.Review.dto.ReviewRequest;
import com.ssafy.IBG.Review.dto.ReviewResponse;
import com.ssafy.IBG.Review.service.ReviewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/review")
@Api(tags = "리뷰")
@RestController
@RequiredArgsConstructor
public class ReviewApiController {

    private final ReviewService reviewService;

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
