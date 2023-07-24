package es.inditex.api.infraestructure.adapters;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.ports.spi.ProductPersistencePort;
import es.inditex.api.infraestructure.entity.Product;
import es.inditex.api.infraestructure.mappers.ProductMapper;
import es.inditex.api.infraestructure.repository.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ProductJpaAdapter implements ProductPersistencePort {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductJpaAdapter(ProductRepository productRepository,
                             ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto getProductByBrandProductAndDate(Long productId, Long brandId, LocalDateTime applicationDate) {

        Optional<Product> product = productRepository.getProductByBrandProductAndDate(productId, brandId, applicationDate);

        if (product.isPresent()) {
            return productMapper.productToProductDto(product.get());
        }

        return null;
    }
}
