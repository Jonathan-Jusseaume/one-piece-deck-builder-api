package com.onepiecedeckbuilder;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class OnePieceCardGameDeckBuilderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnePieceCardGameDeckBuilderApplication.class, args);
        log.info("API is launched");
    }

}
