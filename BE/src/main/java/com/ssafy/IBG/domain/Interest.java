package com.ssafy.IBG.domain;

import com.ssafy.IBG.Game.domain.Game;
import com.ssafy.IBG.User.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
@NoArgsConstructor
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int likeNo;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userNo")
    private User user;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "gameNo")
    private Game game;

    public Interest(User user, Game game) {
        this.user = user;
        this.game = game;
    }
}
