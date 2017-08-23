package ru.ponomarev.teammanager.data.entity;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import ru.ponomarev.teammanager.data.entity.utils.PlayerEntitiesGenerator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Пономарев Андрей
 */
public class GameTest {

    private static final Date DATE = new GregorianCalendar(2000, 1, 2, 3, 4, 5).getTime();

    @Test
    public void testGetDate() throws Exception {
        Game game = new Game();
        game.setDateTime(DATE);

        String expectedDate = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).format(DATE);
        String actualDate = game.getDate();

        assertThat(actualDate, is(expectedDate));
    }

    @Test
    public void testGetTime() throws Exception {
        Game game = new Game();
        game.setDateTime(DATE);

        String expectedTime = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(DATE);
        String actualTime = game.getTime();

        assertThat(actualTime, is(expectedTime));
    }

    @Test
    public void testGetHomeTeam() throws Exception {
        List<Player> expectedPlayersList = PlayerEntitiesGenerator.createRandomPlayersList(false);

        Game game = new Game();
        game.setHomeTeam(expectedPlayersList);

        List<Player> actualPlayersList = game.getHomeTeam();

        assertThat(actualPlayersList, is(expectedPlayersList));
    }

    @Test
    public void testGetGuestTeam() throws Exception {
        List<Player> expectedPlayersList = PlayerEntitiesGenerator.createRandomPlayersList(false);

        Game game = new Game();
        game.setGuestTeam(expectedPlayersList);

        List<Player> actualPlayersList = game.getGuestTeam();

        assertThat(actualPlayersList, is(expectedPlayersList));
    }

    @Test
    public void testGetGameScore() throws Exception {
        Game game = new Game();
        game.setGameScore(5, 0);

        assertThat(game.getGameScore(), is("5 : 0"));
    }

}