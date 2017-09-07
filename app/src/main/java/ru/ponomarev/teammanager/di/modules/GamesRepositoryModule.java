package ru.ponomarev.teammanager.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.ponomarev.teammanager.data.storage.GamesRepositoryImpl;
import ru.ponomarev.teammanager.domain.repository.IGamesRepository;

/**
 * @author Пономарев Андрей
 */

@Module
public class GamesRepositoryModule {

    @Provides
    @NonNull
    @Singleton
    public IGamesRepository providesGamesRepository() {
        return new GamesRepositoryImpl();
    }
}
