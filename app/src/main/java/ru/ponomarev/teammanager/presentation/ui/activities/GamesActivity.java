package ru.ponomarev.teammanager.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import ru.ponomarev.teammanager.R;
import ru.ponomarev.teammanager.data.storage.GamesRepositoryImpl;
import ru.ponomarev.teammanager.data.threading.MainThreadImpl;
import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.domain.executor.impl.ThreadExecutor;
import ru.ponomarev.teammanager.presentation.presenters.IGamesPresenter;
import ru.ponomarev.teammanager.presentation.presenters.impl.GamesPresenterImpl;

public class GamesActivity extends AppCompatActivity implements IGamesPresenter.View {

    private GamesPresenterImpl mGamesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        mGamesPresenter = new GamesPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThreadImpl.getInstance(),
                this,
                new GamesRepositoryImpl()
        );
    }

    @Override
    protected void onResume() {
        super.onResume();

        mGamesPresenter.resume();
    }

    @Override
    public void showProgress() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void hideProgress() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void showError(String message) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void showGamesList(List<Game> games) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void showBlankList() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
