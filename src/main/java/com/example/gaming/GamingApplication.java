package com.example.gaming;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class GamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Game that you want to run [Pacman -> 1, Mario -> 2, TempleRun -> 3, Default -> 0]: ");
			int choice = scanner.nextInt();

			Game game = switch (choice) {
                case 1 -> context.getBean(Pacman.class);
                case 2 -> context.getBean(Mario.class);
                case 3 -> context.getBean(TempleRun.class);
                default -> {
                    System.out.println("Running default game.");
                    yield context.getBean(Mario.class);
                }
            };

            GameRunner runner = context.getBean(GameRunner.class);
			runner.setGame(game);
			runner.run();
		};
	}
}
