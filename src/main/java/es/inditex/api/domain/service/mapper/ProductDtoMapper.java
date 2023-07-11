package es.inditex.api.domain.service.mapper;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;

public interface ProductDtoMapper {

    ProductResponseDto productDtoToProductResponseDto(ProductDto productDto);

    ProductDto productRequestDtoToProductDto(ProductRequestDto productRequestDto);
}
