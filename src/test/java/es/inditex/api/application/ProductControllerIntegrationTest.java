package es.inditex.api.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.inditex.api.domain.data.request.ProductRequestDto;
import es.inditex.api.domain.data.response.ProductResponseDto;
import es.inditex.api.domain.ports.api.ProductServicePort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductServicePort productServicePort;

    @Test
    public void testGetProductByBrandProductAndDate() throws Exception {
        ProductRequestDto requestDto = ProductRequestDto.builder()
                 .productId(1L)
                 .brandId(1L)
                 .build();

        ProductResponseDto responseDto = ProductResponseDto.builder()
                .productId(1L)
                .brandId(1L)
                .build();;

        when(productServicePort.getProductByBrandProductAndDate(requestDto)).thenReturn(responseDto);

        mockMvc.perform(get("/product/byBrandProductAndDate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(responseDto)));
    }

    private static String asJsonString(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
