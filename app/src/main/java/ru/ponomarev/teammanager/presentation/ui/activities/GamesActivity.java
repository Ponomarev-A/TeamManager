package ru.ponomarev.teammanager.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ponomarev.teammanager.R;
import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.presentation.presenters.IGamesPresenter;
import ru.ponomarev.teammanager.presentation.presenters.impl.GamesPresenterImpl;
import ru.ponomarev.teammanager.presentation.ui.adapters.GameItemAdapter;

public class GamesActivity extends AppCompatActivity implements IGamesPresenter.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.list_games)
    RecyclerView mListGames;

    private GamesPresenterImpl mGamesPresenter;
    private GameItemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        setSupportActionBar(mToolbar);

        mAdapter = new GameItemAdapter();

        mListGames.setLayoutManager(new LinearLayoutManager(this));
        mListGames.setAdapter(mAdapter);

        mGamesPresenter = new GamesPresenterImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mGamesPresenter.resume();
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }

    @Override
    public void showError(String message) {
    }

    @Override
    public void showGamesList(List<Game> gameList) {
        mAdapter.addNewGames(gameList);
    }

    @Override
    public void showBlankList() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
