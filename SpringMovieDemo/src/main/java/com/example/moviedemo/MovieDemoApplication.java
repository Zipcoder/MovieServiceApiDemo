package com.example.moviedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieDemoApplication {

	private Logger logger = LoggerFactory.getLogger(MovieDemoApplication.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}

	@Bean
	public CommandLineRunner commandLineRunner(RestTemplate restTemplate){
		return args -> {
			Movie movie = restTemplate.getForObject("http://www.omdbapi.com/?i=tt3896198&apikey=bbbe6f76", Movie.class);
			logger.info("Title :" + movie.getTitle() + " ratings:" +movie.getRatings().size());
		};
	}



	public static void main(String[] args) {
		SpringApplication.run(MovieDemoApplication.class, args);
	}
}


