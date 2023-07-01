package cargateway;

import org.openapitools.model.GenericCar;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(name = "mazda", url = "http://localhost:8081")
public interface MazdaClient {
    @PostMapping(path = "/cars")
    void post(Map<String, Object> car);
}
