package com.osumba.userservice;

import com.osumba.userservice.entity.Address;
import com.osumba.userservice.entity.User;
import com.osumba.userservice.enumer.UserRole;
import com.osumba.userservice.repository.AddressRepository;
import com.osumba.userservice.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

	@Bean
	CommandLineRunner commandLineRunner(AddressRepository addressRepository, UserRepository userRepository) {
		return args -> {

			Address address1 = Address.builder()
					.street("Hassan II")
					.immNumber("Residence 22")
					.houseNumber("Apt 12")
					.zipCode(10001)
					.build();

			Address address2 = Address.builder()
					.street("Hassan II")
					.immNumber("Residence 23")
					.houseNumber("Apt 22")
					.zipCode(10002)
					.build();
			addressRepository.save(address1);
			addressRepository.save(address2);

			User user1 = User.builder()
					.firstName("Daniel")
					.lastName("Paulino")
					.email("daniel@gmail.com")
					.password("admin")
					.userRole(UserRole.ADMIN)
					.address(address1) // Associa um endereço
					.build();

			User user2 = User.builder()
					.firstName("Armando")
					.lastName("Isabel")
					.email("armando@gmail.com")
					.password("user")
					.userRole(UserRole.CUSTOMER)
					.address(address2) // Mesmo endereço associado
					.build();

			userRepository.saveAll(List.of(user1, user2));
		};
	}
}