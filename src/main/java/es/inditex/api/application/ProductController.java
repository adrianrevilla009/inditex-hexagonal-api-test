package es.inditex.api.application;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.domain.ports.api.ProductServicePort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductServicePort productServicePort;

    @GetMapping("/byBrandProductAndDate")
    public ProductDto getProductByBrandProductAndDate(@RequestBody ProductDto productDto) {
        return productServicePort.getProductByBrandProductAndDate(productDto.getProductId(),
                productDto.getBrandId(), productDto.getStartDate());
    }
}
