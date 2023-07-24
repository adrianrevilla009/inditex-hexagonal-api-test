package es.inditex.api.infraestructure.repository;

import es.inditex.api.infraestructure.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM Product p WHERE p.product_id = :productId AND p.brand_id = :brandId " +
            "AND :applicationDate BETWEEN p.start_date AND p.end_date ORDER BY p.priority LIMIT 1",
            nativeQuery = true)
    Optional<Product> getProductByBrandProductAndDate(@Param("productId") Long productId,
                                             @Param("brandId") Long brandId,
                                             @Param("applicationDate") LocalDateTime applicationDate);
}
