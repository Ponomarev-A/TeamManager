package ru.ponomarev.teammanager.data.storage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.domain.repository.IGamesRepository;

/**
 * @author Пономарев Андрей
 * Репозиторий с данными об играх
 */

public class GamesRepositoryImpl implements IGamesRepository {

    @Override
    public Game get(long id) {
        return new Game();
    }

    @Override
    public List<Game> getAll() {
        List<Game> games = new ArrayList<>();
        games.add(new Game().setDateTime(new Date()).setGameScore(1, 0).setId(2));
        games.add(new Game().setDateTime(new Date()).setGameScore(4, 5).setId(3));
        games.add(new Game().setDateTime(new Date()).setGameScore(2, 1).setId(4));

        // let's simulate some network/database lag
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return games;
    }
}
