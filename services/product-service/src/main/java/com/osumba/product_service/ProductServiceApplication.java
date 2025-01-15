package com.osumba.product_service;

import com.osumba.product_service.entity.CategoryProd;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.osumba.product_service.entity.Product;
import com.osumba.product_service.repository.CategoryRepository;
import com.osumba.product_service.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository, CategoryRepository categoryRepository) {
		return args -> {

			// Criação de categorias sem @Builder
			CategoryProd category1 = new CategoryProd();
			category1.setName("Legume");
			category1.setDescription("São compostos pelas raízes, tubérculos, frutos e caules");

			CategoryProd category2 = new CategoryProd();
			category2.setName("Perfumes");
			category2.setDescription("São misturas de óleos, álcool e água, cuja função é proporcionar uma agradável e duradoura fragrância");

			categoryRepository.save(category1);
			categoryRepository.save(category2);

			// Criação de produtos sem @Builder
			Product product1 = new Product();
			product1.setName("One millian");
			product1.setDescription("Perfume 24h");
			product1.setQuantityInStock(23);
			product1.setPrice(Math.random() * 2000);
			product1.setCategory(category2);

			Product product2 = new Product();
			product2.setName("Mandioca");
			product2.setDescription("Alimento com mais vitamina");
			product2.setQuantityInStock(23);
			product2.setPrice(Math.random() * 9000);
			product2.setCategory(category2);

			productRepository.saveAll(List.of(product1, product2));
		};
	}
}
