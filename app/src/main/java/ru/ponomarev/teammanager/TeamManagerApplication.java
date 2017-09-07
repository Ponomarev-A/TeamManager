package ru.ponomarev.teammanager;

import android.app.Application;

import ru.ponomarev.teammanager.di.modules.AppComponent;
import ru.ponomarev.teammanager.di.modules.DaggerAppComponent;
import ru.ponomarev.teammanager.di.modules.GamesRepositoryModule;
import ru.ponomarev.teammanager.di.modules.MainThreadModule;
import ru.ponomarev.teammanager.di.modules.ThreadExecutorModule;

/**
 * @author Пономарев Андрей
 */

public class TeamManagerApplication extends Application {

    private static AppComponent sComponent;

    public static AppComponent getComponent() {
        return sComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sComponent = buildComponent();
    }

    private AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .mainThreadModule(new MainThreadModule())
                .threadExecutorModule(new ThreadExecutorModule())
                .gamesRepositoryModule(new GamesRepositoryModule())
                .build();
    }
}
