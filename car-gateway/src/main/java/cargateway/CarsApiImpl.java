package cargateway;

import org.openapitools.api.CarsApi;
import org.openapitools.model.GenericCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CarsApiImpl implements CarsApi {
    @Autowired
    private MazdaClient mazdaClient;
    @Override
    public ResponseEntity<Void> postCar(Map<String, Object> map) {
        if (map.get("make").equals("mazda")) {
            mazdaClient.post(map);
        }
        return ResponseEntity.ok(null);
    }
}
