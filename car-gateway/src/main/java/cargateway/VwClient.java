package cargateway;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("vw")
public interface VwClient {
    @PostMapping(path = "/cars")
    void post();
}
