package es.inditex.api.configuration;

import es.inditex.api.domain.ports.api.ProductServicePort;
import es.inditex.api.domain.ports.spi.ProductPersistencePort;
import es.inditex.api.domain.service.ProductServiceImpl;
import es.inditex.api.domain.service.mapper.ProductDtoMapper;
import es.inditex.api.domain.service.mapper.ProductDtoMapperImpl;
import es.inditex.api.infraestructure.adapters.ProductJpaAdapter;
import es.inditex.api.infraestructure.mappers.ProductMapper;
import es.inditex.api.infraestructure.mappers.ProductMapperImpl;
import es.inditex.api.infraestructure.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ProductConfig {

    @Bean
    public ProductPersistencePort productPersistence(ProductRepository productRepository,
                                                     ProductMapper productMapper){
        return new ProductJpaAdapter(productRepository, productMapper);
    }

    @Bean
    public ProductServicePort productService(ProductPersistencePort productPersistencePort,
                                             ProductDtoMapper productDtoMapper){
        return new ProductServiceImpl(productPersistencePort, productDtoMapper);
    }

    @Bean
    public ProductDtoMapper productDtoMapper(){
        return new ProductDtoMapperImpl();
    }

    @Bean
    public ProductMapper productMapper(){
        return new ProductMapperImpl();
    }
}
