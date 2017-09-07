package ru.ponomarev.teammanager.di.modules;

import javax.inject.Singleton;

import dagger.Component;
import ru.ponomarev.teammanager.presentation.presenters.base.AbstractPresenter;
import ru.ponomarev.teammanager.presentation.presenters.impl.GamesPresenterImpl;
import ru.ponomarev.teammanager.presentation.ui.IBaseView;
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
    void inject(AbstractPresenter<IBaseView> abstractPresenter);
    void inject(GamesPresenterImpl gamesPresenter);

}
