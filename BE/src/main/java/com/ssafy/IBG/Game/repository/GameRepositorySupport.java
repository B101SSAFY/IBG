package com.ssafy.IBG.Game.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.IBG.Game.domain.Game;
import com.ssafy.IBG.Game.dto.SearchFilterRequest;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.ssafy.IBG.Game.domain.QGame.game;

import java.util.List;

@Repository
public class GameRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public GameRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Game.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Game> findGameBySearchGame(String searchName){
        return jpaQueryFactory.selectFrom(game)
                .where(game.name.contains(searchName))
                .fetch();
    }

    public List<Game> findGameByFilter(SearchFilterRequest request) {


        BooleanBuilder builder = new BooleanBuilder();

        if(request.getGameName() != null){
            builder.and(game.name.contains(request.getGameName()));
        }
        if (request.getGameKorName() != null){
            builder.and(game.korName.contains(request.getGameKorName()));
        }
        if(request.getGamePlayer() != null){
            builder.and(game.minPlayer.goe(request.getGamePlayer()));
        }
        if(request.getGameTime() != null){
            builder.and(game.maxTime.goe(request.getGameTime()));
        }
        if(request.getGameAge() != null){
            builder.and(game.age.loe(request.getGameAge()));
        }
        if(request.getGameWeight() != null){
            builder.and(game.weight.loe(request.getGameWeight()));
        }
        if(request.getGameScore() != null){
            builder.and(game.totalScore.goe(request.getGameScore()));
        }
        if(request.getGameCategory() != null){
            for (String c : request.getGameCategory()) {
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
