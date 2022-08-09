package com.ssafy.IBG.Game.repository;

import com.ssafy.IBG.Game.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Game findByName(String gameName);

}