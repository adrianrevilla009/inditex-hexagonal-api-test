package es.inditex.api.infraestructure.adapters;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.ports.spi.ProductPersistencePort;
import es.inditex.api.infraestructure.entity.Product;
import es.inditex.api.infraestructure.mappers.ProductMapper;
import es.inditex.api.infraestructure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductJpaAdapter implements ProductPersistencePort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductDto getProductByBrandProductAndDate(Long productId, Long brandId, LocalDateTime startDate) {

        Optional<Product> product = productRepository.getProductByBrandProductAndDate(productId, brandId, startDate.toString());

        if (product.isPresent()) {
            return ProductMapper.INSTANCE.productToProductDto(product.get());
        }

        return null;
    }
}
