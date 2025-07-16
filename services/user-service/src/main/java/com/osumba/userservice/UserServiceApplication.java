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

import java.util.Date;
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


			User user1 = User.builder()
					.firstName("Daniel")
					.lastName("Paulino")
					.email("daniel@gmail.com")
					.password("admin")
					.userRole(UserRole.ADMIN)
					.birthDate(new Date())
					.isActive(true)
					.build();

			User user2 = User.builder()
					.firstName("Armando")
					.lastName("Isabel")
					.email("armando@gmail.com")
					.password("user")
					.userRole(UserRole.CUSTOMER)
					.birthDate(new Date())
					.isActive(true) // Mesmo endereço associado
					.build();

			userRepository.saveAll(List.of(user1, user2));


			Address address1 = Address.builder()
					.country("Angola")
					.city("Luanda")
					.state("Angolano")
					.street("Hassan II")
					.immNumber("Residence 22")
					.houseNumber("Apt 12")
					.zipCode(10001)
					.user(user1)
					.build();

			Address address2 = Address.builder()
					.country("Portugal")
					.city("Lisboa")
					.state("Tuga")
					.street("Hassan II")
					.immNumber("Residence 23")
					.houseNumber("Apt 22")
					.zipCode(10002)
					.user(user2)
					.build();
			addressRepository.save(address1);
			addressRepository.save(address2);


		};
	}
}