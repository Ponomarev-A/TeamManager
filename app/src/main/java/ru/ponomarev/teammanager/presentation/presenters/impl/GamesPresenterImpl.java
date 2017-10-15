package ru.ponomarev.teammanager.presentation.presenters.impl;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.domain.interactors.IGamesInteractor;
import ru.ponomarev.teammanager.domain.interactors.impl.GamesInteractorImpl;
import ru.ponomarev.teammanager.presentation.presenters.IGamesPresenter;
import ru.ponomarev.teammanager.presentation.presenters.base.AbstractPresenter;
import ru.ponomarev.teammanager.presentation.views.IGamesView;

/**
 * Реализация презентера для вывода списка игр
 */
@InjectViewState(view = IGamesView.class)
public class GamesPresenterImpl extends AbstractPresenter<IGamesView> implements IGamesPresenter, IGamesInteractor.Callback {

    // IGamesPresenter >>>

    @Override
    public void downloadGamesList() {

        getViewState().showProgress();

        // initialize the interactor
        GamesInteractorImpl interactor = new GamesInteractorImpl(this);

        // run the interactor
        interactor.execute();
    }

    // IGamesPresenter <<<

    // IGamesInteractor.Callback >>>

    @Override
    public void onGamesLoaded(List<Game> games) {
        getViewState().hideProgress();

        if (games != null) {
            if (!games.isEmpty())
                getViewState().showGamesList(games);
            else {
                getViewState().hideGamesList();
            }
        } else {
            getViewState().showError("Games load failed");
        }
    }

    // IGamesInteractor.Callback <<<
}
