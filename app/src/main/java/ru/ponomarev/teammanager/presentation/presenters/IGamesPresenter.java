package ru.ponomarev.teammanager.presentation.presenters;


import java.util.List;

import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.presentation.presenters.base.IBasePresenter;
import ru.ponomarev.teammanager.presentation.ui.IBaseView;

public interface IGamesPresenter extends IBasePresenter {

    interface View extends IBaseView {
        void showGamesList(List<Game> games);
        void showBlankList();
    }

    // TODO: Add your presenter methods

}
