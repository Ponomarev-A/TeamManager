package ru.ponomarev.teammanager.domain.interactors.impl;

import java.util.List;

import ru.ponomarev.teammanager.data.entity.Game;
import ru.ponomarev.teammanager.domain.executor.IExecutor;
import ru.ponomarev.teammanager.domain.executor.IMainThread;
import ru.ponomarev.teammanager.domain.interactors.IListGamesInteractor;
import ru.ponomarev.teammanager.domain.interactors.base.AbstractInteractor;
import ru.ponomarev.teammanager.domain.repository.IGamesRepository;

/**
 * Класс реализация интерактора для отображения списка игр
 */
public class ListGamesInteractorImpl extends AbstractInteractor implements IListGamesInteractor {

    private IListGamesInteractor.Callback mCallback;
    private IGamesRepository mGamesRepository;

    public ListGamesInteractorImpl(IExecutor threadExecutor,
                                   IMainThread mainThread,
                                   Callback callback, IGamesRepository repository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mGamesRepository = repository;
    }

    @Override
    public void run() {
        List<Game> gameList = mGamesRepository.getAll();

        if (gameList != null) {
            showGamesList(gameList);
        } else {
            showBlankWindow();
        }
    }

    private void showGamesList(final List<Game> games) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.showGamesList(games);
            }
        });
    }

    private void showBlankWindow() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.showBlankWindow();
            }
        });

    }
}
