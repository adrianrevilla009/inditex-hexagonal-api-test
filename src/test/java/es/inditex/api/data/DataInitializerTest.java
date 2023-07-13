package es.inditex.api.data;

import es.inditex.api.infraestructure.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

public class DataInitializerTest {

    @Mock
    private ProductRepository productRepository;

    private DataInitializer dataInitializer;

    @Test
    public void testInit() {
        MockitoAnnotations.openMocks(this);
        dataInitializer = new DataInitializer(productRepository);

        dataInitializer.init();

        verify(productRepository).saveAll(anyList());
    }
}
