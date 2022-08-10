package com.ssafy.IBG.Game.repository;

import com.ssafy.IBG.Game.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Optional<Game> findByName(String gameName);

}