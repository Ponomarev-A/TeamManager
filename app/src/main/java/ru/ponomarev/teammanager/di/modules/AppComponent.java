package ru.ponomarev.teammanager.di.modules;

import javax.inject.Singleton;

import dagger.Component;
import ru.ponomarev.teammanager.domain.interactors.impl.GamesInteractorImpl;

/**
 * @author Пономарев Андрей
 */

@Component(modules = {
        MainThreadModule.class,
        ThreadExecutorModule.class,
        GamesRepositoryModule.class
})
@Singleton
public interface AppComponent {

    void inject(GamesInteractorImpl gamesInteractor);

}
