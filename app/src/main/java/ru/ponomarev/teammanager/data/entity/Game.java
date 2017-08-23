package ru.ponomarev.teammanager.data.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author Пономарев Андрей
 * Базовый класс игрового матча
 */

public class Game {

    private static final String PATTERN_DATE = "dd.MM.yyyy";
    private static final String PATTERN_TIME = "HH:mm:ss";
    private static final Locale LOCALE = Locale.ENGLISH;


    private Date mDateTime;
    private List<Player> mHomeTeam;
    private List<Player> mGuestTeam;
    private GameScore mGameScore;


    public String getDate() {
        return new SimpleDateFormat(PATTERN_DATE, LOCALE).format(mDateTime);
    }

    public String getTime() {
        return new SimpleDateFormat(PATTERN_TIME, LOCALE).format(mDateTime);
    }

    public void setDateTime(Date dateTime) {
        mDateTime = dateTime;
    }

    public List<Player> getHomeTeam() {
        return mHomeTeam;
    }

    public void setHomeTeam(List<Player> homeTeam) {
        mHomeTeam = homeTeam;
    }

    public List<Player> getGuestTeam() {
        return mGuestTeam;
    }

    public void setGuestTeam(List<Player> guestTeam) {
        mGuestTeam = guestTeam;
    }

    public String getGameScore() {
        return mGameScore.get();
    }

    public void setGameScore(int homeTeamScore, int guestTeamScore) {
        mGameScore = new GameScore(homeTeamScore, guestTeamScore);
    }
}
