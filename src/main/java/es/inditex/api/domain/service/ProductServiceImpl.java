package es.inditex.api.domain.service;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.ports.api.ProductServicePort;
import es.inditex.api.domain.ports.spi.ProductPersistencePort;

import java.time.LocalDateTime;

public class ProductServiceImpl implements ProductServicePort {

    private ProductPersistencePort productPersistencePort;

    public ProductServiceImpl(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public ProductDto getProductByBrandProductAndDate(Long productId, Long brandId, LocalDateTime startDate) {
        return productPersistencePort.getProductByBrandProductAndDate(productId, brandId,  startDate);
    }
}
