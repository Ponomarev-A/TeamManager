package ru.ponomarev.teammanager.domain.entity;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Пономарев Андрей
 */
public class GameScoreTest {

    @Test
    public void testGetGameScoreAsString() throws Exception {

        GameScore score = new GameScore(1, 10);

        String expectedScore = "1 : 10";
        String actualScore = score.getGameScoreAsString();

        assertThat(actualScore, is(expectedScore));
    }
}