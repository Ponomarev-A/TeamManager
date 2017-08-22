package ru.ponomarev.teammanager.data.entity;

/**
 * @author Пономарев Андрей
 * Класс игрока в хоккей
 */

class HockeyPlayer extends Player {

    private enum HockeyRole implements IRole {

        FORWARD,
        DEFENDER,
        GOALKEEPER
    }

    public HockeyPlayer(String name, int age, HockeyRole role) {
        super(name, age, role);
    }
}
