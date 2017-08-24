package ru.ponomarev.teammanager.domain.interactors;

import java.util.List;

import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.domain.interactors.base.IInteractor;

/**
 * Интерфейс интерактора для отображения списка игр
 */
public interface IGamesInteractor extends IInteractor {

    interface Callback {

        void onGamesLoaded(List<Game> games);
    }

    // TODO: Add interactor methods here
}
