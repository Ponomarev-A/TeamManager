package ru.ponomarev.teammanager.presentation.presenters.base;

import com.arellomobile.mvp.MvpPresenter;

import ru.ponomarev.teammanager.presentation.ui.IBaseView;

/**
 * This is a base class for all presenters which are communicating with interactors. This base class will hold a
 * reference to the Executor and MainThread objects that are needed for running interactors in a background thread.
 */
public abstract class AbstractPresenter<T extends IBaseView> extends MvpPresenter<T> {
}
