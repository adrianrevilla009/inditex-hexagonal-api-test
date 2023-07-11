package es.inditex.api;

import es.inditex.api.domain.ports.api.ProductServicePort;
import es.inditex.api.domain.ports.spi.ProductPersistencePort;
import es.inditex.api.domain.service.ProductServiceImpl;
import es.inditex.api.infraestructure.adapters.ProductJpaAdapter;
import es.inditex.api.infraestructure.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

}
