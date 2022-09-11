package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.repositories.UserRepository;
import com.example.demo.entities.User;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null,"João Depollo","joao@gmail.com","9888888","12345");
		User u2 = new User(null,"Riverton Mendes","relampago@gmail.com","2832433","54321");
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
	
}
