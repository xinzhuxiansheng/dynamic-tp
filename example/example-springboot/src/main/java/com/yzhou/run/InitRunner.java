package com.yzhou.run;

import com.yzhou.common.utils.CommonThreadPoolUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(InitRunner.class);


    @Override
    public void run(ApplicationArguments args) throws Exception {

        CommonThreadPoolUtils.initThreadPool();

        logger.info("InitRunner()执行完成");
    }
}
