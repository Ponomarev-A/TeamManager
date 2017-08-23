package ru.ponomarev.teammanager.data.threading;

import android.os.Handler;
import android.os.Looper;

import ru.ponomarev.teammanager.domain.executor.IMainThread;


/**
 * This class makes sure that the runnable we provide will be run on the main UI thread.
 */
public class MainThreadImpl implements IMainThread {

    private static IMainThread sMainThread;

    private Handler mHandler;

    private MainThreadImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static IMainThread getInstance() {
        if (sMainThread == null) {
            sMainThread = new MainThreadImpl();
        }

        return sMainThread;
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }
}
