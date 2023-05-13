package com.example.app1singlePageApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App1SinglePageAppApplication  {
//	public class App4SinglePageAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(App1SinglePageAppApplication.class, args);
		System.out.println("App1SinglePageAppApplication started...");
	}
	
//	@Autowired
//	private UserRepository userRepository;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		this.userRepository.save(new User("Ravi", "twr", "ravi@gmail.com"));
//		this.userRepository.save(new User("Elon", "Musk", "elon@gmail.com"));
//	}

}
