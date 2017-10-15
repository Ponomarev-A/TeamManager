package ru.ponomarev.teammanager.presentation.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.ponomarev.teammanager.R;
import ru.ponomarev.teammanager.presentation.ui.fragments.GamesFragment;

public class GamesActivity extends MvpAppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    // Activity lifecycle >>>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_activity);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager().
                    beginTransaction().
                    add(R.id.fragment_container, new GamesFragment()).
                    commit();
        }
    }

    // <<< Activity lifecycle
}
