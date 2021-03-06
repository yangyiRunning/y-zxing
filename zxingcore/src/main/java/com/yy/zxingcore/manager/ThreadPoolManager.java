package com.yy.zxingcore.manager;

import android.support.annotation.NonNull;
import android.support.v4.util.LruCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yangyi 2018年08月05日15:47:13
 * <p>
 * wechat: yangyi_451686712
 */
public class ThreadPoolManager {

    private static ThreadPoolManager threadPoolManager;
    private ExecutorService singleThreadPool;

    public synchronized static ThreadPoolManager getInstance() {
        if (threadPoolManager == null) {
            threadPoolManager = new ThreadPoolManager();
        }
        return threadPoolManager;
    }

    private ThreadPoolManager() {
        initThreadPool();
    }

    private void initThreadPool() {
        singleThreadPool = new ThreadPoolExecutor(100,
                100,
                1000L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(128),
                Executors.defaultThreadFactory());
        ((ThreadPoolExecutor) singleThreadPool).allowCoreThreadTimeOut(true);
    }

    public void submitToPool(Runnable runnable) {
        if (runnable != null) {
            singleThreadPool.submit(runnable);
        }
    }

    public void shutdownPool() {
        singleThreadPool.shutdown();
    }
}
