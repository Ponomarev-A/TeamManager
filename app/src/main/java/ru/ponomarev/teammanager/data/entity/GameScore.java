package ru.ponomarev.teammanager.data.entity;

/**
 * @author Пономарев Андрей
 * Класс с результатом игры
 */

class GameScore {

    private final int mTeamAScore;
    private final int mTeamBScore;

    GameScore(int teamAScore, int teamBScore) {
        mTeamAScore = teamAScore;
        mTeamBScore = teamBScore;
    }

    String getGameScoreAsString() {
        return mTeamAScore + " : " + mTeamBScore;
    }
}
