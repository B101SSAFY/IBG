package com.ssafy.IBG.Review.domain;

import com.ssafy.IBG.Game.domain.BaseTimeEntity;
import com.ssafy.IBG.Game.domain.Game;
import com.ssafy.IBG.User.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userNo")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "gameNo")
    private Game game;

    @Column(length = 6000)
    private String content;

    @Builder
    public Review(User user, Game game, String reviewContent) {
        this.user = user;
        this.game = game;
        this.content = reviewContent;
    }

}

