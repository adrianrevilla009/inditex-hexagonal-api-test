package es.inditex.api.configuration;

import es.inditex.api.domain.ports.api.ProductServicePort;
import es.inditex.api.domain.ports.spi.ProductPersistencePort;
import es.inditex.api.domain.service.ProductServiceImpl;
import es.inditex.api.infraestructure.adapters.ProductJpaAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ProductConfig {

    @Bean
    public ProductPersistencePort productPersistence(){
        return new ProductJpaAdapter();
    }

    @Bean
    public ProductServicePort productService(){
        return new ProductServiceImpl(productPersistence());
    }
}
