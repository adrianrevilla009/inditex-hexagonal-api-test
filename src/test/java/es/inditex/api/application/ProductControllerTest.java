package es.inditex.api.application;

import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;
import es.inditex.api.domain.ports.api.ProductServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.verify;

public class ProductControllerTest {

    @Mock
    private ProductServicePort productServicePort;

    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productController = new ProductController(productServicePort);
    }

    @Test
    public void testGetProductByBrandProductAndDate() {
        ProductRequestDto requestDto = ProductRequestDto.builder()
                .productId(1L)
                .brandId(1L)
                .build();

        ResponseEntity response = productController.getProductByBrandProductAndDate(requestDto);

        verify(productServicePort).getProductByBrandProductAndDate(requestDto);
    }
}
