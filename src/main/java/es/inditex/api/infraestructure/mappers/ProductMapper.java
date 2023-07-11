package es.inditex.api.infraestructure.mappers;

import es.inditex.api.domain.data.ProductDto;
import es.inditex.api.infraestructure.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto productToProductDto(Product product);
}
