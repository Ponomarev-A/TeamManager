package ru.ponomarev.teammanager.domain.interactors.impl;

import java.util.List;

import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.domain.executor.IExecutor;
import ru.ponomarev.teammanager.domain.executor.IMainThread;
import ru.ponomarev.teammanager.domain.interactors.IGamesInteractor;
import ru.ponomarev.teammanager.domain.interactors.base.AbstractInteractor;
import ru.ponomarev.teammanager.domain.repository.IGamesRepository;

/**
 * Класс реализация интерактора для отображения списка игр
 */
public class GamesInteractorImpl extends AbstractInteractor implements IGamesInteractor {

    private IGamesInteractor.Callback mCallback;
    private IGamesRepository mGamesRepository;

    public GamesInteractorImpl(IExecutor threadExecutor,
                               IMainThread mainThread,
                               Callback callback, IGamesRepository repository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mGamesRepository = repository;
    }

    @Override
    public void run() {
        final List<Game> games = mGamesRepository.getAll();

        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onGamesLoaded(games);
            }
        });
    }
}
