package ru.ponomarev.teammanager.presentation.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ponomarev.teammanager.R;
import ru.ponomarev.teammanager.domain.entity.Game;

/**
 * @author Пономарев Андрей
 * Адаптер для отображения списка игр
 */

public class GameItemAdapter extends RecyclerView.Adapter<GameItemAdapter.GameItemViewHolder> {

    private final List<Game> mGamesList;

    public GameItemAdapter() {
        mGamesList = new ArrayList<>();
    }

    @Override
    public GameItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
        return new GameItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GameItemViewHolder holder, int position) {
        Game game = mGamesList.get(position);

        holder.mItemGameDateTime.setText(game.getDate() + " " + game.getTime());
        holder.mItemGameScore.setText(game.getGameScore());
    }

    @Override
    public int getItemCount() {
        return mGamesList.size();
    }

    public void addNewGames(@NonNull List<Game> gameList) {
        mGamesList.clear();
        mGamesList.addAll(gameList);

        notifyDataSetChanged();
    }


    static class GameItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_game_date_time)
        TextView mItemGameDateTime;
        @BindView(R.id.item_game_score)
        TextView mItemGameScore;

        GameItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
