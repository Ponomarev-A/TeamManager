package ru.ponomarev.teammanager.domain.repository;

import java.util.List;

import ru.ponomarev.teammanager.domain.entity.Game;

/**
 * Интерфейс резитория с информацией об играх
 */
public interface IGamesRepository {

    Game get(long id);

    List<Game> getAll();
}
