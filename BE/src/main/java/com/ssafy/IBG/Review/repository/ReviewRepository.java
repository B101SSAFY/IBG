package com.ssafy.IBG.Review.repository;

import com.ssafy.IBG.Review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    // TODO: paging 구현 혹은 50개로 자르기
    List<Review> findByGame_NoOrderByNoDesc(int gameNo);
}
