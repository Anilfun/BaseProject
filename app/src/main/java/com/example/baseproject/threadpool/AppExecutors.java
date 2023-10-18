package com.example.baseproject.threadpool;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class AppExecutors {

    private static volatile AppExecutors instance;

    public static AppExecutors get() {
        if (instance == null) {
            synchronized (AppExecutors.class) {
                if (instance == null) {
                    instance = new AppExecutors();
                }
            }
        }
        return instance;
    }

    private final static int NETWORK_THREAD_NUM = 3;
    private final static int WORK_THREAD_NUM = 2;

    private final Executor mDiskIO;
    private final Executor mNetworkIO;
    private final Executor mWorkThread;
    private final ScheduledExecutorService mScheduled;

    private final Handler mMainHandler;

    private AppExecutors() {
        this.mDiskIO = Executors.newCachedThreadPool();
        this.mNetworkIO = Executors.newCachedThreadPool();
        this.mWorkThread = Executors.newCachedThreadPool();
        this.mScheduled = Executors.newScheduledThreadPool(WORK_THREAD_NUM);
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * 数据库、硬盘操作线程池
     */
    public Executor diskIO() {
        return mDiskIO;
    }

    /**
     * 网络操作线程池
     */
    public Executor networkIO() {
        return mNetworkIO;
    }

    /**
     * 其他操作线程池
     */
    public Executor workThread() {
        return mWorkThread;
    }

    public ScheduledExecutorService scheduled() {
        return mScheduled;
    }

    public Handler mainThread() {
        return mMainHandler;
    }
}
