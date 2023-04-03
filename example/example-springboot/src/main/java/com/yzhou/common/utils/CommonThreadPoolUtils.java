package com.yzhou.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 通用线程池
 */
public class CommonThreadPoolUtils {
    private static final Logger logger = LoggerFactory.getLogger(CommonThreadPoolUtils.class);

    private volatile static CommonThreadPoolUtils commonThreadPool;
    private static ExecutorService executorService;

//    private CommonThreadPool() {
//        executorService = Executors.newCachedThreadPool();
//    }

    public static CommonThreadPoolUtils getInstance() {
        if (commonThreadPool == null) {
            synchronized (CommonThreadPoolUtils.class) {
                if (commonThreadPool == null) {
                    commonThreadPool = new CommonThreadPoolUtils();
                }
            }
        }
        return commonThreadPool;
    }

    public static void initThreadPool() {
        if (commonThreadPool == null) {
            getInstance();
        }
        logger.info("通用线程池初始化");
//        executorService = Executors.newFixedThreadPool(100);
        executorService = new ThreadPoolExecutor(20, 300,
                1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(200, true),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }

    public static ExecutorService getThreadPool() {
        return executorService;
    }
}
