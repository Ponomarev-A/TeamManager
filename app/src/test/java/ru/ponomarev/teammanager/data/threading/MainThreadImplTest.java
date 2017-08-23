package ru.ponomarev.teammanager.data.threading;

import ru.ponomarev.teammanager.domain.executor.IMainThread;

/**
 * @author Пономарев Андрей
 */
public class MainThreadImplTest implements IMainThread {

    @Override
    public void post(Runnable runnable) {
        runnable.run();
    }
}
