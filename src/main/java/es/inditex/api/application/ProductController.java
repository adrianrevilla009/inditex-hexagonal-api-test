package es.inditex.api.application;

import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;
import es.inditex.api.domain.ports.api.ProductServicePort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductServicePort productServicePort;

    public ProductController(ProductServicePort productServicePort) {
        this.productServicePort = productServicePort;
    }

    @GetMapping("/byBrandProductAndDate")
    public ProductResponseDto getProductByBrandProductAndDate(@RequestBody ProductRequestDto productRequestDto) {
        return productServicePort.getProductByBrandProductAndDate(productRequestDto);
    }
}
