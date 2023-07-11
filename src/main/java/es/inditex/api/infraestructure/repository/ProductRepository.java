package es.inditex.api.infraestructure.repository;

import es.inditex.api.infraestructure.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM Product p WHERE p.productId = :productId AND p.brandId = :brandId " +
            "AND p.startDate = :startDate",
            nativeQuery = true)
    Optional<Product> getProductByBrandProductAndDate(@Param("productId") Long productId,
                                             @Param("brandId") Long brandId,
                                             @Param("startDate") String startDate);
}
