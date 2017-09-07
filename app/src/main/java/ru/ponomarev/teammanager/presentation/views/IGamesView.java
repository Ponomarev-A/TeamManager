package ru.ponomarev.teammanager.presentation.views;

import java.util.List;

import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.presentation.ui.IBaseView;

/**
 * @author Пономарев Андрей
 */

public interface IGamesView extends IBaseView {

    void showGamesList(List<Game> games);
    void showBlankList();
}
