package com.ssafy.IBG.Score.repository;

import com.ssafy.IBG.Score.domain.Score;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Integer> {

    Optional<Score> findByUser_NoAndGame_No(int userNo, int gameNo);

    int countByUser_No(int userNo);

    List<Score> findByUser_No(int userNo);

    List<Score> findByUser_NoOrderByRatingDesc(int userNo);

}
