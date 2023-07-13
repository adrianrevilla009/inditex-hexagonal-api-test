package es.inditex.api.domain.service.mapper;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductDtoMapperTest {
    private ProductDtoMapper productDtoMapper = new ProductDtoMapperImpl();

    @Test
    public void testProductDtoToProductResponseDto() {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(1L);
        productDto.setBrandId(100L);
        productDto.setStartDate(LocalDateTime.of(2020, 1, 1, 12,0));
        productDto.setEndDate(LocalDateTime.of(2020, 1, 1, 12,0));
        productDto.setPriceList(1L);
        productDto.setPrice(9.99);

        ProductResponseDto responseDto = productDtoMapper.productDtoToProductResponseDto(productDto);

        assertEquals(productDto.getProductId(), responseDto.getProductId());
        assertEquals(productDto.getBrandId(), responseDto.getBrandId());
        assertEquals(productDto.getStartDate(), responseDto.getStartDate());
        assertEquals(productDto.getEndDate(), responseDto.getEndDate());
        assertEquals(productDto.getPriceList(), responseDto.getPriceList());
        assertEquals(productDto.getPrice(), responseDto.getPrice());
    }

    @Test
    public void testProductRequestDtoToProductDto() {
        ProductRequestDto requestDto = new ProductRequestDto();
        requestDto.setProductId(1L);
        requestDto.setBrandId(100L);
        requestDto.setStartDate(LocalDateTime.of(2020, 1, 1, 12,0));

        ProductDto productDto = productDtoMapper.productRequestDtoToProductDto(requestDto);

        assertEquals(requestDto.getProductId(), productDto.getProductId());
        assertEquals(requestDto.getBrandId(), productDto.getBrandId());
        assertEquals(requestDto.getStartDate(), productDto.getStartDate());
    }
}
