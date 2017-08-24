package ru.ponomarev.teammanager.presentation.presenters.base;


import ru.ponomarev.teammanager.domain.executor.IExecutor;
import ru.ponomarev.teammanager.domain.executor.IMainThread;

/**
 * This is a base class for all presenters which are communicating with interactors. This base class will hold a
 * reference to the Executor and MainThread objects that are needed for running interactors in a background thread.
 */
public abstract class AbstractPresenter {

    protected IExecutor mExecutor;
    protected IMainThread mMainThread;

    public AbstractPresenter(IExecutor executor, IMainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
