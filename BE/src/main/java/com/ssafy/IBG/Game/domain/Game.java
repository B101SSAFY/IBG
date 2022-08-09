package com.ssafy.IBG.Game.domain;

import com.ssafy.IBG.domain.Review;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    @Column(unique = true)
    private String name;

    private String korName;

    private int minPlayer;

    private int maxPlayer;

    private int minTime;

    private int maxTime;

    private int year;

    private double totalScore;

    private String img;

    private int age;

    private String category;

    private double weight;

    @Lob
    @Column(length = 6000)
    private String engDesc;

    @Lob
    @Column(length = 6000)
    private String korDesc;

    @OneToMany(mappedBy = "game")
    private List<Review> review;

}

