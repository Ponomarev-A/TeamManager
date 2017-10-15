package ru.ponomarev.teammanager.presentation.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ponomarev.teammanager.R;
import ru.ponomarev.teammanager.domain.entity.Game;
import ru.ponomarev.teammanager.presentation.presenters.impl.GamesPresenterImpl;
import ru.ponomarev.teammanager.presentation.ui.adapters.GameItemAdapter;
import ru.ponomarev.teammanager.presentation.views.IGamesView;

/**
 * @author Ponomarev Andrey
 * @date 15/10/2017
 */
public class GamesFragment extends MvpAppCompatFragment implements IGamesView {

    @InjectPresenter
    GamesPresenterImpl mGamesPresenter;

    @BindView(R.id.progress)
    ProgressBar mProgressBar;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private GameItemAdapter mAdapter;

    // Fragment lifecycle >>>

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.games_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mAdapter = new GameItemAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mGamesPresenter.downloadGamesList();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mAdapter = null;
    }

    // <<< Fragment lifecycle

    // IBaseView >>>

    @Override
    public void showProgress() {
        showProgressBar(true);
    }

    @Override
    public void hideProgress() {
        showProgressBar(false);
    }

    @Override
    public void showError(String message) {
        showProgressBar(false);
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    // IBaseView <<<

    // IGamesView >>>

    @Override
    public void hideGamesList() {
        mAdapter.clearGames();
        showList(false);
    }

    @Override
    public void showGamesList(List<Game> gameList) {
        mAdapter.addNewGames(gameList);
        showList(true);
    }

    // <<< IGamesView

    private void showProgressBar(boolean iVisible) {
        mProgressBar.setVisibility(iVisible ? View.VISIBLE : View.GONE);
    }

    private void showList(boolean isVisible) {
        mRecyclerView.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }
}
