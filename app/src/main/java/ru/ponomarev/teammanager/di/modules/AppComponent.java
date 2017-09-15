package ru.ponomarev.teammanager.di.modules;

import javax.inject.Singleton;

import dagger.Component;
import ru.ponomarev.teammanager.domain.interactors.base.AbstractInteractor;
import ru.ponomarev.teammanager.domain.interactors.impl.GamesInteractorImpl;
import ru.ponomarev.teammanager.presentation.ui.activities.GamesActivity;

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

    void inject(GamesActivity gamesActivity);

    void inject(AbstractInteractor abstractInteractor);

    void inject(GamesInteractorImpl gamesInteractor);


}
