package es.inditex.api.domain.service;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;
import es.inditex.api.domain.ports.api.ProductServicePort;
import es.inditex.api.domain.ports.spi.ProductPersistencePort;
import es.inditex.api.domain.service.mapper.ProductDtoMapper;
import es.inditex.api.infraestructure.mappers.ProductMapper;

import java.time.LocalDateTime;

public class ProductServiceImpl implements ProductServicePort {

    private ProductPersistencePort productPersistencePort;
    private ProductDtoMapper productDtoMapper;

    public ProductServiceImpl(ProductPersistencePort productPersistencePort,
                              ProductDtoMapper productDtoMapper) {
        this.productPersistencePort = productPersistencePort;
        this.productDtoMapper = productDtoMapper;
    }

    @Override
    public ProductResponseDto getProductByBrandProductAndDate(ProductRequestDto productRequestDto) {
        ProductDto productDto = productDtoMapper.productRequestDtoToProductDto(productRequestDto);
        ProductDto response = productPersistencePort.getProductByBrandProductAndDate(productDto.getProductId(),
                productDto.getBrandId(),  productDto.getStartDate());
        return response != null ? productDtoMapper.productDtoToProductResponseDto(response) : null;
    }
}
