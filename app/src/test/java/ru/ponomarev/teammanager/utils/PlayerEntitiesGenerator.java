package ru.ponomarev.teammanager.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ru.ponomarev.teammanager.domain.entity.HockeyPlayer;
import ru.ponomarev.teammanager.domain.entity.HockeyRole;
import ru.ponomarev.teammanager.domain.entity.IRole;
import ru.ponomarev.teammanager.domain.entity.Player;

/**
 * @author Пономарев Андрей
 */

public class PlayerEntitiesGenerator {

    private static final int SIZE = 10;
    private static final int START_CHAR = (int) 'A';
    private static final int END_CHAR = (int) 'Z';
    private static final int MAX_AGE = 100;
    private static final Random RANDOM = new Random();

    public static List<Player> createRandomPlayersList(boolean includeId) {
        ArrayList<Player> list = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            list.add(createRandomPlayer(includeId));
        }
        return list;
    }

    public static Player createRandomPlayer(boolean includeId) {
        long id = Math.abs(RANDOM.nextLong());
        int age = Math.abs(RANDOM.nextInt(MAX_AGE));
        String name = createRandomString();
        IRole role = createRandomRole();


        HockeyPlayer player = new HockeyPlayer(name, age, role);

        if (includeId) {
            player.setId(id);
        }
        return player;
    }

    private static IRole createRandomRole() {
        int roleIndex = RANDOM.nextInt(HockeyRole.values().length);
        return HockeyRole.values()[roleIndex];
    }

    private static String createRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            int value = START_CHAR + RANDOM.nextInt(
                    END_CHAR - START_CHAR
            );
            sb.append((char) value);
        }
        return sb.toString();
    }
}
