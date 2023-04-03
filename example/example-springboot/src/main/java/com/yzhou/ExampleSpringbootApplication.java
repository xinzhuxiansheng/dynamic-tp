package com.yzhou;

import com.dtp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDynamicTp
@SpringBootApplication
public class ExampleSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleSpringbootApplication.class, args);
    }

}
