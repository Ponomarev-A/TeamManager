package ru.ponomarev.teammanager.presentation.presenters.base;


import javax.inject.Inject;

import ru.ponomarev.teammanager.domain.executor.IExecutor;
import ru.ponomarev.teammanager.domain.executor.IMainThread;

/**
 * This is a base class for all presenters which are communicating with interactors. This base class will hold a
 * reference to the Executor and MainThread objects that are needed for running interactors in a background thread.
 */
public abstract class AbstractPresenter {

    @Inject
    public IExecutor mExecutor;

    @Inject
    public IMainThread mMainThread;
}
