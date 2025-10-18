package com.packt.timeline;

import com.packt.timeline.domain.MatchEvent;

import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TimelineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimelineApplication.class, args);
	}

  @Bean
  public Consumer<MatchEvent> processMatchEvent() {
    return value -> {
      System.out.println("Processing MatchEvent: " + value.type());
    };
  }

}
