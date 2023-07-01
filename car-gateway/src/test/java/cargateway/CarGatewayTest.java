package cargateway;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CarGatewayTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MazdaClient mazdaClient;

    @Test
    public void testForwardingToMazdaService() throws Exception {
        this.mockMvc.perform(post("/cars").content("{\"make\": \"mazda\"}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Mockito.verify(mazdaClient, Mockito.times(1)).post(ArgumentMatchers.any());
    }
}
