package ru.ponomarev.teammanager.domain.interactors.impl;

import java.util.List;

import javax.inject.Inject;

import ru.ponomarev.teammanager.TeamManagerApplication;
import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.domain.interactors.IGamesInteractor;
import ru.ponomarev.teammanager.domain.interactors.base.AbstractInteractor;
import ru.ponomarev.teammanager.domain.repository.IGamesRepository;

/**
 * Класс реализация интерактора для отображения списка игр
 */
public class GamesInteractorImpl extends AbstractInteractor implements IGamesInteractor {

    @Inject
    IGamesRepository mGamesRepository;

    private IGamesInteractor.Callback mCallback;

    public GamesInteractorImpl(Callback callback) {
        mCallback = callback;
        TeamManagerApplication.getComponent().inject(this);
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
