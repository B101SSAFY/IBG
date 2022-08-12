package com.ssafy.IBG.Score.domain;

import com.ssafy.IBG.Game.domain.Game;
import com.ssafy.IBG.User.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Entity
@NoArgsConstructor
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userNo")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "gameNo")
    private Game game;

    private double rating;

    @Builder
    public Score(User user, Game game, int rating){
        this.user = user;
        this.game = game;
        this.rating = rating;
    }

    public Score updateScore(int rating){
        this.rating = rating;
        return this;
    }

}
