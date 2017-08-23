package ru.ponomarev.teammanager.domain.interactors;

import java.util.List;

import ru.ponomarev.teammanager.data.entity.Game;
import ru.ponomarev.teammanager.domain.interactors.base.IInteractor;

/**
 * Интерфейс интерактора для отображения списка игр
 */
public interface IListGamesInteractor extends IInteractor {

    interface Callback {

        void showGamesList(List<Game> games);

        void showBlankWindow();
    }

    // TODO: Add interactor methods here
}
