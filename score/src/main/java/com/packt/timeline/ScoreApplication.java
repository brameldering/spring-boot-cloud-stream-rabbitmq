package com.packt.timeline;

import com.packt.timeline.domain.MatchEvent;

import java.util.Random;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScoreApplication {

  public static final Logger logger = LoggerFactory.getLogger(ScoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ScoreApplication.class, args);
	}

  @Bean
  public Consumer<MatchEvent> processGoals() {
    Random random = new Random();
    return value -> {
      if (random.nextInt(0,10) < 8) {
        logger.error("Problem occurs");
        throw new RuntimeException("Error processing goal");
      }
      logger.info("Processing goal from player {} at {} ", value.player1(), value.eventTime());
    };
  }

}
