package com.osumba.product_service;

import com.osumba.product_service.entity.CategoryProd;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.osumba.product_service.entity.Product;
import com.osumba.product_service.repository.CategoryRepository;
import com.osumba.product_service.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Date;
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

			CategoryProd category3 = new CategoryProd();
			category3.setName("Phone");
			category3.setDescription("Novas versoes de iPone, com allta capacidade de...  ");

			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);


			// Criação de produtos sem @Builder

			List<Product> productList = List.of(

					Product.builder()
							.name("One millian")
							.description("Perfume 24h")
							.quantityInStock(23)
							.price(BigDecimal.valueOf(Math.random() * 2000))
			                .imageUrl("Photo")
							.dataAdded(new Date())
							.category(category2).build(),

					Product.builder()
							.name("Mandioca")
							.description("Alimento com mais vitamina")
							.quantityInStock(25)
							.price(BigDecimal.valueOf(Math.random() * 7000))
							.imageUrl("Photo")
							.dataAdded(new Date())
							.category(category1)
					.build(),

					Product.builder()
							.name("Ipone 15")
							.description("Telefone da apple com funcionamenntos de tecnologgias avançadas")
							.quantityInStock(14)
							.price(BigDecimal.valueOf(Math.random() * 1000))
							.imageUrl("Photo")
							.dataAdded(new Date())
							.category(category3)
							.build()
			);
			productRepository.saveAll(productList);
		};
	}
}
