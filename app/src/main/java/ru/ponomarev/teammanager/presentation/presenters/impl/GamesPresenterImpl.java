package ru.ponomarev.teammanager.presentation.presenters.impl;

import java.util.List;

import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.domain.executor.IExecutor;
import ru.ponomarev.teammanager.domain.executor.IMainThread;
import ru.ponomarev.teammanager.domain.interactors.IGamesInteractor;
import ru.ponomarev.teammanager.domain.interactors.impl.GamesInteractorImpl;
import ru.ponomarev.teammanager.domain.repository.IGamesRepository;
import ru.ponomarev.teammanager.presentation.presenters.IGamesPresenter;
import ru.ponomarev.teammanager.presentation.presenters.base.AbstractPresenter;

/**
 * Реализация презентера для вывода списка игр
 */
public class GamesPresenterImpl extends AbstractPresenter implements IGamesPresenter, IGamesInteractor.Callback {

    private View mView;
    private IGamesRepository mGamesRepository;

    public GamesPresenterImpl(IExecutor executor,
                              IMainThread mainThread,
                              View view,
                              IGamesRepository gamesRepository) {
        super(executor, mainThread);
        mView = view;
        mGamesRepository = gamesRepository;
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
