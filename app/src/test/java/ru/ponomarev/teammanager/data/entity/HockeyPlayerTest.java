package ru.ponomarev.teammanager.data.entity;

import org.junit.Test;

import ru.ponomarev.teammanager.data.entity.utils.PlayerEntitiesGenerator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Пономарев Андрей
 */
public class HockeyPlayerTest {

    @Test
    public void testEqualsAndHashcode() throws Exception {

        Player player = PlayerEntitiesGenerator.createRandomPlayer(true);

        HockeyPlayer playerA = new HockeyPlayer(player.getName(), player.getAge(), player.getRole());
        HockeyPlayer playerB = new HockeyPlayer(player.getName(), player.getAge(), player.getRole());

        playerA.setId(player.getId());
        playerB.setId(player.getId());

        assertThat(playerA, is(playerB));
        assertThat(playerA.hashCode(), is(playerB.hashCode()));
    }
}