package com.ssafy.IBG.Game.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.IBG.Game.domain.Game;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.ssafy.IBG.Game.domain.QGame.game;

import java.util.List;

@Repository
public class GameRepositorySupport extends QuerydslRepositorySupport {

    private JPAQueryFactory jpaQueryFactory;

    public GameRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Game.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Game> findGameBySearchGame(String searchName){
        return jpaQueryFactory.selectFrom(game)
                .where(game.name.contains(searchName))
                .fetch();
    }

    public List<Game> findGameByFilter(String gameName, String gameKorName, Integer gamePlayer, Integer gameTime, Double gameWeight, Integer gameAge, Double gameScore, List<String> gameCategory) {


        BooleanBuilder builder = new BooleanBuilder();

        if(gameName != null){
            builder.and(game.name.contains(gameName));
        }
        if (gameKorName != null){
            builder.and(game.korName.contains(gameKorName));
        }
        if(gamePlayer != null){
            builder.and(game.minPlayer.goe(gamePlayer));
        }
        if(gameTime != null){
            builder.and(game.maxTime.goe(gameTime));
        }
        if(gameAge != null){
            builder.and(game.age.loe(gameAge));
        }
        if(gameWeight != null){
            builder.and(game.weight.loe(gameWeight));
        }
        if(gameScore != null){
            builder.and(game.totalScore.goe(gameScore));
        }
        if(gameCategory != null){
            for (String c : gameCategory) {
                builder.and(game.category.contains(c));
            }
        }

        return jpaQueryFactory.selectFrom(game)
                .where(builder)
                .fetch();
    }

    public double findAvgWeight() {
        return jpaQueryFactory.select(game.weight.avg())
                .from(game)
                .fetchOne();
    }
}
