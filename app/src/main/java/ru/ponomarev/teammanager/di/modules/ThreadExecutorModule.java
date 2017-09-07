package ru.ponomarev.teammanager.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.ponomarev.teammanager.domain.executor.IExecutor;
import ru.ponomarev.teammanager.domain.executor.impl.ThreadExecutor;

/**
 * @author Пономарев Андрей
 */

@Module
public class ThreadExecutorModule {

    @Provides
    @NonNull
    @Singleton
    public IExecutor providesThreadExecutor() {
        return ThreadExecutor.getInstance();
    }
}
