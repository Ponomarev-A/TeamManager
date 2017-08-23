package ru.ponomarev.teammanager.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import ru.ponomarev.teammanager.domain.entity.Game;

/**
 * @author Пономарев Андрей
 */

public class GameEntitiesGenerator {

    private static final int SIZE = 10;
    private static final Random RANDOM = new Random();

    public static List<Game> createRandomGamesList(boolean includeId) {
        ArrayList<Game> list = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(createRandomGame(includeId));
        }
        return list;
    }

    public static Game createRandomGame(boolean includeId) {
        Game game = new Game();

        game.setDateTime(new Date(System.currentTimeMillis()));
        game.setHomeTeam(PlayerEntitiesGenerator.createRandomPlayersList(true));
        game.setGuestTeam(PlayerEntitiesGenerator.createRandomPlayersList(true));
        game.setGameScore(RANDOM.nextInt(10), RANDOM.nextInt(10));

        if (includeId) {
            game.setId(Math.abs(RANDOM.nextLong()));
        }
        return game;
    }
}