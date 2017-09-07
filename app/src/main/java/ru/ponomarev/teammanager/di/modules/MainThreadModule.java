package ru.ponomarev.teammanager.di.modules;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.ponomarev.teammanager.data.threading.MainThreadImpl;
import ru.ponomarev.teammanager.domain.executor.IMainThread;

/**
 * @author Пономарев Андрей
 */

@Module
public class MainThreadModule {

    @Provides
    @NonNull
    @Singleton
    public IMainThread providesMainThread() {
        return MainThreadImpl.getInstance();
    }
}
