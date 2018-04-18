package com.musclr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories("com.musclr.repositories")
public class MusclrNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusclrNeo4jApplication.class, args);
	}
}
