package es.inditex.api.domain.ports.spi;

import es.inditex.api.domain.data.ProductDto;

import java.time.LocalDateTime;

public interface ProductPersistencePort {
    /**
     * Get a product given some entry params
     * @param productId
     * @param brandId
     * @param startDate
     * @return product data
     */
    ProductDto getProductByBrandProductAndDate(Long productId, Long brandId, LocalDateTime startDate);

}
