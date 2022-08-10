package com.ssafy.IBG.Score.controller;

import com.ssafy.IBG.Score.service.ScoreService;
import com.ssafy.IBG.Score.dto.ScoreRequest;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/score")
public class ScoreApiController {

    private final ScoreService scoreService;

    @ApiOperation(value = "평점 입력 및 수정")
    @PostMapping("/{gameNo}")
    public ResponseEntity<String> setScore(@PathVariable("gameNo") int gameNo, @RequestBody ScoreRequest request){
        scoreService.registScore(gameNo, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
