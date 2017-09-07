package ru.ponomarev.teammanager.presentation.presenters.impl;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import ru.ponomarev.teammanager.TeamManagerApplication;
import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.domain.interactors.IGamesInteractor;
import ru.ponomarev.teammanager.domain.interactors.impl.GamesInteractorImpl;
import ru.ponomarev.teammanager.domain.repository.IGamesRepository;
import ru.ponomarev.teammanager.presentation.presenters.IGamesPresenter;
import ru.ponomarev.teammanager.presentation.presenters.base.AbstractPresenter;
import ru.ponomarev.teammanager.presentation.views.IGamesView;

/**
 * Реализация презентера для вывода списка игр
 */
@InjectViewState(view = IGamesView.class)
public class GamesPresenterImpl extends AbstractPresenter<IGamesView> implements IGamesPresenter, IGamesInteractor.Callback {

    @Inject
    IGamesRepository mGamesRepository;

    public GamesPresenterImpl() {
        TeamManagerApplication.getComponent().inject(this);
    }

    @Override
    public void resume() {
        getViewState().showProgress();

        // initialize the interactor
        GamesInteractorImpl interactor = new GamesInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                mGamesRepository
        );

        // run the interactor
        interactor.execute();

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onGamesLoaded(List<Game> games) {
        getViewState().hideProgress();

        if (games != null) {
            if (!games.isEmpty())
                getViewState().showGamesList(games);
            else
                getViewState().showBlankList();
        } else {
            onError("Games load failed");
        }
    }
}
