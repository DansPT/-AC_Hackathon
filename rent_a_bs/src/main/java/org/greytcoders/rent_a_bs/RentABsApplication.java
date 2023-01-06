package org.greytcoders.rent_a_bs;

import org.greytcoders.rent_a_bs.models.Product;
import org.greytcoders.rent_a_bs.models.User;
import org.greytcoders.rent_a_bs.repositories.ProductsRepo;
import org.greytcoders.rent_a_bs.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentABsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentABsApplication.class, args);
	}

	@Autowired
	private ProductsRepo productsRepo;

	@Autowired
	private UserRepository userRepository;

	@Bean
	InitializingBean sendDatabase(){
		return () -> {
			productsRepo.save(new Product("Daniel", "Fernandes", "daniel_product", "Codfish Tester", "Loves to taste cods"));
			productsRepo.save(new Product("Hugo", "Mesquita", "hugo_product", "Bush trimmer", "Trims your bushes perfectly"));
			productsRepo.save(new Product("Caíque", "Xavier", "caique_product", "Rack cleaner", "Cleans the biggest of racks all by himself"));
			productsRepo.save(new Product("António", "Cabral", "antonio_product", "Milkman", "Delivers milk to your door in minutes"));
			productsRepo.save(new Product("João", "Carriço", "joao_product", "Spiritual Advisor", "Aligns all your chakras"));
		};
	}

	@Bean
	InitializingBean sendUserDB() {
		return () -> {
			userRepository.save(new User("João Messias", "testessss", "teste@gmail.com"));
			userRepository.save(new User("Cardas Messias", "fosgasseees", "cardas@do.com"));
		};
	}


}
