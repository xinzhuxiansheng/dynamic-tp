package com.yzhou.controller;

import com.dtp.core.DtpRegistry;
import com.dtp.core.support.runnable.NamedRunnable;
import com.dtp.core.thread.DtpExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yzhou
 * @date 2023/3/31
 */
@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test01")
    public String test01() {
        logger.info("TestController test01");
        return "OK";
    }

    @GetMapping("/test02")
    public String test() throws InterruptedException {
        task();
        return "success";
    }

    public void task() throws InterruptedException {
        DtpExecutor dtpExecutor2 = DtpRegistry.getDtpExecutor("dtpExecutor2");
        for (int i = 0; i < 100; i++) {
            Thread.sleep(100);
            dtpExecutor2.execute(NamedRunnable.of(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("i am dynamic-tp-test-2 task");
            }, "task-" + i));
        }
        //dtpExecutor2.shutdown();
    }
}
