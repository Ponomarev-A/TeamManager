package ru.ponomarev.teammanager.presentation.presenters.impl;

import java.util.List;

import javax.inject.Inject;

import ru.ponomarev.teammanager.TeamManagerApplication;
import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.domain.interactors.IGamesInteractor;
import ru.ponomarev.teammanager.domain.interactors.impl.GamesInteractorImpl;
import ru.ponomarev.teammanager.domain.repository.IGamesRepository;
import ru.ponomarev.teammanager.presentation.presenters.IGamesPresenter;
import ru.ponomarev.teammanager.presentation.presenters.base.AbstractPresenter;

/**
 * Реализация презентера для вывода списка игр
 */
public class GamesPresenterImpl extends AbstractPresenter implements IGamesPresenter, IGamesInteractor.Callback {

    @Inject
    IGamesRepository mGamesRepository;

    private View mView;

    public GamesPresenterImpl(View view) {
        mView = view;
        TeamManagerApplication.getComponent().inject(this);
    }

    @Override
    public void resume() {
        mView.showProgress();

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
        mView.hideProgress();

        if (games != null) {
            if (!games.isEmpty())
                mView.showGamesList(games);
            else
                mView.showBlankList();
        } else {
            onError("Games load failed");
        }
    }
}
