package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.Order;
import com.example.demo.entities.OrderStatus;
import com.example.demo.entities.User;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null,"João Depollo","joao@gmail.com","9888888","12345");
		User u2 = new User(null,"Riverton Mendes","relampago@gmail.com","2832433","54321");
		Order o1 = new Order(null,Instant.parse("2019-06-10T19:53:07Z"),OrderStatus.CANCELED,u1 );
		Order o2 = new Order(null,Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.DELIVERED,u2 );
		Order o3 = new Order(null,Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.SHIPPED ,u1 );
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
